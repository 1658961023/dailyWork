package 作业八;

import java.util.Scanner;

public class MainClass {
public static void main(String[] args){
	Control control=new Control();
	Dial dial=new Dial();
	Speed speed=new Speed();
	Intermediary menu=new Intermediary();
	System.out.println("输入控制杆参数和刻度盘参数(停止、间歇、低速、高速分别为0~3):");
	Scanner input=new Scanner(System.in);
	control.setLevel(input.nextInt());
	dial.setDial(input.nextInt());
	speed.setSpeed(speed.getSpeed());
	speed=menu.toSpeed(control,dial);
	menu.showAll(control,dial,speed);
	System.out.println("操作控制杆和刻度盘:");
	System.out.print("1--控制杆提升\n2--控制杆下降\n3--刻度盘提升\n4--刻度盘下降\n5--退出\n");
	int a=input.nextInt();
	menu.Operate(control,dial,a);
	menu.showAll(control,dial,speed);
	while(a!=5){
		System.out.println("继续");
		System.out.print("1--控制杆提升\n2--控制杆下降\n3--刻度盘提升\n4--刻度盘下降\n5--退出\n");
		a=input.nextInt();
		menu.Operate(control,dial,a);
		menu.showAll(control,dial,speed);
	}
}
}
