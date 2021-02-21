import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("输入一个偶数:");
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		for(int i=2;i<a/2;i++){
			if(isPrime(i)&&isPrime(a-i)){
				System.out.println(a+"="+i+"+"+(a-i));
				break;
			}
		}
	}
public static boolean isPrime(int n){
	boolean prime=true;
	for(int i=2;i<n;i++){
		if(n%i==0){
			prime=false;break;
		}
	}
	return prime;
}
}
