package �������ʵ��һ;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ������_Ӷ������ {
	public static void main(String[] args) {
		int lock=0;
		int stock=0;
		int barrel=0;
		int sum=0;
		double commission=0;
		System.out.println("��ֱ����벽ǹ����ǹ�С�ǹ�ܵ���������(����������  �ո�ֿ�)");
		Scanner input = new Scanner(System.in);
		try {
			lock=input.nextInt();
			stock=input.nextInt();
			barrel=input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("�������ݷǷ�  �����˳���");
			System.exit(0);
		}
		if(lock<1||lock>70||stock<1||stock>80||barrel<1||barrel>90){
			System.out.println("�������ݳ�����Χ��");
			return;
		}
		else{//���������ڷ�Χ��  ������������۶�
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
		System.out.println("----------�·����۱���-----------");
		System.out.println("ǹ����     ǹ����     ǹ����     �����۶�        Ӷ��");
		System.out.printf("%5d %5d %5d %6d %8.2f",lock,stock,barrel,sum,commission);
	}

}
