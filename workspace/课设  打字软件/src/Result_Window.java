import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Result_Window {
private TextField rate_tf;
private TextField speed_tf;
public Result_Window(TextField rate_tf,TextField speed_tf){
	this.rate_tf=rate_tf;
	this.speed_tf=speed_tf;
}
public void show(){
	Stage stage = new Stage();
	Text tip=new Text();
	tip.setText("恭喜你！！完成本次打字练习");
	Text grade=new Text();
	grade.setText("你的正确率为："+rate_tf.getText()+"%你的打字速度为："+speed_tf.getText()+"字/分钟");
	Button ok=new Button("确定");
	ok.setOnAction(e->stage.close());
	VBox pane=new VBox();
	pane.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));;
	pane.getChildren().addAll(tip,grade,ok);
	pane.setAlignment(Pos.CENTER);
	Scene scene=new Scene(pane,500,300);
	stage.setTitle("打字完成");
	stage.setScene(scene);
	stage.show();
}
}
