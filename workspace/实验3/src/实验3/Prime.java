package 实验3;

import java.util.Scanner;

public class Prime {
	public static void main(String[] args) {
		System.out.println("Enter the num:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		long start=System.currentTimeMillis();
		if (isPrime(num)) {
			System.out.println(num + " is a prime.");
		} else
			System.out.println(num + " is not a prime.");
		showPrime3(num);
		long end=System.currentTimeMillis();
		long time=end-start;
		System.out.println("\n运算时间为"+time+"毫秒");
		input.close();
	}
	public static boolean isPrime(int num) {
		boolean prime = true;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				prime = false;
		}
		return prime;
	}
	public static void showPrime1(int num) {
		int sum = 0;
		for (int i = 2; i < num; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
				sum++;	
				if (sum % 4 == 0)
					System.out.println();
			}
		}
	}

	public static void showPrime2(int num) {
		boolean[] prime = new boolean[num + 1];
		for (int i = 3; i < num + 1; i++) {
			if (i % 2 == 0) {
				prime[i] = false;
			} else {
				prime[i] = true;
			}
			prime[2]=true;
		}
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (prime[i])
				for (int j = i + i; j <= num; j += i)
					prime[j] = false;
		}
		int sum = 0;
		for (int i = 0; i < prime.length; i++) {
			if (prime[i]) {
				System.out.print(i+" ");
				sum++;	
				if (sum % 4 == 0)
					System.out.println();
			}
			
		}

	}
	public static void showPrime3(int num){
		boolean[] prime = new boolean[num + 1];
		prime[2]=true;
		for (int i = 3; i < num + 1; i++) {
			if (i % 2 == 0) {
				prime[i] = false;
			} else {
				prime[i] = true;
			}
		}
		for(int i=3;i<Math.sqrt(num);i+=2){
			if(prime[i]){
				for(int j=0;i*i+2*j*i<=num;j++){
					prime[i*i+2*j*i]=false;
				}
			}
		}
		int sum=0;
		for (int i = 0; i < prime.length; i++) {
			if (prime[i]) {
				System.out.print(i+" ");
				sum++;
				if (sum % 4 == 0)
					System.out.println();
			}
		}
	}
	public static void showPrime4(int num){
		boolean[] v = new boolean[num+1];
		v[2] = true;
		for (int i=3;i<=num;i++) {
			if (i%2==0){
				v[i]=false;
			}else{
				v[i]=true;
			}
		}
		for(int i=3; i<=Math.sqrt(num); i+=2 )
		{   
			if(v[i])
				for(int j=0; i*i+2*i*j<=num; j++) 
					v[i*i+2*i*j] =false;
		}
		int cnt=0;
		for (int i=2;i<=num;i++){
			if(v[i]){
				System.out.print(i+" ");
				cnt++;
			}
			if (cnt==4){
				System.out.println("");
				cnt=0;
			}
		}
		
	}

}
