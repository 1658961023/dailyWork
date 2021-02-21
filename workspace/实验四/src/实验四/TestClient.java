package สตั้หฤ;

import java.util.Scanner;

public class TestClient {
	public static void main(String[] args) {
Agent agent=new Agent();
agent.dial.setPosition(0);
agent.lever.setPosition(0);
int menu = 0;
Scanner input = new Scanner(System.in);
while (menu != 5) {
	menu();
	menu = input.nextInt();
	if(menu==5){
		break;
	}
	switch(menu){
	case 0:
		agent.lever.leverPosUp();break;
	case 1:
		agent.lever.leverPosDown();break;
	case 2:
		agent.dial.dialPosUp();break;
	case 3:
		agent.dial.dialPosDown();break;
	case 4:
		if(agent.lever.getPosition()<0)
			agent.lever.setPosition(0);
		if(agent.dial.getPosition()<0)
			agent.dial.setPosition(0);
		if(agent.lever.getPosition()!=1)
			agent.dial.setPosition(0);
		agent.calculateSpeed();
		System.out.print("Lever Postition:"+agent.lever.getPosition()+"\nDial Postition:"+agent.dial.getPosition()+"\nBrush Speed:"+agent.brush.getSpeed()+"\n");
	}
}
input.close();
}

	public static void menu() {
			System.out.println("0---LeverPosUp\n1---LeverPosDown\n2---DialPosUp\n3---DialPosDown\n4---ShowBrush\n5---Exit");
	}
}
