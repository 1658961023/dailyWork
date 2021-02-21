import java.util.Scanner;;
public class Homework5_9 {
	public static void main(String[] args){
		System.out.println("Enter the num of students");
		Scanner input=new Scanner(System.in);
		int sum;
		sum=input.nextInt();
		int i;
		String name[]; name=new String [sum];
		int grades[]; grades=new int [sum];
		String first_student=null,second_student=null;
		int max_grade=0,second_grade=0;
		System.out.println("Enter student's name and grades");
		for(i=0;i<sum;i++){
			name[i]=input.next();
			grades[i]=input.nextInt();
			}
		for(i=0;i<sum;i++){
			if(grades[i]>max_grade){
				max_grade=grades[i];
				first_student=name[i];
			}
		}
		for(i=0;i<sum;i++){
			if(grades[i]<max_grade&&grades[i]>second_grade){
				second_grade=grades[i];
				second_student=name[i];
			}
		}
		System.out.println("The first student is "+first_student+" and the second student is "+second_student);
		}
}


