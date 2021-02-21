import java.util.*;
public class Homework5_29 {
	public static void main(String[] args) {
		System.out.println("Enter year and the first day:");
		int year,first;
		Scanner input=new Scanner(System.in);
		year=input.nextInt();
		first=input.nextInt();
		int[] month={31,28,31,30,31,30,31,31,30,31,30,31};
		String[] months_of_year={"January","Febuary","March","April","May","June","July","Augsut","Sepetember","October","November","December"};
		int i,j,k,m;
		int sumday=0,firstday,monthday;
		if((year%4==0&&year%100!=0)||(year%400==0))
			month[1]+=1;
		for(i=0;i<12;i++){
			if(i==0)
				sumday=0;
			else
				sumday+=month[i-1];
			firstday=(sumday+first)%7;
			System.out.println("\t\t   "+months_of_year[i]+" "+year+"\t\t");
			System.out.println("___________________________________________________");
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
			for(k=0;k<firstday;k++){
				System.out.print("   \t");
			}
			for(j=1;j<=month[i];j++){
				monthday=sumday+j;
				System.out.printf("%3d\t",j);
			if((monthday+first)%7==0)
				System.out.print("\n");
		}
			System.out.println("\n");
		}
	}
}
