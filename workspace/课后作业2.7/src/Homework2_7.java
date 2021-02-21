import java.util.Scanner;
public class Homework2_7 {
	public static void main(String[] args){
	int minutes,years,days;
	Scanner input=new Scanner(System.in);
	System.out.println("Enter the numbers of minutes:");
	minutes=input.nextInt();
	years=minutes/(1440*365);
	days=minutes/1440%years;
	System.out.println(minutes+"minutes is approximately "+years+" years and " + days+" days");
	}
}
