public class Work {
	public static void main(String[] args) {
		int sum=0,i;
		for(i=101;i<200;i++){
			int j=2;
			boolean prime=true;
			for(j=2;j<=Math.sqrt(i);j++){
				if(i%j==0)
					prime=false;
		}
	if(prime)
		{sum++;
		System.out.print(i+",");
		}
		}
		System.out.println("\nÓÐ"+sum+"¸öËØÊý");
	}
}
