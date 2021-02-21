import java.util.*;
public class Homework4_15 {
	public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.println("Enter a letter:");
	char letter;
	String s0;
	s0=input.nextLine();
	String s=s0.toLowerCase();
	letter=s.charAt(0);
	int num;
	if (letter=='a'||letter=='b'||letter=='c')
		System.out.println("The corresponding number is 2");
		else if(letter=='d'||letter=='e'||letter=='f')
			System.out.println("The corresponding number is 3");
			else if(letter=='g'||letter=='h'||letter=='i')
				System.out.println("The corresponding number is 4");
				else if(letter=='j'||letter=='k'||letter=='l')
					System.out.println("The corresponding number is 5");
					else if(letter=='m'||letter=='n'||letter=='o')
						System.out.println("The corresponding number is 6");
						else if(letter=='p'||letter=='q'||letter=='r'||letter=='s')
							System.out.println("The corresponding number is 7");
							else if(letter=='t'||letter=='u'||letter=='v')
								System.out.println("The corresponding number is 8");
									else if(letter=='w'||letter=='x'||letter=='y'||letter=='z')
									System.out.println("The corresponding number is 9");
										 else
										 System.out.println(letter+" is an invalid input");
}
}