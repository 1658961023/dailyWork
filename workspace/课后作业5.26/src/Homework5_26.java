import java.util.*;
public class Homework5_26{
	public static void main(String[] args){
		int i,j;
		double e=0;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter i:");
		i=input.nextInt();
		for(j=0;j<=i;j++){
			e+=(1/caculate(j));
		}
		System.out.println(e);
	}
public static double caculate(int a){
	double sum=1,i;
	for(i=0;i<a;i++){
		sum=sum*(i+1);
	}
	return sum;
}
}