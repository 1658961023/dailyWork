package ʵ����;

public class CheckingAccount extends Account{
	protected double maxOverdraw;
public CheckingAccount(){
	
}
public CheckingAccount(double maxOverdraw){
	this.maxOverdraw=maxOverdraw;
}
public double getMaxOverdraw(){
	return maxOverdraw;
}
public void setMaxOverdraw(double maxOverdraw){
	this.maxOverdraw=maxOverdraw;
}
@Override
public double withDraw(double money){
	if((this.balance-money)<-maxOverdraw){
		System.out.println("��͸֧����!!!");
		return this.balance;
	}
	return this.balance-=money;
	
}
}
