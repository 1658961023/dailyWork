
public class Work {
	public static void main(String[] args) {
		int i;
		for(i=0;i<10000;i++){
			if(Math.pow((int)Math.sqrt(i+100),2)==i+100){
				if(Math.pow((int)Math.sqrt(i+268),2)==i+268)
					System.out.println(i);
			}
		}
	}
}
