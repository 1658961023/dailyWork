public class Work {
	public static void main(String[] args) {
		int sum=0;
	for(int i=1;i<=20;i++){
		int num=1;
		for(int j=1;j<=i;j++){
			num*=j;
		}
		sum+=num;
	}
	System.out.println(sum);
	}
}
