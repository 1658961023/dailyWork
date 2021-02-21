package javanet.l03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUIDaytimeClient extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	class ClockPane extends Pane {
		private int hour;
		private int minute;
		private int second;
		private double w = 500, h = 500;

		public ClockPane(int hour, int minute, int second) throws IOException {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
			setCurrentTime();
			paintClock();
		}

		public int getHour() {
			return hour;
		}

		public void setHour(int hour) {
			this.hour = hour;
			paintClock();
		}

		public int getMinute() {
			return minute;
		}

		public void setMinute(int minute) {
			this.minute = minute;
			paintClock();
		}

		public int getSecond() {
			return second;
		}

		public void setSecond(int second) {
			this.second = second;
			paintClock();
		}

		public double getW() {
			return w;
		}

		public void setW(double w) {
			this.w = w;
			paintClock();
		}

		public double getH() {
			return h;
		}

		public void setH(double h) {
			this.h = h;
			paintClock();
		}

		private void paintClock() {
			// TODO Auto-generated method stub
			double clockRadius = Math.min(w, h) * 0.8 * 0.5;
			double centerX = w / 2;
			double centerY = h / 2;
			Circle circle = new Circle(centerX, centerY, clockRadius);
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
			Text t12 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
			Text t9 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
			Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
			Text t6 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
			double sLength = clockRadius * 0.8;
			double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
			double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
			Line sLine = new Line(centerX, centerY, secondX, secondY);
			sLine.setStroke(Color.RED);
			double mLength = clockRadius * 0.65;
			double minuteX = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
			double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
			Line mLine = new Line(centerX, centerY, minuteX, minuteY);
			mLine.setStroke(Color.BLUE);
			double hLength = clockRadius * 0.5;
			double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
			double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
			Line hLine = new Line(centerX, centerY, hourX, hourY);
			hLine.setStroke(Color.GREEN);

			getChildren().clear();
			getChildren().addAll(circle, t12, t3, t6, t9, sLine, mLine, hLine);
		}

		private void setCurrentTime() throws IOException {
			// TODO Auto-generated method stub
			Socket socket = new Socket("localhost", 2007);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			int year = dis.readInt();
			int month = dis.readByte();
			int day = dis.readByte();
			int hour = dis.readByte();
			int minute = dis.readByte();
			int second = dis.readByte();
			socket.close();
			this.hour = hour;
			this.minute = minute;
			this.second = second;
			paintClock();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost", 2007);
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		int year = dis.readInt();
		int month = dis.readByte();
		int day = dis.readByte();
		int hour = dis.readByte();
		int minute = dis.readByte();
		int second = dis.readByte();
		socket.close();
		ClockPane clock = new ClockPane(hour, minute, second);
		BorderPane pane = new BorderPane();
		EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					clock.setCurrentTime();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
				Label lblCurrentTime = new Label(timeString);
				pane.setCenter(clock);
				pane.setBottom(lblCurrentTime);
			}
		};
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();		
		Scene scene = new Scene(pane, 500, 500);
		stage.setTitle("DisplayClock");
		stage.setScene(scene);
		stage.show();
	}

}
