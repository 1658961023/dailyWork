import java.util.Scanner;
public class Homework2_6 {
	public static void main(String[] args){
		int test_int;
		int ones_place,tens_place,hundreds_place;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a number between 0 and 1000:");
		test_int=input.nextInt();
		ones_place=test_int%10;
		tens_place=test_int/10%10;
		hundreds_place=test_int/100%10;
		int sum;
		sum=ones_place+tens_place+hundreds_place;
		System.out.println("The sum of the digits is "+sum);
	}
}
