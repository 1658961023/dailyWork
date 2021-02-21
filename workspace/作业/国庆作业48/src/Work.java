import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter a string:");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		System.out.println("Enter the string you want to caculate:");
		String str2 = input.nextLine();
		int times = 0;
		for (int i = 0; i <= str.length() - str2.length(); i++) {
			if (str2.equals(str.substring(i, i + str2.length()))) {
				times++;
			}
		}
		 System.out.println("The " + str2 + " appear " + times + " times in the " + str);
	}
}
