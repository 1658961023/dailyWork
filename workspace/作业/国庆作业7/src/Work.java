import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		int a,num;
		System.out.println("Enter a and the sum of numbers:");
		Scanner  input=new Scanner(System.in);
		a=input.nextInt();
		num=input.nextInt();
		int i,s=0;
		for(i=0;i<num;i++){
			int b=0,j;
			for(j=0;j<=i;j++)
				b+=a*Math.pow(10, j);
			s+=b;
		}
		System.out.println("The sum of them is:"+s);
	}
}
