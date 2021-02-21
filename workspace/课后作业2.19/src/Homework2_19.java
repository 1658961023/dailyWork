import java.util.Scanner;
public class Homework2_19 {
	public static void main(String[] args){
		double x1,y1,x2,y2,x3,y3;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter three points for a triangle:");
		x1=input.nextDouble();
		y1=input.nextDouble();
		x2=input.nextDouble();
		y2=input.nextDouble();
		x3=input.nextDouble();
		y3=input.nextDouble();
		double s,s1,s2,s3;
		s1=Math.pow((Math.pow(x2-x1,2)+Math.pow(y2-y1,2)),0.5);
		s2=Math.pow((Math.pow(x3-x1,2)+Math.pow(y3-y1,2)),0.5);
		s3=Math.pow((Math.pow(x2-x3,2)+Math.pow(y2-y3,2)),0.5);
		s=(s1+s2+s3)/2;
		double area;
		area=Math.pow((s*(s-s1)*(s-s2)*(s-s3)),0.5);
		System.out.println("The area of the triangle is "+area);
		}
	}
