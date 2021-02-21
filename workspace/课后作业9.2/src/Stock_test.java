
public class Stock_test {
	public static void main(String[] args){
		Stock a = new Stock("ORCL","Oracel Corporation");
		a.setPreviousClosingPrice(34.5);
		a.setCurrentPrice(34.35);
		System.out.println("The stock changes "+a.getChangePercent(a.previousClosingPrice, a.currentPrice)+"%");
	}
}
