package สตั้2;
import java.util.*;
public class Item2 {
	public static void main(String[] args){
		System.out.println("Enter the year month and day:");
		Scanner input=new Scanner(System.in);
		int youryear=input.nextInt();
		int yourmonth=input.nextInt();
		int yourday=input.nextInt();
		System.out.println("The different is "+Math.abs(dateDiff(youryear,yourmonth,yourday))+" days");
	}
public static int addmonth(int a){
	int sum=0,i;
	int[] tmonth={31,28,31,30,31,30,31,31,30,31,30,31};
	for(i=0;i<a-1;i++){
		sum+=tmonth[i];
	}
	return sum;
}
public static int dateDiff(int youryear,int yourmonth,int yourday){
	Calendar cal=Calendar.getInstance();
	int year=cal.get(Calendar.YEAR);
	int month=cal.get(Calendar.MONTH);
	int day=cal.get(Calendar.DATE);
	System.out.println("Now is "+year+" "+(month+1)+" "+day);
	int[] tmonth={31,28,31,30,31,30,31,31,30,31,30,31};
	Scanner input=new Scanner(System.in);
	while(youryear<0||yourmonth<1||yourmonth>12||yourday<1||((yourday>28)&&((youryear%4==0&&youryear%100==0)||(youryear%4!=0)))||(((youryear%4==0&&youryear%100!=0)||(youryear%400==0))&&yourday>29)){
		System.out.print("The date you've inputed is illegal!!");
		System.out.println("Please input again");
		youryear=input.nextInt();
		yourmonth=input.nextInt();
		yourday=input.nextInt();
	}
	int sumday=Math.abs((youryear-year)*365)-addmonth(yourmonth)-yourday+addmonth(month+1)+day;
	if(youryear<year){
	for(;youryear<year;youryear++){
		if((youryear%4==0&&youryear%100!=0)||(youryear%400==0))
			sumday+=1;
	}
	}
	if(youryear>=year){
		for(;year<youryear;year++){
			if((youryear%4==0&&youryear%100!=0)||(youryear%400==0))
				sumday+=1;
		}
	}
	return sumday;
}
}
