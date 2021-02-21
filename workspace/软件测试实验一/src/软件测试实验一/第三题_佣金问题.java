package 软件测试实验一;

import java.util.InputMismatchException;
import java.util.Scanner;

public class 第三题_佣金问题 {
	public static void main(String[] args) {
		int lock=0;
		int stock=0;
		int barrel=0;
		int sum=0;
		double commission=0;
		System.out.println("请分别输入步枪机、枪托、枪管的销售数：(输入正整数  空格分开)");
		Scanner input = new Scanner(System.in);
		try {
			lock=input.nextInt();
			stock=input.nextInt();
			barrel=input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("输入数据非法  程序退出！");
			System.exit(0);
		}
		if(lock<1||lock>70||stock<1||stock>80||barrel<1||barrel>90){
			System.out.println("输入数据超出范围！");
			return;
		}
		else{//输入数据在范围内  可以算出总销售额
			sum=45*lock+30*stock+25*barrel;
		}
		if(sum<=1000){
			commission=sum*0.1;
		}
		else if(sum>1000&&sum<=1800){
			commission=100+(sum-1000)*0.15;
		}
		else if(sum>1800){
			commission=100+800*0.15+(sum-1800)*0.2;
		}
		System.out.println("----------月份销售报告-----------");
		System.out.println("枪机数     枪托数     枪管数     总销售额        佣金");
		System.out.printf("%5d %5d %5d %6d %8.2f",lock,stock,barrel,sum,commission);
	}

}
