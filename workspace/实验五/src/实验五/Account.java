package ʵ����;

public class Account {
	protected String id;
	protected double balance;
	protected double rate;
	protected String date;

	public void setId(String id) {
		this.id = id;
	}

	public String getId(String id) {
		return id;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public double withDraw(double money) {
		if (money > this.balance) {
			System.out.println("���㣡��");
			return this.balance;
		}
		return this.balance -= money;
	}

	public double deposit(double money) {
		return this.balance += money;
	}

	public void showBalance() {
		System.out.println("�˺ţ�" + this.id);
		System.out.println("�������ڣ�" + this.date);
		System.out.println("��" + this.balance);
	}
}
