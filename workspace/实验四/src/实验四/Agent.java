package 实验四;

public class Agent {
Brush brush=new Brush();
Dial dial=new Dial();
Lever lever=new Lever();
public Agent(){
	
}
public Agent(Dial dial,Brush brush,Lever lever){
	this.dial=dial;
	this.brush=brush;
	this.lever=lever;
}
public void calculateSpeed(){
	switch (lever.getPosition()) {
	case 0:
		brush.setSpeed(0);
		break;
	case 1:
		if (dial.getPosition()== 1) {
			brush.setSpeed(4);
			break;
		} else if (dial.getPosition() == 2) {
			brush.setSpeed(6);
			break;
		} else if (dial.getPosition() == 3) {
			brush.setSpeed(12);
			break;
		}
		else 
			System.out.println("刻度盘输入不合法！");break;
	case 2:
		brush.setSpeed(30);
		break;
	case 3:
		brush.setSpeed(60);
		break;
	}
}
}
