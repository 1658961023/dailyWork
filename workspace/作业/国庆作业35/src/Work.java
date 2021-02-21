import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter m and n:");
		Scanner input=new Scanner(System.in);
		int m=input.nextInt();
		int n=input.nextInt();
		int [] a=new int[n];
		System.out.println("Enter the array:");
		for(int i=0;i<n;i++){
			a[i]=input.nextInt();
		}
		int [] new1=new int[m];
		int [] new2=new int[n-m];
		for(int i=0;i<n-m;i++){
			new2[i]=a[i];
		}
		for(int i=0;i<m;i++){
		new1[i]=a[n-m+i];
		}
		for(int i=0;i<m;i++){
			System.out.print(new1[i]+" ");
		}
		for(int i=0;i<n-m;i++){
			System.out.print(new2[i]+" ");
		}
	}
}
