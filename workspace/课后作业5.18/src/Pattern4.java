import java.util.*;
public class Pattern4 {
	public static void main(String[] args){
		int i,j,k;
		for(i=6;i>0;i--){
			int num=1;
			for(k=0;k<6-i;k++){
				System.out.print("  ");
			}
			for(j=0;j<i;j++){
				System.out.print(num+" ");
				num++;
			}
			System.out.print("\n");
	}
	}
}
