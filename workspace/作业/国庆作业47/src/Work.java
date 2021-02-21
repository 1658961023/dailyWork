import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter the code:");
		Scanner input=new Scanner(System.in);
		int a []=new int[4];
		for(int i=0;i<a.length;i++){
			a[i]=input.nextInt();
			a[i]=(a[i]+5)%10;
		}
		int temp=a[3];
		a[3]=a[0];
		a[0]=temp;
		temp=a[1];
		a[1]=a[2];
		a[2]=temp;
		System.out.println("The code encrypted:");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}
