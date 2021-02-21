package javanet.l04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TempChartMultiServer extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	static class LinePane extends Pane {
		private int w = 750, h = 550;
		private int xZero = 30, yZero = 570, xGap = 31, yGap = 45;
		private List<List<Integer>> clients = new ArrayList<>();
		private Map<Integer, Color> colors = new HashMap<>();
		public LinePane() {
			drawAxis();
		}

		public void drawAxis() {
			Line xAxail = new Line(30, 30, 30, 570);
			Line yAxail = new Line(30, 570, 780, 570);
			Text tX = new Text(10, 12, "温度(c)");
			Text tY = new Text(790, 575, "时间(t)");
			getChildren().addAll(xAxail, yAxail, tX, tY);
			for (int i = 0; i <= 12; i++) {
				Text t = new Text(5, 570 - 45 * i, "" + (-20 + 5 * i));
				getChildren().add(t);
			}
			for (int i = 0; i <= 24; i++) {
				Text t = new Text(30 + 31 * i, 590, "" + i);
				getChildren().add(t);
			}
		}

		public void addClient(List<Integer> datas,int index) {		
			colors.put(index, Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
			clients.add(datas);
		}

		public void drawLine(int index) {
			for (int j = 0; j < clients.size(); j++) {			
				for (int i = 1; i < clients.get(j).size(); i++) {
					if (clients.get(j).size() > 2) {
						Line l = new Line(xZero + (i - 1) * xGap, yZero - (clients.get(j).get(i - 1) + 20) * 9,
								30 + i * xGap, yZero - (clients.get(j).get(i) + 20) * 9);
						l.setStroke(colors.get(j));
						Text t = new Text(xZero + (i - 1) * xGap, yZero - (clients.get(j).get(i - 1) + 20) * 9,
								clients.get(j).get(i - 1) + "");
						getChildren().addAll(l, t);
					}
				}
			}
		}
	}

	@Override
	public void start(Stage stage) throws SocketException, InterruptedException {
		stage.setTitle("温度折线图");
		LinePane pane = new LinePane();
		Platform.runLater(new Thread(new serverThread(1234, pane)));
		Scene scene = new Scene(pane, 850, 650);
		stage.setScene(scene);
		stage.show();
	}

	static class serverThread implements Runnable {
		private int port;
		private LinePane pane;
		private List<Integer> ports = new ArrayList<>();
		private List<List<Integer>> clients = new ArrayList<>();
		private Map<Integer, Integer> map = new HashMap<>();
		private DatagramSocket socket;
		private int index = 0;

		public serverThread(int port, LinePane pane) throws SocketException {
			super();
			this.pane = pane;
			this.port = port;
			socket = new DatagramSocket(port);
		}

		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					DatagramPacket response = new DatagramPacket(new byte[64], 64);
					try {
						socket.receive(response);						
						System.out.println(ports);
						if (!ports.contains(response.getPort())) {
							clients.add(new ArrayList<>());
							ports.add(response.getPort());
							pane.addClient(clients.get(index),index);
							map.put(response.getPort(), index);
							index++;
						}
						else{
							for(int j=0;j<clients.size();j++){
								System.out.println(clients.get(j));
								if(map.get(response.getPort()) == j){
									if(clients.get(j).size() <=24){
										clients.get(j).add(Integer.parseInt(new String(response.getData(), 0, 64).trim()));
									}
									else{
										clients.get(j).remove(0);
										clients.get(j).add(Integer.parseInt(new String(response .getData(), 0, 64).trim()));
									}
								}								
								pane.getChildren().clear();
								pane.drawAxis();
								pane.drawLine(response.getPort());
							}							
						}						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
		}

	}
}
