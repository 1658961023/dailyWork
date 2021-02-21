import java.util.Scanner;

public class Work {
	public static void main(String[] args) {
		System.out.println("Enter a new string");
		String str=new String();
		Scanner input=new Scanner(System.in);
		str=input.nextLine();
		char [] newstr=str.toCharArray();
		for(int i=0;i<newstr.length;i++){
			for(int j=i+1;j<newstr.length;j++){
				if(newstr[j]<newstr[i]){
					char temp=newstr[j];
					newstr[j]=newstr[i];
					newstr[i]=temp;
				}
			}
		}
		System.out.println("ÅÅÐòºó:");
		for(int i=0;i<newstr.length;i++){
			System.out.print(newstr[i]+"");
		}
	}
}
