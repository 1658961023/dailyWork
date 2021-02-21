package 第一题;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShowCaculater extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		GridPane pane = new GridPane();
		Scene scene = new Scene(pane, 600, 600);
		pane.add(getMenu(),0,0);
		pane.add(getButtons(),0,2);
		pane.add(getWindow(),0,1);
		pane.add(getCalDate(),1,1);
		primaryStage.setTitle("计算器");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private HBox getMenu() {
		HBox menu = new HBox();
		menu.setPrefHeight(50);
		menu.setPrefWidth(200);
		Button view = new Button("查看(V)");
		Button editor = new Button("编辑(E)");
		Button help = new Button("帮助(H)");
		menu.getChildren().addAll(view, editor, help);
		return menu;
	}

	private VBox getCalDate() {
		VBox date = new VBox();
		date.setPrefHeight(600);
		date.setPrefWidth(300);
		ComboBox<String> cbo1 = new ComboBox<>();
		cbo1.getItems().add("计算两个日期之差");
		Label label1 = new Label("选择所需的日期计算方法", cbo1);
		cbo1.setValue("计算两个日期之差");
		cbo1.setPrefWidth(300);
		label1.setContentDisplay(ContentDisplay.BOTTOM);
		date.getChildren().addAll(label1,cbo1);
		HBox date1=new HBox();
		ComboBox<String> cbo2 = new ComboBox<>();
		cbo2.getItems().add("2016/8/27");
		cbo2.setPrefWidth(130);
		Label label2 = new Label("从", cbo2);
		label2.setContentDisplay(ContentDisplay.RIGHT);
		ComboBox<String> cbo3 = new ComboBox<>();
		cbo3.getItems().add("2016/5/10");
		cbo3.setPrefWidth(130);
		Label label3 = new Label("到", cbo3);
		label3.setContentDisplay(ContentDisplay.RIGHT);
		VBox date2=new VBox();
		TextField tf1=new TextField("3月2周3天");
		Label label4=new Label("差(年、月、周、天)",tf1);
		label4.setContentDisplay(ContentDisplay.BOTTOM);
		TextField tf2=new TextField("109天");
		Label label5=new Label("差(天)",tf2);
		label5.setContentDisplay(ContentDisplay.BOTTOM);
		date1.getChildren().addAll(label2,label3, cbo2, cbo3);
		date2.getChildren().addAll(tf1,label4,tf2,label5);
		date.getChildren().add(date1);
		date.getChildren().add(date2);
		Button cal=new Button("计算");
		date.getChildren().add(cal);
		cal.setPrefWidth(100);
		return date;

	}

	private VBox getWindow() {
		VBox window = new VBox();
		window.setStyle("-fx-border-color:black");
		window.setPrefHeight(20);
		window.setPrefWidth(20);
		HBox twBts=new HBox();
		Button bt1=new Button("▲");
		Button bt2=new Button("▼");
		twBts.setAlignment(Pos.BASELINE_RIGHT);
		twBts.getChildren().addAll(bt1,bt2);
		Rectangle rec=new Rectangle(0,0,300,200);
		rec.setFill(Color.WHITE);
		TextField tf=new TextField("计数=");
		tf.setEditable(false);
		window.getChildren().addAll(twBts,rec,tf);
		return window;
	}

	private GridPane getButtons() {
		GridPane buttons = new GridPane();
		buttons.setPrefHeight(200);
		buttons.setPrefWidth(300);
		Button MC = new Button("MC");
		Button MR = new Button("MR");
		Button MS = new Button("MS");
		Button MP = new Button("M+");
		Button MD = new Button("M-");
		MC.setPrefWidth(60);
		MR.setPrefWidth(60);
		MS.setPrefWidth(60);
		MP.setPrefWidth(60);
		MD.setPrefWidth(60);
		HBox hb1=new HBox();
		hb1.getChildren().addAll(MC,MR,MS,MP,MD);
		Button arrow = new Button("←");
		Button CAD = new Button("CAD");
		Button C = new Button("C");
		Button FE = new Button("F-E");
		Button Exp = new Button("Exp");
		arrow.setPrefWidth(60);
	    CAD.setPrefWidth(60);
		C.setPrefWidth(60);
		FE.setPrefWidth(60);
		Exp.setPrefWidth(60);
		HBox hb2=new HBox();
		hb2.getChildren().addAll(arrow,CAD,C,FE,Exp);
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button x = new Button("x-");
		Button x2 = new Button("x2-");
		seven.setPrefWidth(60);
		eight.setPrefWidth(60);
		nine.setPrefWidth(60);
		x.setPrefWidth(60);
		x2.setPrefWidth(60);
		HBox hb3=new HBox();
		hb3.getChildren().addAll(seven,eight,nine,x,x2);
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button x_ = new Button("$x");
		Button x2_ = new Button("%s2");
		four.setPrefWidth(60);
		five.setPrefWidth(60);
		six.setPrefWidth(60);
		x_.setPrefWidth(60);
		x2_.setPrefWidth(60);
		HBox hb4=new HBox();
		hb4.getChildren().addAll( four, five, six, x_, x2_);
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button n = new Button("#n");
		Button n_1 = new Button("#n-1");
		one.setPrefWidth(60);
		two.setPrefWidth(60);
		three.setPrefWidth(60);
		n.setPrefWidth(60);
		n_1.setPrefWidth(60);
		HBox hb5=new HBox();
		hb5.getChildren().addAll( one, two, three, n, n_1);
		Button zero = new Button("0");
		Button point = new Button(".");
		Button equal = new Button("=");
		Button add = new Button("Add");
		HBox hb6=new HBox();
		zero.setPrefWidth(120);
		point.setPrefWidth(60);
		equal.setPrefWidth(60);
		add.setPrefWidth(60);
		hb6.getChildren().addAll(zero,point,equal,add);
		buttons.add(hb1, 0, 0);
		buttons.add(hb2, 0, 1);
		buttons.add(hb3, 0, 2);
		buttons.add(hb4, 0, 3);
		buttons.add(hb5, 0, 4);
		buttons.add(hb6, 0, 5);
		buttons.setAlignment(Pos.BOTTOM_LEFT);
		return buttons;
	}
}
