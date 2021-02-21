import java.math.BigInteger;

public class Mersenne {
public static void main(String[] args){
	BigInteger a=new BigInteger("2");
	System.out.println("p 2^p-1");
	for(int p=2;p<=100;p++){
		BigInteger result=BigInteger.ONE;
		for(int j=1;j<=p;j++){
			result=result.multiply(a);
		}
		result=result.subtract(BigInteger.ONE);
		BigInteger i=a;
		for(i=a;i.compareTo(result)<=0;i=i.add(BigInteger.ONE)){
			if(result.mod(i).equals(BigInteger.ZERO)){
				break;
			}
		}
		if(i.compareTo(result)>=0){
			System.out.println(p+" "+result);
		}
	}
	
}
}
