import java.util.Scanner;
public class Homework2_15 {
	public static void main(String[] args){
		double x1,x2,y1,y2;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter x1 and y1:");
		x1=input.nextDouble();
		y1=input.nextDouble();
		System.out.println("Enter x2 and y2:");
		x2=input.nextDouble();
		y2=input.nextDouble();
		double distance;
		distance=Math.pow((Math.pow(x2-x1,2)+Math.pow(y2-y1,2)),0.5);
		System.out.println("The distance between the two points is "+distance);
	}
}
