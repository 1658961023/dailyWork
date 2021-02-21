
public class GeometricObject {
	private String color;

	public GeometricObject() {

	}

	public GeometricObject(String color) {
		this.color = color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void show() {
		System.out.println("The geometric's color is:" + this.color);
	}
}
