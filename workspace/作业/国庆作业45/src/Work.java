import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		String str1,str2;
		System.out.println("Enter two strings:");
		Scanner input=new Scanner(System.in);
		str1=input.nextLine();
		str2=input.nextLine();
		String newstr;
		newstr=str1+str2;
		System.out.println("The new string is "+newstr);
}
}