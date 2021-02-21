package 软件测试实验一;

import java.util.InputMismatchException;
import java.util.Scanner;

public class 第二题_NextDate问题 {
	public static boolean isLeapYear(int year) {
		if((year%4==0&&year%100!=0)||year%400==0){
			return true;
		}
		return false;
	}
	public static boolean belongTo(int month,int months[]) {
		for(int i=0;i<months.length;i++){
			if(month==months[i]){
				return true;
			}
		}
		return false;
	}
		public static void main(String[] args) {
			int year = 0;
			int month = 0;
			int day = 0;
			int [] solar_month = {1,3,5,7,8,10,12};
			int [] lunar_month = {4,6,9,11};
			System.out.println("输入年月日：(输入正整数  空格分开)");
			Scanner input  = new Scanner(System.in);
			try {
				year = input.nextInt();
				month = input.nextInt();
				day = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("输入非法！");
				System.exit(1);
			}
			String next_day="下一天日期为："+year+"年"+month+"月"+(day+1)+"日";
			String next_month="下一天日期为："+year+"年"+(month+1)+"月"+1+"日";
			String next_year="下一天日期为："+(year+1)+"年"+1+"月"+1+"日";
			String not_exist="输入日期不存在！";
			if(year<1818||year>2018||month<1||month>12||day<1||day>31){
				System.out.println("输入日期超出范围！");
			}
			else if(day>=1 && day<=27){//1到27号无论哪个月  都是天数加一
				System.out.println(next_day);
			}
			else if(day==28){
				if(month!=2){
					 System.out.println(next_day);//非2月的28号都是天数加一
				}
				else if(isLeapYear(year)){
					 System.out.println(next_day);//闰年的2月29天  天数加一
				}
				else{
					System.out.println(next_month);//非闰年的2月28号  跳到下个月
				}
			}
			else if(day==29){
				if(month==2&&(!isLeapYear(year))){
					System.out.println(not_exist);//非闰年的2月不存在29号
				}
				else if(isLeapYear(year)){
					System.out.println(next_month);//闰年的2月29号  跳到下个月
				}
				else{
					 System.out.println(next_day);//非2月的月份29号天数加一
				}
			}
			else if(day==30){
				if(month==2){
					System.out.println(not_exist);//2月不存在30号
				}
				else if(belongTo(month, solar_month)){
					System.out.println(next_day);//大月的30号天数加一
				}
				else{
					System.out.println(next_month);//小月的30号  跳到下个月
				}
			}
			else if(day==31){
				if(month==2||belongTo(month, lunar_month)){
					System.out.println(not_exist);//2月和小月都不存在31号
				}
				else if(belongTo(month, solar_month)&&month!=12){
					System.out.println(next_month);//非12月的大月31号跳到下个月
				}
				else if(month==12){
					System.out.println(next_year);//12月31号到下一年
				}
			}
		} 
}
