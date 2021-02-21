
public class Triangle extends GeometricObject{
private double a;
private double b;
private double c;
public Triangle(){
	
}
public Triangle(double a,double b,double c,String color,boolean isFull){
	this.a=a;
	this.b=b;
	this.c=c;
	this.color=color;
	this.isFull=isFull;
}

	public double getA() {
	return a;
}
public void setA(double a) {
	this.a = a;
}
public double getB() {
	return b;
}
public void setB(double b) {
	this.b = b;
}
public double getC() {
	return c;
}
public void setC(double c) {
	this.c = c;
}
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if(this.color!=null){
			return true;  
		}
		return false;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double p=this.getPeremeter()/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}

	@Override
	public double getPeremeter() {
		// TODO Auto-generated method stub
		return a+b+c;
	}

}
