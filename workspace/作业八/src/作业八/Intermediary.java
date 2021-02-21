package 作业八;

import java.util.Scanner;

public class Intermediary {
	public Intermediary() {
	}

	Control control = new Control();
	Dial dial = new Dial();
	Speed speed = new Speed();

	public Speed toSpeed(Control control,Dial dial) {
		switch (control.getLevel()) {
		case 0:
			speed.setSpeed(0);
			break;
		case 1:
			if (dial.getDial() == 1) {
				speed.setSpeed(4);
				break;
			} else if (dial.getDial() == 2) {
				speed.setSpeed(6);
				break;
			} else if (dial.getDial() == 3) {
				speed.setSpeed(12);
				break;
			}
			else 
				System.out.println("刻度盘输入不合法！");break;
		case 2:
			speed.setSpeed(30);
			break;
		case 3:
			speed.setSpeed(60);
			break;
		}
		return speed;
	}

	public Speed Operate(Control control,Dial dial,int menu) {
		Scanner input = new Scanner(System.in);
			switch (menu) {
			case 1:
				control.upLevel();
				break;
			case 2:
				control.lowLevel();
				break;
			case 3:
				dial.upDial();
				break;
			case 4:
				dial.lowDial();
				break;
			}
			return toSpeed(control, dial);
	}
	public void showAll(Control control,Dial dial,Speed speed){
		System.out.println("控制杆: "+control.getLevel()+"\n刻度盘: "+dial.getDial()+"\n雨刷速度: "+speed.getSpeed());
	}
}
