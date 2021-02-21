import java.util.Arrays;
import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter three numbers:");
		Scanner input=new Scanner(System.in);
		int [] a=new int[3];
		for(int i=0;i<3;i++){
			a[i]=input.nextInt();
		}
		Arrays.sort(a);
		for(int i=0;i<3;i++){
			System.out.print(a[i]+" ");
		}
	}
}
