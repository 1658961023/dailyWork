import java.util.Arrays;
import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		int [] array=new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = (int)((Math.random()*99+1));
	}
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
	}
		int array1[]=Arrays.copyOf(array, array.length+1);
		System.out.println("\nEnter the number insert:");
		Scanner input=new Scanner(System.in);
		array1[array.length]=input.nextInt();
		Arrays.sort(array1);
		for (int i = 0; i < array.length+1; i++) {
			System.out.print(array1[i]+" ");
	}
	}
}
