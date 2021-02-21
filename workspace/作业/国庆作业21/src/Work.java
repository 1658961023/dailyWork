public class Work {
	public static void main(String[] args) {
		System.out.println(Recursion(5)); 
	}
public static int Recursion(int a){
	if(a==0)
		return 1;
	return a*Recursion(a-1);
}
}
