package javanet.l05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BusSearchClient extends Application {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		Pane root = new Pane();
		drawSearch(root);
		Scene scene = new Scene(root, 800, 600);
		stage.setTitle("公交查询");
		stage.setScene(scene);
		stage.show();
	}

	private void drawSearch(Pane root) {
		TextField search_tf = new TextField();
		Button search_bt = new Button("查询");
		search_bt.setLayoutX(200);
		search_bt.setOnAction(e -> {
			Socket socket;
			try {
				socket = new Socket("localhost", 1234);
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println(search_tf.getText());
				pw.flush();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String step = br.readLine();
				for (int i = 0; i < step.split("-").length; i++) {
					System.out.println(step.split("-")[i]);
				}
				byte[] buf = search_tf.getText().getBytes();
				DatagramSocket socketUdp = new DatagramSocket();
				DatagramPacket request = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 1234);
				DatagramPacket response = new DatagramPacket(new byte[64], 64);
				request.setData(buf);
				socketUdp.send(request);
				socketUdp.receive(response);
				String bus = new String(response.getData());
				System.out.println(bus);
				drawRouteAndBus(root, step, bus);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		root.getChildren().addAll(search_tf, search_bt);
	}

	private void drawRouteAndBus(Pane pane, String step, String buses) {
		// TODO Auto-generated method stub
		pane.getChildren().clear();
		drawSearch(pane);

		System.out.println(step.split("-").length);
		if (step.split("-").length == 1) {
			Text t = new Text(300, 200, "没有此线路信息！！！");
			t.setFill(Color.RED);
			pane.getChildren().add(t);
		} else {
			Rectangle r = new Rectangle(800, 50, Color.AQUAMARINE);
			r.setLayoutY(120);
			Rectangle r2 = new Rectangle(800, 10, Color.YELLOW);
			r2.setLayoutY(140);
			pane.getChildren().addAll(r, r2);
			for (int i = 0; i < step.split("-").length; i++) {
				Text t = new Text(20 + (750 / step.split("-").length) * i, 100, i + 1 + "");
				Circle c = new Circle(25 + (750 / step.split("-").length) * i, 145, 10);
				c.setFill(Color.YELLOW);
				Text t2 = new Text(step.split("-")[i]);
				t2.setLayoutX(20 + (750 / step.split("-").length) * i);
				t2.setLayoutY(200);
				t2.setFill(Color.MEDIUMBLUE);
				t2.setWrappingWidth(10);
				pane.getChildren().addAll(t, c, t2);
			}
			for (int j = 0; j < buses.split(",").length; j++) {
				int postion = Integer.parseInt(buses.split(",")[j].trim());
				Rectangle bus = new Rectangle(20, 20, Color.RED);
				bus.setLayoutX(20 + (750 / step.split("-").length) * (postion - 1));
				bus.setLayoutY(60);
				pane.getChildren().add(bus);
			}
		}

	}
}
