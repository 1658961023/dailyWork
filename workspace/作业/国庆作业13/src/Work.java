import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter year month and date:");
		Scanner input=new Scanner(System.in);
		int year=input.nextInt();
		int month=input.nextInt();
		int day=input.nextInt();
		int sumdays=0;
	    int [] twmonth={31,28,31,30,31,30,31,31,30,31,30,31};
	    for(int i=0;i<month-1;i++){
	    	sumdays+=twmonth[i];
	    }
	    if((year%4==0&&year%100!=0||year%400==0)&&month>2)
	    	sumdays++;
	    sumdays+=day;
	    System.out.println("It's "+sumdays);
	}
}
