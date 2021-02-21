import java.util.Scanner;

public class QuadraticEquation_Test {
	public static void main(String[] args){
		QuadraticEquation f=new QuadraticEquation();
		System.out.println("Enter a b and c:");
		Scanner input= new Scanner(System.in);
		double a,b,c;
		a=input.nextDouble();
		b=input.nextDouble();
		c=input.nextDouble();
		f.setA(a);
		f.setB(b);
		f.setC(c);
		if(f.getDiscriminant()>0)
			System.out.println(f.getRoot1()+" "+f.getRoot2());
		else if(f.getDiscriminant()==0)
			System.out.println(f.getRoot1());
			else
				System.out.println("The equation has no roots.");
		}
	}
