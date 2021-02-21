package javanet.l04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
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

public class TempChartServer extends Application {
	private static List<Integer> temps = new ArrayList<>();

	public static void main(String[] args) {
		launch(args);
	}

	class LinePane extends Pane {
		private List<Integer> datas = new ArrayList<>();
		private int w = 750, h = 550;
		private int xZero = 30, yZero = 570, xGap = 31, yGap = 45;
		private Color color;

		public LinePane(List<Integer> datas, Color c) {
			this.datas = datas;
			this.color = c;
			drawAxis();
		}

		public void setDatas(List<Integer> datas) {
			this.datas = datas;
		}

		public void drawAxis() {
			Line xAxail = new Line(30, 30, 30, 570);
			Line yAxail = new Line(30, 570, 780, 570);
			Text tX = new Text(10, 12, "温度(c)");
			Text tY = new Text(790, 575, "时间(t)");
			getChildren().addAll(xAxail, yAxail,tX,tY);
			for (int i = 0; i <= 12; i++) {
				Text t = new Text(5, 570 - 45 * i, "" + (-20 + 5 * i));
				getChildren().add(t);
			}
			for (int i = 0; i <= 24; i++) {
				Text t = new Text(30 + 31 * i, 590, "" + i);
				getChildren().add(t);
			}
		}

		public void drawLine() {
			for (int i = 1; i < datas.size(); i++) {
				if (datas.size() > 2) {
					Line l = new Line(xZero + (i - 1) * xGap, yZero - (datas.get(i - 1) + 20) * 9, 30 + i * xGap,
							yZero - (datas.get(i) + 20) * 9);
					l.setStroke(color);
					Text t = new Text(xZero + (i - 1) * xGap, yZero - (datas.get(i - 1) + 20) * 9, datas.get(i-1)+"");
					getChildren().addAll(l,t);
				}
			}
		}
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("温度折线图");
		LinePane pane = new LinePane(temps,
				Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));

		EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try (DatagramSocket socket = new DatagramSocket(1234)) {
					byte[] buf = new byte[64];
					DatagramPacket response = new DatagramPacket(buf, buf.length);
					socket.receive(response);
					if (temps.size() <= 24) {
						temps.add(Integer.parseInt(new String(buf, 0, 64).trim()));
					} else {
						temps.remove(0);
						temps.add(Integer.parseInt(new String(buf, 0, 64).trim()));
					}
					pane.getChildren().clear();
					pane.setDatas(temps);
					pane.drawAxis();
					pane.drawLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		Scene scene = new Scene(pane, 850, 650);
		stage.setScene(scene);
		stage.show();
	}

}
