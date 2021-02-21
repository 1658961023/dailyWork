import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter a new string end with .:");
		String str=new String();
		Scanner input=new Scanner(System.in);
		str=input.nextLine();
		str.length();
		System.out.println("There are "+length(str)+" characters");
	}

	private static int length(String a) {
		int sum=0;
		for(int i=0;;i++){
			if(a.charAt(i)!='.'){
			sum++;
		}
			else
				break;}
		return sum;
	}
}
