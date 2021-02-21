
public class Ball extends Circle{
	private double radius;
	public Ball(){
		
	}
	public Ball(double radius){
		this.radius=radius;
	}
	Circle ball=new Ball();
public double getVolume(){
	return 4/3*Math.PI*Math.pow(radius, 2);
}
	public double getArea(){
		return 4*Math.PI*Math.pow(radius, 2);
	}
}
