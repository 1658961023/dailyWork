import java.util.*;
public class Homework5_48 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		String str;
		System.out.println("Enter a string:");
		str=input.nextLine();
		int i;
		for(i=0;i<str.length();i+=2){
			System.out.print(str.charAt(i));
		}
	}
}
