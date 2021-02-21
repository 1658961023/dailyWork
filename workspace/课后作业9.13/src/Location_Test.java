import java.util.Scanner;

public class Location_Test {
	public static void main(String[] args){
		System.out.println("Enter the number of rows and column in the array:");
		int rows,columns;
		Scanner input=new Scanner(System.in);
		rows=input.nextInt();
		columns=input.nextInt();
		int i,j;
		double [][] arrays=new double [rows][columns];
		System.out.println("Enter the array:");
		for(i=0;i<rows;i++){
			for(j=0;j<columns;j++){
				arrays[i][j]=input.nextDouble();
			}
		}
		Location a =Location.locateLargest(arrays);
		System.out.println("The location of the largest is "+a.getMaxValue()+" at ("+a.getRow()+","+a.getColumn()+")");
	}
}
