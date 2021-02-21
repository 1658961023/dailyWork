public class Work {
	public static void main(String[] args) {
	int a,b,c;
	int i;
	for(i=100;i<999;i++){
		a=i%10;
		b=i/10%10;
		c=i/100;
		if(Math.pow(a, 3)+Math.pow(b, 3)+Math.pow(c, 3)==i)
			System.out.print(i+",");
	}
	}
}
