
public abstract class GeometricObject {
protected String color;
protected boolean isFull;
public abstract boolean isFull();
public abstract double getArea();
public abstract double getPeremeter();
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public void setFull(boolean isFull) {
	this.isFull = isFull;
}

}
