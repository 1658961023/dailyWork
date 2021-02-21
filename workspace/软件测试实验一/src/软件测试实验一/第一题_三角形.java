package 软件测试实验一;

import java.util.InputMismatchException;
import java.util.Scanner;

public class 第一题_三角形 {
		public static void main(String[] args) {
			float a=0;
			float b=0;
			float c=0;
			Scanner input = new Scanner(System.in);
			System.out.println("输入三条边长度：([1,200]  空格分开)");
			try {
				a=input.nextFloat();
				b=input.nextFloat();
				c=input.nextFloat();
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.out.println("输入数据非法！");
				System.exit(0);
			}
		if((a<1||a>200)||(b<1||b>200)||(c<1||c>200)){//先判断数据是否合法
				System.out.println("输入数据非法！");
			}
			else if(((a+b)<=c)||((a+c)<=b)||((b+c)<=a)){//判断三角形是否存在
				System.out.println("非三角形！");
			}
			else if(a==b&&b==c){//判断等边三角形
				System.out.println("等边三角形");
			}
			else if((a==b)||(a==c)||(b==c)){//判断等腰三角形
				if(((a*a+b*b)==(c*c))||((a*a+c*c)==(b*b))||((b*b+c*c)==(a*a))){//判断等腰直角三角形
					System.out.println("等腰直角三角形");
				}
				else{//非等腰直角三角形的等腰三角形
				System.out.println("等腰三角形");}
			}
			else if(((a*a+b*b)==(c*c))||((a*a+c*c)==(b*b))||((b*b+c*c)==(a*a))){//判断直角三角形
				System.out.println("直角三角形");
			}
			else{//非特殊三角形为一般三角形
				System.out.println("一般三角形");
			}
		}
}
