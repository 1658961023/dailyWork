package µÚ¶şÌâ;

public class PointSorter implements sortable{
	private int x;
	private int y;
public PointSorter(int x, int y) {
		this.x=x;
		this.y=y;
		// TODO Auto-generated constructor stub
	}

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public double getDistance(){
	return Math.sqrt(Math.pow(this.getX(), 2)+Math.pow(this.getY(), 2));
}
@Override
public String toString(){
	return "X: "+getX()+" Y: "+getY()+" Distance: "+getDistance();
}

@Override
public int compareTo(PointSorter o) {
	// TODO Auto-generated method stub
	if(getDistance()<o.getDistance())
		return 1;
	else if(getDistance()>o.getDistance())
		return -1;
	return 0;
}
}
