package ʵ����;

import java.util.Date;
import java.util.Scanner;

public class TestAccount {
	public static void main(String[] args){
Account account=new Account();
System.out.println("�����˺�");
Scanner input=new Scanner(System.in);
account.setDate(new Date().toString());
account.setId(input.nextLine());
account.setBalance(0);
int menu=0;
while(menu!=3){
	System.out.print("0---��Ǯ\n1---ȡǮ\n2---��ѯ���\n3---�˳�\n");
	menu=input.nextInt();
	if(menu==3){
		break;
	}
	switch(menu){
	case 0:
		System.out.println("��Ǯ����");
		account.deposit(input.nextDouble());break;
	case 1:
		System.out.println("ȡǮ����");
		account.withDraw(input.nextDouble());break;
	case 2:
		account.showBalance();break;
	}
}
}
}
