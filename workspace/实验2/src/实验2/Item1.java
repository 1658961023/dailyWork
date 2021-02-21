package สตั้2;

import java.util.Scanner;

public class Item1 {
	public static void main(String[] args) {
		int i, j, num;
 		System.out.println("Enter the num");
		Scanner input = new Scanner(System.in);
		num = input.nextInt();
		for (i = 1; i <= num; i++) {
			if (num % i == 0) {
				for (j = 2; j <= i; j++) {
					if (i % j == 0)
						break;
					else
						continue;
				}
				if (j == i) {
					System.out.print(i + " ");
					num = num / i;
					i=1;
					continue;
				}
			} else
				continue;
		}
	}
}
