package javanet.c04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Homework4_3_Client extends Application {

	private Map<Integer, Boolean> result = new HashMap<>();
	int index = 0;
	String question = "";

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		DatagramSocket socket = new DatagramSocket();

		stage.setTitle("答题客户端");
		VBox root = new VBox();
		Label question_lb = new Label("考题");
		TextField question_tf = new TextField();
		question_tf.setEditable(false);
		Label answer_lb = new Label("输入你的的答案");
		TextField answer_tf = new TextField();
		Button bt_submit = new Button("提交答案");
		Button bt_next = new Button("下一题");
		Button bt_end = new Button("结束答题");
		root.getChildren().addAll(question_lb, question_tf, answer_lb, answer_tf, bt_submit, bt_next, bt_end);

		bt_next.setDisable(true);
		bt_end.setDisable(true);
		question = sendRequest(socket);
		question_tf.setText(question.split(",")[0]);

		bt_submit.setOnAction((ActionEvent e) -> {
			if (answer_tf.getText().equals(question.split(",")[1])) {
				result.put(index, true);
				index++;
			} else {
				result.put(index, false);
				index++;
			}
			bt_submit.setDisable(true);
			bt_next.setDisable(false);
			bt_end.setDisable(false);
		});

		bt_next.setOnAction((ActionEvent e) -> {
			try {
				question = sendRequest(socket);
				answer_tf.clear();
				question_tf.setText(question.split(",")[0]);
				bt_submit.setDisable(false);
				bt_next.setDisable(true);
				bt_end.setDisable(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		bt_end.setOnAction((ActionEvent e) -> {
			showResult();
			bt_end.setDisable(true);
			bt_submit.setDisable(true);
			bt_next.setDisable(true);
			socket.close();
		});
		Scene scene = new Scene(root, 500, 500, Color.ALICEBLUE);
		stage.setScene(scene);
		stage.show();
	}

	private void showResult() {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
		TextArea ta=new TextArea();
		ta.setText("完成本次答题,答题情况如下:\n"+result.toString()+"\n正确率:"+getCorrectRate()+"%");
		ta.setEditable(false);
		Button ok=new Button("确定");
		ok.setOnAction(e->stage.close());
		VBox pane=new VBox();
		pane.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));;
		pane.getChildren().addAll(ta,ok);
		pane.setAlignment(Pos.CENTER);
		Scene scene=new Scene(pane,500,300);
		stage.setTitle("答题完成");
		stage.setScene(scene);
		stage.show();
	}

	public String sendRequest(DatagramSocket socket) throws IOException {
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024, InetAddress.getLocalHost(), 1234);
		socket.send(packet);
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		socket.receive(packet2);
		String info = new String(data2, 0, packet2.getLength());
		return info;
	}
	
	public float getCorrectRate(){
		float right=0;
		for(int i=0;i<result.size();i++){
			if(result.get(i)){
				right++;
			}
		}
		return right/result.size();		
	}

}
