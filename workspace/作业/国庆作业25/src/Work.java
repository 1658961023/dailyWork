import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter the first letter:");
		Scanner input = new Scanner(System.in);
		String week = input.nextLine();
		char first_letter = week.charAt(0);
		switch (first_letter) {
		case 'm':
			System.out.println("It's Monday");
			break;
		case 't':
			System.out.println("Enter the second letter:");
			week += input.nextLine();
			if (week.charAt(1) == 'h') {
				System.out.println("It's Thursday");
				break;
			} else if (week.charAt(1) == 'u') {
				System.out.println("It's Tuesday");
				break;
			} else
				System.out.println("Wrong input");
			break;
		case 'w':
			System.out.println("It's Wednesday");
			break;
		case 'f':
			System.out.println("It's Friday");
			break;
		case 's':
			System.out.println("Enter the second letter:");
			week += input.nextLine();
			if (week.charAt(1) == 'u') {
				System.out.println("It's Sunday");
				break;
			} else if (week.charAt(1) == 'a') {
				System.out.println("It's Saturday");
				break;
			} else
				System.out.println("Wrong input");
			break;
		default:
			System.out.println("Wrong input");
		}
	}
}
