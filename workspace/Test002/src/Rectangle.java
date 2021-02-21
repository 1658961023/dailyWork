
public class Rectangle extends GeometricObject{
private double width,length;
public Rectangle(){
	
}
public Rectangle(double width,double length){
	this.width=width;
	this.length=length;
}
public double getArea(){
	return this.width*this.length;
}
}
