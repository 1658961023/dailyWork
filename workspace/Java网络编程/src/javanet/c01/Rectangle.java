package javanet.c01;

public class Rectangle extends Shape{
	private float length;
	private float width;
	
	public Rectangle(float length,float width){
		this.length = length;
		this.width = width;
	}
	
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return length*width;
	}
	
}
