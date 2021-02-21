import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		int num,sum=0;
		System.out.println("Enter a interger:");
		Scanner input=new Scanner(System.in);
		num=input.nextInt();
		while(num%9==0){
			if(num%9==0){
				sum++;
				num/=9;
			}
		}
		System.out.println("可以被"+sum+"个9整除");
	}
}
