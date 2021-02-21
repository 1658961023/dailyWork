
public class Circle2D {
	public Circle2D(){
		
	}
	private double x,y;
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	private double radius;
	public double radius(){
		return radius;
	}
	public void creatCircle0(){
		x=0;
		y=0;
		radius=1;
	}
	public Circle2D(double x,double y,double radius){
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	public double getArea(){
		return Math.PI*radius*radius;
	}
	public double getPerimeter(){
		return Math.PI*2*radius;
	}
	public boolean contains(double x,double y){
		if(Math.pow(this.x-x, 2)+Math.pow(this.y-y,2)<Math.pow(radius, 2)){
			return true;
		}
		return false;
	}
	public boolean contains(Circle2D circle){
		if(Math.pow(x-circle.x,2)+Math.pow(y,circle.y)<Math.pow(radius-circle.radius,2)){
			return true;
		}
		return false;
	}
	public boolean overlaps(Circle2D circle){
		if(Math.pow(x-circle.x,2)+Math.pow(y,circle.y)>Math.pow(radius-circle.radius,2)&&Math.pow(x-circle.x,2)-Math.pow(y,circle.y)<Math.pow(radius+circle.radius,2)){
			return true;
		}
		return false;
	}
}
