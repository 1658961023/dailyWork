import java.util.Arrays;
import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		int[] array = new int[10];
		Scanner input = new Scanner(System.in);
		System.out.println("ԭʮ����:");
		for (int i = 0; i < 10; i++) {
			array[i] = input.nextInt();
			System.out.print(array[i] + " ");
		}
		Arrays.sort(array);
		System.out.println("\n�����:");
		for (int i = 0; i < 10; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
