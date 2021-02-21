
public class Circle {
	private double radius;

	public Circle() {
this(2);
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return this.radius;
	}

	public double getArea() {
		return Math.PI * Math.pow(this.radius, 2);
	}
@Override
	public String toString() {
		return "The circle's area is"+this.getArea();
	}

}
