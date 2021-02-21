package �������ʵ��һ;

import java.util.InputMismatchException;
import java.util.Scanner;

public class �ڶ���_NextDate���� {
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
			System.out.println("���������գ�(����������  �ո�ֿ�)");
			Scanner input  = new Scanner(System.in);
			try {
				year = input.nextInt();
				month = input.nextInt();
				day = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("����Ƿ���");
				System.exit(1);
			}
			String next_day="��һ������Ϊ��"+year+"��"+month+"��"+(day+1)+"��";
			String next_month="��һ������Ϊ��"+year+"��"+(month+1)+"��"+1+"��";
			String next_year="��һ������Ϊ��"+(year+1)+"��"+1+"��"+1+"��";
			String not_exist="�������ڲ����ڣ�";
			if(year<1818||year>2018||month<1||month>12||day<1||day>31){
				System.out.println("�������ڳ�����Χ��");
			}
			else if(day>=1 && day<=27){//1��27�������ĸ���  ����������һ
				System.out.println(next_day);
			}
			else if(day==28){
				if(month!=2){
					 System.out.println(next_day);//��2�µ�28�Ŷ���������һ
				}
				else if(isLeapYear(year)){
					 System.out.println(next_day);//�����2��29��  ������һ
				}
				else{
					System.out.println(next_month);//�������2��28��  �����¸���
				}
			}
			else if(day==29){
				if(month==2&&(!isLeapYear(year))){
					System.out.println(not_exist);//�������2�²�����29��
				}
				else if(isLeapYear(year)){
					System.out.println(next_month);//�����2��29��  �����¸���
				}
				else{
					 System.out.println(next_day);//��2�µ��·�29��������һ
				}
			}
			else if(day==30){
				if(month==2){
					System.out.println(not_exist);//2�²�����30��
				}
				else if(belongTo(month, solar_month)){
					System.out.println(next_day);//���µ�30��������һ
				}
				else{
					System.out.println(next_month);//С�µ�30��  �����¸���
				}
			}
			else if(day==31){
				if(month==2||belongTo(month, lunar_month)){
					System.out.println(not_exist);//2�º�С�¶�������31��
				}
				else if(belongTo(month, solar_month)&&month!=12){
					System.out.println(next_month);//��12�µĴ���31�������¸���
				}
				else if(month==12){
					System.out.println(next_year);//12��31�ŵ���һ��
				}
			}
		} 
}
