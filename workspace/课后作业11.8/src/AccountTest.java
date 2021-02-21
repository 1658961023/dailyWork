
public class AccountTest {
public static void main(String[] args){
	Account account = new Account("George", 1122, 1000);
	account.setAnnualInterestRate(0.015);
	account.deposit(30);
	account.deposit(40);
	account.deposit(50);
	account.withDraw(5);
	account.withDraw(4);
	account.withDraw(2);
	System.out.println(account.getName()+"\n"+account.getAnnualInterestRate()+"\n"+account.getBalance());
	for(int i=0;i<account.transactions.size();i++){
		System.out.println(account.transactions.get(i).getDescription());
	}
}
}
