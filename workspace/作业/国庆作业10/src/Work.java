public class Work {
	public static void main(String[] args) {
		int i,j,k;
		int sum=0;
		for(i=1;i<5;i++){
			for(j=i+1;j<5;j++){
				for(k=j+1;k<5;k++){
						System.out.print(i*100+j*10+k+" ");
						System.out.print(j*100+i*10+k+" ");
						System.out.print(k*100+i*10+j+" ");
						System.out.print(i*100+k*10+j+" ");
						System.out.print(j*100+k*10+i+" ");
						System.out.print(k*100+j*10+i+" ");
						sum+=6;
				}
			}
		}
		System.out.println("\n可组成"+sum+"个数");
	}
}
