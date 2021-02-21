package javanet.c03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Homework3_3_Client extends Application {
	private int flag = 0;

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Application.launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("计算任意个数的和、平均数、方差");
		VBox root = new VBox();
		Label nums_lb = new Label("输入数字(逗号隔开！)");
		TextField nums = new TextField();
		nums.setPromptText("输入任意个数(逗号隔开！)");
		Label sum_lb = new Label("数字和为：");
		TextField sum_tf = new TextField();
		Label avg_lb = new Label("平均数为：");
		TextField avg_tf = new TextField();
		Label var_lb = new Label("方差为：");
		TextField var_tf = new TextField();
		Button bt = new Button("开始计算");
		root.getChildren().addAll(nums_lb, nums);
		root.getChildren().addAll(sum_lb, sum_tf);
		root.getChildren().addAll(avg_lb, avg_tf);
		root.getChildren().addAll(var_lb, var_tf);
		root.getChildren().add(bt);
		Scene scene = new Scene(root, 500, 500, Color.ALICEBLUE);
		bt.setOnAction((ActionEvent e) -> {
			try {
				Socket socket = new Socket("localhost", 1234);
				String str = nums.getText();
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				System.out.println(str);
				pw.println(str);
				pw.flush();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String result = null;
				int line = 0;
				while ((result = br.readLine()) != null) {
					if (line == 0)
						sum_tf.setText(result);
					if (line == 1)
						avg_tf.setText(result);
					if (line == 2)
						var_tf.setText(result);
					line++;
				}
				pw.close();
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			flag++;
			if (flag == 3) {
				nums.setText("接受完三轮数据,连接关闭...请关闭程序");
				nums.setEditable(false);
				System.exit(0);
			}
			System.out.println(flag);
		});
		stage.setScene(scene);
		stage.show();
	}

}
