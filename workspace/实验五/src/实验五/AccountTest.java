package ʵ����;

import java.util.Date;
import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		System.out.println("ѡ�񴴽��˻����ͣ�");
		System.out.print("1---�������˻�  2---֧Ʊ���˻�\n");
		Scanner input = new Scanner(System.in);
		int accountType = input.nextInt();
		input.nextLine();
		Account newaccount = new Account();
		switch (accountType) {
		case 1:
			newaccount = new SavingAccount();
			break;
		case 2:
			System.out.println("��͸֧���Ϊ5000");
			newaccount = new CheckingAccount(5000);
			break;
		}
		System.out.println("�����˺�");
		newaccount.setDate(new Date().toString());
		newaccount.setId(input.nextLine());
		newaccount.setBalance(0);
		int menu = 0;
		while (menu != 3) {
			System.out.print("0---��Ǯ\n1---ȡǮ\n2---��ѯ���\n3---�˳�\n");
			menu = input.nextInt();
			if (menu == 3) {
				break;
			}
			switch (menu) {
			case 0:
				System.out.println("��Ǯ����");
				newaccount.deposit(input.nextDouble());
				break;
			case 1:
				System.out.println("ȡǮ����");
				newaccount.withDraw(input.nextDouble());
				break;
			case 2:
				newaccount.showBalance();
				break;
			}
		}
		input.close();
	}
}
