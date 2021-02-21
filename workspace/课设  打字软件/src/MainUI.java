
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUI extends Application{
public static void main(String[] args) {
	Application.launch(args);
}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		VBox pane=new VBox(100);
		pane.setStyle("-fx-background-color: green");
		Button start=new Button("开始");
		start.setPrefHeight(60);
		start.setPrefWidth(100);
		start.setOnAction(e->{
			TypeUI typeui=new TypeUI();
			typeui.showUI();
		});
		Button exit=new Button("退出");
		exit.setOnAction(e->{
			java.lang.System.exit(0);
		});
		exit.setPrefHeight(60);
		exit.setPrefWidth(100);
		pane.getChildren().addAll(start,exit);
		pane.setAlignment(Pos.BOTTOM_CENTER);
		Scene scene=new Scene(pane,500,300);
		arg0.setTitle("打字软件");
		arg0.setScene(scene);
		arg0.show();
	}

}
