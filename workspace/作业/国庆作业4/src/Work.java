import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter the grades:");
		Scanner input = new Scanner(System.in);
		int grade = input.nextInt();
		if (grade >= 90 && grade <= 100)
			System.out.println("A");
		else if (grade >= 60 && grade < 90)
			System.out.println("B");
		else if (grade < 60 && grade > 0)
			System.out.println("C");
		else
			System.out.println("Invalid grade");
	}
}
