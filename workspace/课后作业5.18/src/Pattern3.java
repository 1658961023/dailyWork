import java.util.*;
public class Pattern3 {
	public static void main(String[] args){
		int i,j,k;
		for(i=0;i<7;i++){
			int num=0;
			for(k=0;k<6-i;k++){
				System.out.print("  ");
			}
			for(j=0;j<i;j++){
				System.out.print((num+i)+" ");
				num--;
			}
			System.out.print("\n");
	}
	}
}
