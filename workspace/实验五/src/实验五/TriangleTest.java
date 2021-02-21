package สตั้ฮๅ;

import java.util.*;

public class TriangleTest {
public static void main(String[] args){
	System.out.println("Enter three sides :");
	double a,b,c;
	Triangle triangle=new Triangle();
	Scanner input = new Scanner (System.in);
	a=input.nextDouble();
	b=input.nextDouble();
	c=input.nextDouble();
	ArrayList<Double>  newarray=new ArrayList<Double>();
	newarray.add(a);
	newarray.add(b);
	newarray.add(c);
	triangle.setColor("Blue");
	triangle.setThreeSides(newarray);
	System.out.println(triangle.toString());
}
}
