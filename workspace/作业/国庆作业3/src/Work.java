import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter your number:");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int i, j;
		String a = "=";
		a=n+a;
		for (i = 1; i <=n; i++) {
			boolean prime = true;
			if (n % i == 0) {
				for (j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						prime = false;
						break;
					}
				}
				if (prime) {
					a+=i+"*";
					n = n/i;
					i = 1;
					continue;
				}
			}
			else
				continue;
		}
		System.out.println(a.substring(0, a.length()-1));
	}
}
