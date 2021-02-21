import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Test extends Application {
	public void start(Stage primaryStage) {
		Circle circle = new Circle();
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		circle.setStroke(Color.GREEN);
		circle.setFill(Color.WHITE);

		Button button = new Button("OK");
		StackPane pane = new StackPane();
		pane.getChildren().add(circle);
		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("My first JavaFX program");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
