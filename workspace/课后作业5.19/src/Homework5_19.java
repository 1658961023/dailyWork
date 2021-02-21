import java.util.*;
public class Homework5_19 {
	public static void main(String[] args){
		int i,j,k;
		for(i=0;i<9;i++){
			int num=0,num2=0;
			for(k=0;k<8-i;k++){
				System.out.print("    ");
			}
			for(j=0;j<i;j++){
				System.out.printf("%4d",(int)(Math.pow(2,num)));
				num++;
			}
			for(j=1;j<i;j++){
				System.out.printf("%4d",(int)(Math.pow(2,num2+i-2)));
				num2--;
			}
			System.out.print("\n");
	}
	}
}
