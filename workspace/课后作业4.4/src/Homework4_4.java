import java.lang.*;
import java.util.Scanner;
public class Homework4_4 {
	public static void main(String[] args){
		double s;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the side:");
		s=input.nextDouble();
		double area;
		area=(6*Math.pow(s,2))/(4*Math.tan(Math.PI/6));
		System.out.println("The area of the hexagon is "+area);
	}
}
