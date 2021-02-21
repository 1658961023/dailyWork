import java.util.*;
import java.io.*;

public class Work {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input=new Scanner(System.in);
		java.io.File file =new java.io.File("D:\\stud.txt");
		try(java.io.PrintWriter output=new java.io.PrintWriter(file);
		)
		{System.out.println("Enter the information of student ");
		String str =input.next();
		String []student=str.split("\\.");
		for(int i=0;i<2;i++){
			output.println(student[i]);
			String [] scores=student[i].split("\\,");
			int [] grades=new int[3];
			int sum=0;
			for(int j=0;j<3;j++){
				grades[j]=Integer.parseInt(scores[j+2]);
				sum+=grades[j];
			}
			double average=sum/3;
			output.println(average);
		}
	}
}
}