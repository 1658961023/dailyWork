package …œª˙≤‚ ‘;

public class Point {
	private double x;
	private double y;
public Point(){
	
}
public Point(double x,double y){
	this.x=x;
	this.y=y;
}

public double getX() {
	return x;
}
public void setX(double x) {
	this.x = x;
}
public double getY() {
	return y;
}
public void setY(double y) {
	this.y = y;
}
public double distance(Point point){
	return Math.sqrt(Math.pow(point.x-this.x,2)+Math.pow(point.y-this.y, 2));
}
public Point middlePoint(Point point){
	Point middle=new Point();
	middle.setX((point.x+this.x)/2);
	middle.setY((point.y+this.y)/2);
	return middle;
}
}
