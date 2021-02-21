import java.util.Scanner;
import java.lang.*;
public class Work {
	public static void main(String[] args) {
		System.out.println("Enter m and n:");
		Scanner input=new Scanner(System.in);
		int m,n;
		m=input.nextInt();
		n=input.nextInt();
		int greatest_common_divisor=0,least_common_multiple=0;
		int i;
		for(i=1;i<Math.max(m, n);i++){
			if(m%i==0&&n%i==0&&i>greatest_common_divisor)
				greatest_common_divisor=i;
		}
		least_common_multiple=m*n/greatest_common_divisor;
		System.out.println("The greatest_common_divisor is "+greatest_common_divisor+" and the least_common_mutilple is "+least_common_multiple);
	}
}
