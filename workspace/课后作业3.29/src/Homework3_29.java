import java.util.Scanner;
public class Homework3_29 {
	public static void main(String[] args){
	double x1,y1,x2,y2,r1,r2;
	Scanner input=new Scanner(System.in);
	System.out.println("Enter circle1's center x-,y-coordinates,and radius:");
	x1=input.nextDouble();
	y1=input.nextDouble();
	r1=input.nextDouble();
	System.out.println("Enter circle2's center x-,y-coordinates,and radius:");
	x2=input.nextDouble();
	y2=input.nextDouble();
	r2=input.nextDouble();
	if(Math.pow((Math.pow(x1-x2,2)+Math.pow(y1-y2,2)),0.5)<=Math.abs(r1-r2))
			System.out.println("Circle2 is inside circle1");
	else if(Math.pow((Math.pow(x1-x2,2)+Math.pow(y1-y2,2)),0.5)<=(r1+r2))
		System.out.println("Circle2 is overlaps circle1");
	else
		System.out.println("Circle2 does not overlap circle1");
	}
}
