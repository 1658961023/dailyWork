
public class Circle extends GeometricObject {
	private double radius;

	public Circle() {

	}

	public Circle(double radius, String color) {
		this.radius = radius;
		this.setColor(color);
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

	public void show() {
		// System.out.println("The circle's color is:"+this.getColor());
		super.show();
		System.out.println("The circle's area is:" + this.getArea());
	}

	public boolean equals(Object o) {
		if (o instanceof Circle) {
			return radius == ((Circle) o).radius;
		}
		return this == o;
	}
}
