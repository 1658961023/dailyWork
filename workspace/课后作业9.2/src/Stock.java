
public class Stock {
	private String symbol,name;
	public Stock(){
		
	}
	public Stock(String symbol,String name){
		this.symbol = symbol;
		this.name = name;
	}
	 double previousClosingPrice,currentPrice;
	 public void setPreviousClosingPrice(double previousClosingPrice){
		 this.previousClosingPrice=previousClosingPrice;
	 }
	 public void setCurrentPrice(double currentPrice){
		 this.currentPrice=currentPrice;
	 }
	 public double getChangePercent(double prevoiusClosingPrice,double currentPrice){
		 return (prevoiusClosingPrice-currentPrice)/prevoiusClosingPrice*100;
	 }
}
