package 实验八;


import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainTest extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane pane = new BorderPane();
		Pane north = new Pane();
		Line lineX = new Line(50, 0, 50, 600);
		Line lineY = new Line(50, 600, 1450, 600);
		lineX.setStroke(Color.GREEN);
		lineX.setStrokeWidth(3);
		lineY.setStroke(Color.RED);
		lineY.setStrokeWidth(3);
		TextArea ta = new TextArea();
		Label label3 = new Label("输入文件名", ta);
		label3.setContentDisplay(ContentDisplay.BOTTOM);
		ta.setPrefColumnCount(60);
		ta.setPrefRowCount(1);
		ta.setWrapText(true);
		ta.setFont(Font.font(20));
		ta.setStyle("-fx-text-fill:black");
		ta.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER)
				try {
					File file=new File(ta.getText());
					CalLetters letters=new CalLetters(file.getString(file.getFileName()));
					setHeights(letters.getLetters(letters.getStr()), north);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		});
		north.getChildren().addAll(lineX, lineY);
		Pane sorth = new Pane(ta, label3);
		sorth.setPrefHeight(100);
		sorth.setPrefWidth(1500);
		pane.setCenter(north);
		pane.setBottom(sorth);
		BorderPane.setAlignment(sorth, Pos.CENTER);
		Scene scene = new Scene(pane, 1500, 1000);
		primaryStage.setScene(scene);
		primaryStage.setTitle("字母统计图");
		primaryStage.show();
	}

	public void setHeights(int[] h, Pane pane) {
		String Xline = "";
		char ch = 'a';
		for (int i = 0; i < 26; i++) {
			Xline = Character.toString(ch);
			ch++;
			Rectangle rec = new Rectangle(50 + 50 * i, 600 - 10 * h[i], 40, 10 * h[i]);
			rec.setFill(Color.GREEN);
			Text text = new Text(70 + 50 * i, 620, Xline);
			text.setFont(Font.font(20));
			Text count = new Text(60 + 50 * i, 600 - 10 * h[i], "" + h[i]);
			pane.getChildren().addAll(rec, text, count);
		}
	}
}
