package javanet.c01;

public class Circle extends Shape{
	private float radius;
	
	public Circle(float radius){
		this.radius = radius;
	}
	
	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 2*Math.PI*radius*radius;
	}

}
