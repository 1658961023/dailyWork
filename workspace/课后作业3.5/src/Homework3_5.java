import java.util.Scanner;
public class Homework3_5 {
	public static void main(String[] args){
		int today,future;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter today's day:");
		today=input.nextInt();
		System.out.println("Enter the number of days elapsed since today:");
		future=input.nextInt();
		if (today<0||today>6)
			System.out.println("You input a wrong day!!!");
		String[]week={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		if((today+future)<=6){
			System.out.println("Today is "+week[today]+" and "+"the future day is "+week[today+future]);
		}
		else if((today+future)>6){
			System.out.println("Today is "+week[today]+" and "+"the future day is "+week[(today+future)%7]);
		}
	}
}
