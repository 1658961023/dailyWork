import java.util.Scanner;

public class TriangleTest {
public static void main(String[] args){
	System.out.println("Enter a b and c:");
	Scanner input=new Scanner(System.in);
	Triangle triangle=new Triangle();
	triangle.setA(input.nextDouble());
	triangle.setB(input.nextDouble());
	triangle.setC(input.nextDouble());
	input.nextLine();
	System.out.println("Enter the color:");
	triangle.setColor(input.nextLine());
	if(triangle.getA()+triangle.getB()>triangle.getC()&&triangle.getA()+triangle.getC()>triangle.getB()&&triangle.getC()+triangle.getB()>triangle.getA())
	System.out.println("Area:"+triangle.getArea()+"  Peremeter:"+triangle.getPeremeter()+"  Color:"+triangle.getColor()+"  Full: "+triangle.isFull());
	else{
		System.out.println("It's not a triangle");
	}
	}
}
