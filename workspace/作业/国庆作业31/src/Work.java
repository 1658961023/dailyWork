import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter your num above 10000000:");
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		for(int i=4;i<8;i++)
		System.out.print((int) ((a%(Math.pow(10, i))) / Math.pow(10, i) * 10)+" ");
	}
}
