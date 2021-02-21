import java.util.*;
public class Homework4_21 {
	public static void main(String[] args){
		String s="111-11-1111";
		Scanner input=new Scanner(System.in);
		String SSN;
		int i;
		System.out.println("Enter a SSN: ");
		SSN=input.nextLine();
		if(SSN.length()!=s.length())
			System.out.println(SSN+" is an invalid social security number");
		else{
		 for (i=0;i<10;i++){
			if (Character.getType(SSN.charAt(i))!=Character.getType(s.charAt(i)))
				{System.out.println(SSN+" is an invaild social security number");
			    break;}
	}
		if(i==10)
		System.out.println(SSN+" is a valid social security number");	
}
	}
}
