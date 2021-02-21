import java.util.*;

public class Test {
public static void main(String[] args) {
	Person person=new Person("Paul","D-101","123456","123456@Google");
	Student student=new Student();
	student.setStatus(student.getFreshman());
	Employee employee=new Employee("D101",10000,new Date().toString());
	Faculty faculty=new Faculty("8:00~18:00","Boss");
	Staff staff=new Staff("javaTeacher");
	System.out.println(person.toString());
	System.out.println(student.toString());
	System.out.println(employee.toString());
	System.out.println(faculty.toString());
	System.out.println(staff.toString());
}
}
