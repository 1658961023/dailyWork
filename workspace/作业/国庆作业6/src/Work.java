import java.lang.*;
import java.util.*;
public class Work {
	public static void main(String[] args) {
		System.out.println("Enter the string");
		String str=new String();
		Scanner input=new Scanner(System.in);
		str=input.nextLine();
		Character a=' ';
		int i,letters=0,digits=0,speace=0,other=0;
		for(i=0;i<str.length();i++){
			if(Character.isLetter(str.charAt(i)))
				letters++;
			else if(Character.isDigit(str.charAt(i)))
					digits++;
			else if(a.equals(str.charAt(i)))
				speace++;
			else
				other++;
		}
		System.out.println("有"+letters+"个英文字母和"+digits+"个数字"+speace+"个空格"+other+"个其他字符");
	}
}
