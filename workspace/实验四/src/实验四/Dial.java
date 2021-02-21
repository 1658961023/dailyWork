package สตั้หฤ;

public class Dial {
private int position;
public Dial(){
	
}
public Dial(int position){
	this.position=position;
}
public void setPosition(int position){
	this.position=position;
}
public int getPosition(){
	return position;
}
public void dialPosUp(){
	this.position++;
}
public void dialPosDown(){
	this.position--;
}
}
