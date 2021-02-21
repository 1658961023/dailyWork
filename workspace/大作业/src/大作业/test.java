package 大作业;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application {

	static UI ui = new UI();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(ui, 500, 1000);
		primaryStage.setTitle("电梯");
		primaryStage.setScene(scene);
		primaryStage.show();
		Control control = new Control(ui);
		System.out.println("ID\tAge\tComingTime\tSF\tDF\tLeaveTime");
		control.getInfo();
		control.sortForTime();
		control.run();
		ui.play();
	}

	public static void main(String[] args) throws Exception {
		Application.launch(args);

	}

}
