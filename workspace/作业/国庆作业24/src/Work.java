import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter a num:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		if ((num % 10 == (num / 10000)) && ((num % 100 / 10) == (num % 10000 / 1000)))
			System.out.println("是回文数");
		else
			System.out.println("不是回文数");
	}
}
