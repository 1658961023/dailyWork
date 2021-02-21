public class Work {
	public static void main(String[] args) {
		double s1=1,s2=2,temp=0;
		double sum=0;
		for(int i=0;i<2;i++){
			sum+=(s2/s1); 
			temp=s1+s2;
			s1=s2;
			s2=temp;
		}
		System.out.println("The sum is:"+sum);
	}
}
