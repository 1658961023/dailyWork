package 实验五;

import java.util.Date;
import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		System.out.println("选择创建账户类型：");
		System.out.print("1---储蓄类账户  2---支票类账户\n");
		Scanner input = new Scanner(System.in);
		int accountType = input.nextInt();
		input.nextLine();
		Account newaccount = new Account();
		switch (accountType) {
		case 1:
			newaccount = new SavingAccount();
			break;
		case 2:
			System.out.println("可透支额度为5000");
			newaccount = new CheckingAccount(5000);
			break;
		}
		System.out.println("输入账号");
		newaccount.setDate(new Date().toString());
		newaccount.setId(input.nextLine());
		newaccount.setBalance(0);
		int menu = 0;
		while (menu != 3) {
			System.out.print("0---存钱\n1---取钱\n2---查询余额\n3---退出\n");
			menu = input.nextInt();
			if (menu == 3) {
				break;
			}
			switch (menu) {
			case 0:
				System.out.println("存钱数额");
				newaccount.deposit(input.nextDouble());
				break;
			case 1:
				System.out.println("取钱数额");
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
