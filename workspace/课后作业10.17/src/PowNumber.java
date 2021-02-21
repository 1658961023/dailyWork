
public class PowNumber {
	public static void main(String[] args) {
		long j=(long) (Math.sqrt(Long.MAX_VALUE)+1);
		for(int i=0;i<10;i++){
			System.out.println(Math.pow(j,2)+" "+j);
			j++;
		}
	}
}
