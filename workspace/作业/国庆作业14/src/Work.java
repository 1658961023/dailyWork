import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter x y and z:");
		int []a=new int[3];
		Scanner input=new Scanner(System.in);
		for(int i=0;i<3;i++){
			a[i]=input.nextInt();
		}
		Arrays.sort(a);
		for(int j=0;j<3;j++)
			System.out.print(a[j]);
	}
}
