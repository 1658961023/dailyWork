import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter the array:");
		Scanner input = new Scanner(System.in);
		int[] a = new int[5];
		for (int i = 0; i < 5; i++) {
			a[i] = input.nextInt();
		}
		int max = a[0], max_index = 0, min_index = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max_index = i;
			}
		}
		int temp = 0;
		temp = a[0];
		a[0] = a[max_index];
		a[max_index] = temp;
		int min=a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min) {
				min_index = i;
			}
		}
		if (min_index == a.length-1) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
		} else {
			temp = a[a.length - 1];
			a[a.length - 1] = a[min_index];
			a[min_index] = temp;
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
		}
	}
}
