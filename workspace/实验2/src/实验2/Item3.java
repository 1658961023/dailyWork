package สตั้2;

import java.util.Scanner;

public class Item3 {
	public static void main(String[] args){
		int n,i;
		System.out.println("Enter the n:"); 
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		while(n%2==0){
			n/=2;
			System.out.print(2+" ");
			}
		for(i=3;i<=n;i++){
			if(n%i==0){
				n/=i;
				System.out.print(i+" ");
			}
		}
	}
}
