import java.util.Scanner;
public class Homework3_1 {
	public static void main(String[] args){
		double a,b,c;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a,b,c:");
		a=input.nextDouble();
		b=input.nextDouble();
		c=input.nextDouble();
		if((Math.pow(b, 2)-4*a*c)>0){
			System.out.println("The equation has two roots "+(-b+Math.pow((Math.pow(b, 2)-4*a*c),0.5))/(2*a)+" and "+(-b-Math.pow((Math.pow(b, 2)-4*a*c),0.5))/(2*a));
		}
		else if((Math.pow(b,2)-4*a*c)==0){
			System.out.println("The equation has one root "+(-b/(2*a)));
		}
		else{
			System.out.println("The equation has no roots");
		}
	}
}
