public class Work {
	public static void main(String[] args) {
		for(int i=0;i<7;i++){
			int j=(int)(Math.random()*50+1);
			System.out.print(j);
			for(int k=0;k<j;k++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
