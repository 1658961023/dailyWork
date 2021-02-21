package 课堂作业Rectangle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RotateRectangle extends Application {
	int i=0;
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		Rectangle rectangle = new Rectangle(200,200, 150, 100);
		rectangle.setStroke(Color.GREEN);
		rectangle.setFill(Color.WHITE);
		Button btRotate = new Button("Rotate");
		btRotate.setOnAction(e -> RecRotate(rectangle));
		pane.getChildren().addAll(rectangle, btRotate);
		Scene scene = new Scene(pane, 500, 500);
		primarystage.setTitle("旋转矩形");
		primarystage.setScene(scene);
		primarystage.show();
	}

	private void RecRotate(Rectangle r) {
		// TODO Auto-generated method stub
		i+=10;
		r.setRotate(i);
		;
	}
}
