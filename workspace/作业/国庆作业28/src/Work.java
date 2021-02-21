import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter the matrix:");
		int [][] matrix=new int[3][3];
		Scanner input=new Scanner(System.in);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				matrix[i][j]=input.nextInt();
			}
		}
		int sum=0;
		sum+=matrix[0][0]+matrix[1][1]+matrix[2][2]+matrix[0][2]+matrix[2][0];
		System.out.println("The sum is:"+sum);
	}
}
