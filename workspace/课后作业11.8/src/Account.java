import java.util.ArrayList;
import java.util.Date;

public class Account {
	public Account() {
	}

	private String name;
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	public Account(String name, int id, double balance) {
		this.name = name;
		this.id = id;
		this.balance = balance;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getId(int id) {
		return id;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate / 100;
	}

	public void getDateCreated() {
		System.out.println(dateCreated);
	}

	public void withDraw(double money) {
		this.transactions.add(new Transaction('W', money, this.balance -= money, "WithDraw " + money));
	}

	public void deposit(double money) {
		this.transactions.add(new Transaction('D', money, this.balance += money, "Deposit " + money));
	}

	public double getmonthlyInterest(double annualInterestRate) {
		return balance * (annualInterestRate / 12);
	}
}
