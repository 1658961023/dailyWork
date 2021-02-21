import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter n:");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println(add(n));
	}

	private static double add(int n) {
		double sum = 0;
		if (n % 2 != 0) {
			for (double i = 1; i <= n; i += 2) {
				sum += (1 / i);
			}
		} else {
			for (double i = 2; i <= n; i += 2) {
				sum += (1 / i);
			}
		}
		return sum;
	}
}
