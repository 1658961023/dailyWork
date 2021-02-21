
public class Fan {
	int SLOW=1,MEDIUM=2,FAST=3;
	private int speed=SLOW;
	private boolean on=false;
	private double radius=5;
	private String color="blue";
	public Fan(){
		
	}
	public void setFan(int speed,boolean on,double radius,String color){
		this.speed=speed;
		this.on=on;
		this.radius=radius;
		this.color=color;
	}
	public int getSpeed(){
		return speed;
	}
	public boolean getOn(){
		return on;
	}
	public double getRadius(){
		return radius;
	}
	public String getColor(){
		return color;
	}
	public String toString(){
		String fan="";
		if(this.on){
			fan+="Speed is "+getSpeed()+" Color "+getColor()+" Radius "+getRadius();
		}
		else{
			fan+="fan is off"+" Color "+getColor()+" Radius "+getRadius();
		}
		return fan;
	}
}
