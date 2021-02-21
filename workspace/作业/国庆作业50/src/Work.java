import java.util.*;
public class Work {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input the month:");
		int sum=0,n,i,s1=1,s2=1;
		n=input.nextInt();
		if(n==1||n==2){
			sum=1;
		}
		else
			for(i=3;i<=n;i++){
			sum=s1+s2;
			s1=s2;
			s2=sum;
		}
	System.out.println("The sum of rabbits is:"+sum);		
	}
}
