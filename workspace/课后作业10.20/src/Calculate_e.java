import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculate_e {
	public static void main(String[] args){
		BigDecimal e = new BigDecimal(1);
		System.out.println("Enter the i:");
		Scanner input=new Scanner(System.in);
		int i=input.nextInt();
		for(long j=1;j<=i;j++){
			e=e.add(BigDecimal.ONE.divide(Fac(j), 25, RoundingMode.UP));
		}
		System.out.println(e);
	}
	public static BigDecimal Fac(long n){
		BigDecimal result=BigDecimal.ONE;
		for(int i=1;i<=n;i++){
			result=result.multiply(new BigDecimal(i+""));
		}
		return result;
	}
}
