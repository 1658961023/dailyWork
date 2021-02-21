import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NullWindow {
public void show(){
	Stage nullTip=new Stage();
	Text tip=new Text();
	tip.setText("所选文件为空！！");
	VBox pane = new VBox();
	pane.setBackground(new Background(new BackgroundFill(Color.DIMGRAY, null, null)));;
	pane.getChildren().add(tip);
	pane.setAlignment(Pos.CENTER);
	Scene scene=new Scene(pane,500,300);
	nullTip.setTitle("错误");
	nullTip.setScene(scene);
	nullTip.show();
}
}
