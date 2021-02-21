import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		double profit,award = 0;
		System.out.println("Enter the profit:");
		Scanner input=new Scanner(System.in);
		profit=input.nextDouble();
		if(profit<=100000)
			award=profit*0.1;
		else if(profit>100000&&profit<=200000)
			award=10000+(profit-100000)*0.075;
		else if(profit>200000&&profit<=400000)
			award=(profit-200000)*0.005;
		else if(profit>40000&&profit<=600000)
			award=(profit-400000)*0.003;
		else if(profit>600000&&profit<=1000000)
			award=(profit-600000)*0.0015;
		else if(profit>1000000)
			award=(profit-1000000)*0.001;
	System.out.println("The award is:"+award);
	}
}
