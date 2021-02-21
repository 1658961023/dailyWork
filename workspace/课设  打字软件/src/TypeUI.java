import java.io.File;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TypeUI {
	private String[] Articles = { "Ӣ������1", "Ӣ������2", "Ӣ������3", "Ӣ������4", "test", "ͯȤ", "��ɫ��", "��һ������" };
	private TextArea tx1;
	private TextArea tx2;
	private ReadFile readfile;

	public void showUI() {
		Stage arg0 = new Stage();
		VBox pane = new VBox(20);// �������������ı���Ĳ���
		pane.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
		pane.setAlignment(Pos.TOP_RIGHT);
		ComboBox<String> choice = new ComboBox<>();// ����ѡ�����µĸ�ѡ��
		choice.setPrefWidth(1400);
		ObservableList<String> articles = FXCollections.observableArrayList(Articles);
		choice.getItems().addAll(articles);
		choice.setStyle("-fx-color:gray");
		choice.prefWidthProperty().bind(pane.widthProperty().multiply(0.85));

		Label lb = new Label("ѡ�񱾵����£�", choice);// ��ѡ���ǩ
		lb.setTextFill(Color.BLUEVIOLET);
		lb.setContentDisplay(ContentDisplay.RIGHT);
		Button fileChoser_bt = new Button("����ļ�");// �����ļ�ѡ��������
		fileChoser_bt.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		HBox pane2 = new HBox();
		pane2.getChildren().addAll(fileChoser_bt, choice, lb);// �������ð�ť�͸�ѡ��Ĳ���
		pane.getChildren().add(pane2);

		tx1 = new TextArea();// �������ģ���ı����ı���
		tx1.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
		tx1.setEditable(false);
		tx1.setPrefColumnCount(50);
		tx1.setWrapText(true);
		tx1.setFont(Font.font("KaiTi", FontPosture.ITALIC, 50));
		ScrollPane scrollpane1 = new ScrollPane(tx1);
		scrollpane1.setStyle("-fx-background-color:blue");
		scrollpane1.setPrefSize(1500, 500);
		tx1.prefWidthProperty().bind(scrollpane1.widthProperty());
		tx1.prefHeightProperty().bind(scrollpane1.heightProperty());

		tx2 = new TextArea();// ���������ı���
		tx2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
		tx2.setPrefColumnCount(50);
		tx2.setWrapText(true);
		tx2.setFont(Font.font("KaiTi", FontPosture.ITALIC, 50));
		ScrollPane scrollpane2 = new ScrollPane(tx2);
		scrollpane2.setPrefSize(1500, 400);
		tx2.prefWidthProperty().bind(scrollpane2.widthProperty());
		tx2.prefHeightProperty().bind(scrollpane2.heightProperty());

		TextField rate_tf = new TextField();// �����ȷ�ʵ��ı���
		rate_tf.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		rate_tf.setEditable(false);
		Label rate_lb = new Label("��ǰ��ȷ��:", rate_tf);
		Label percent = new Label("%", rate_tf);
		rate_lb.setAlignment(Pos.TOP_RIGHT);
		percent.setAlignment(Pos.TOP_LEFT);

		TextField speed_tf = new TextField();// ��Ŵ����ٶȵ��ı���
		speed_tf.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		speed_tf.setEditable(false);
		Label speed_lb = new Label("�����ٶ�:", speed_tf);
		Label speed = new Label("��/����", speed_tf);
		speed_lb.setAlignment(Pos.TOP_RIGHT);
		speed.setAlignment(Pos.TOP_LEFT);

		HBox hbox = new HBox();// ������ȷ�ʺʹ����ٶ��ı���Ĳ���
		hbox.getChildren().addAll(rate_tf, rate_lb, percent, speed_tf, speed_lb, speed);
		pane.getChildren().addAll(scrollpane1, scrollpane2, hbox);

		Cal_RightRate rate = new Cal_RightRate(tx1, tx2, rate_tf);// ����������ȷ�ʵ���
		Cal_TypeSpeed typeSpeed = new Cal_TypeSpeed(tx1, tx2, speed_tf, false);// ������������ٶȵ���
		Result_Window result = new Result_Window(rate_tf, speed_tf);// ������ʾ���ֽ������

		fileChoser_bt.setOnAction(e -> {//�ļ�ѡ������ť�¼�
			FileChooser fileChoser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXt", ".txt");
			fileChoser.getExtensionFilters().add(extFilter);
			
			File file = new FileChooser().showOpenDialog(arg0);

			ReadFile readfile2 = new ReadFile();
			readfile2.setFilename(file.getAbsolutePath());
			try {
				String str=new String(readfile2.read());
				if (str.length()!=0) {
					tx1.setText(str);
					tx2.setText("");
					tx2.setEditable(true);
					tx2.textProperty().addListener(new ChangeListener<String>() {
						@Override
						public void changed(ObservableValue<? extends String> observable, String oldValue,
								String newValue) {
							typeSpeed.setFirst(true);
							String typeSound = getClass().getResource("type.wav").toString();//��Ч
							Media sound = new Media(typeSound);
							MediaPlayer player = new MediaPlayer(sound);
							player.play();							
							typeSpeed.getTypeSpeed();
							rate.getRightRate();
							if ((tx1.getText().length() - 1) == tx2.getText().length()) {
								tx2.setEditable(false);
								result.show();
							}
						}
					});
				} else {
				NullWindow nullWindow = new NullWindow();
					nullWindow.show();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("�ļ�Ϊ��");
			}
		});
		
		choice.setOnAction(e -> {//��ѡ��ť�¼�
			try {
				Chose(articles.indexOf(choice.getValue()));
				tx2.setEditable(true);
				tx2.setText("");
				tx2.textProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
						typeSpeed.setFirst(true);
						String typeSound = getClass().getResource("type.wav").toString();//������Ч
						Media sound = new Media(typeSound);
						MediaPlayer player = new MediaPlayer(sound);
						player.play();
						
						typeSpeed.getTypeSpeed();//ͳ�ƴ����ٶ�
						rate.getRightRate();//ͳ�ƴ�����ȷ��
						if ((tx1.getText().length() - 1) == tx2.getText().length()) {
							tx2.setEditable(false);
							result.show();
						}
					}
				});
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Scene scene = new Scene(pane, 1500, 800);
		arg0.setTitle("������ϰ��......");
		arg0.setScene(scene);
		arg0.show();
	}

	public void Chose(int index) throws IOException {
		this.readfile = new ReadFile();
		switch (index) {
		case 0:
			this.readfile.setFilename("d:\\Text\\text1.txt");
			tx1.setText(this.readfile.read());
			tx2.setEditable(true);
			tx2.setText("");
			break;
		case 1:
			this.readfile.setFilename("d:\\Text\\text2.txt");
			tx1.setText(this.readfile.read());
			tx2.setEditable(true);
			tx2.setText("");
			break;
		case 2:
			this.readfile.setFilename("d:\\Text\\text3.txt");
			tx1.setText(this.readfile.read());
			tx2.setEditable(true);
			tx2.setText("");
			break;
		case 3:
			this.readfile.setFilename("d:\\Text\\text4.txt");
			tx1.setText(this.readfile.read());
			tx2.setEditable(true);
			tx2.setText("");
			break;
		case 4:
			this.readfile.setFilename("d:\\Text\\test.txt");
			tx1.setText(this.readfile.read());
			tx2.setEditable(true);
			tx2.setText("");
			break;
		case 5:
			this.readfile.setFilename("d:\\Text\\ͯȤ.txt");
			tx1.setText(this.readfile.read());
			tx2.setEditable(true);
			tx2.setText("");
			break;
		case 6:
			this.readfile.setFilename("d:\\Text\\��ɫ��.txt");
			tx1.setText(this.readfile.read());
			tx2.setEditable(true);
			tx2.setText("");
			break;
		case 7:
			this.readfile.setFilename("d:\\Text\\��һ������.txt");
			tx1.setText(this.readfile.read());
			tx2.setEditable(true);
			tx2.setText("");
			break;
		}
	}

}