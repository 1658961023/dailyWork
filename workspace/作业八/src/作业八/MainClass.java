package ��ҵ��;

import java.util.Scanner;

public class MainClass {
public static void main(String[] args){
	Control control=new Control();
	Dial dial=new Dial();
	Speed speed=new Speed();
	Intermediary menu=new Intermediary();
	System.out.println("������Ƹ˲����Ϳ̶��̲���(ֹͣ����Ъ�����١����ٷֱ�Ϊ0~3):");
	Scanner input=new Scanner(System.in);
	control.setLevel(input.nextInt());
	dial.setDial(input.nextInt());
	speed.setSpeed(speed.getSpeed());
	speed=menu.toSpeed(control,dial);
	menu.showAll(control,dial,speed);
	System.out.println("�������Ƹ˺Ϳ̶���:");
	System.out.print("1--���Ƹ�����\n2--���Ƹ��½�\n3--�̶�������\n4--�̶����½�\n5--�˳�\n");
	int a=input.nextInt();
	menu.Operate(control,dial,a);
	menu.showAll(control,dial,speed);
	while(a!=5){
		System.out.println("����");
		System.out.print("1--���Ƹ�����\n2--���Ƹ��½�\n3--�̶�������\n4--�̶����½�\n5--�˳�\n");
		a=input.nextInt();
		menu.Operate(control,dial,a);
		menu.showAll(control,dial,speed);
	}
}
}
