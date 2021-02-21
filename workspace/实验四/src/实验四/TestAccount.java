package 实验四;

import java.util.Date;
import java.util.Scanner;

public class TestAccount {
	public static void main(String[] args){
Account account=new Account();
System.out.println("输入账号");
Scanner input=new Scanner(System.in);
account.setDate(new Date().toString());
account.setId(input.nextLine());
account.setBalance(0);
int menu=0;
while(menu!=3){
	System.out.print("0---存钱\n1---取钱\n2---查询余额\n3---退出\n");
	menu=input.nextInt();
	if(menu==3){
		break;
	}
	switch(menu){
	case 0:
		System.out.println("存钱数额");
		account.deposit(input.nextDouble());break;
	case 1:
		System.out.println("取钱数额");
		account.withDraw(input.nextDouble());break;
	case 2:
		account.showBalance();break;
	}
}
}
}
