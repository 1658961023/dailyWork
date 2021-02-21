
public class Student extends Person{
	private int status;
private final int Freshman=1;
private final int Sophomore=2;
private final int Junior=3;
private final int Senior=4;
public Student(){
	
}

public int getFreshman() {
	return Freshman;
}

public int getSophomore() {
	return Sophomore;
}

public int getJunior() {
	return Junior;
}

public int getSenior() {
	return Senior;
}

public Student(int status){
	this.status=status;
}
public void setStatus(int status){
	this.status=status;
}
public int getStatus(){
	return status;
}
@Override
public String toString(){
	String str="";
	str+="Student \n"+"   Class status: "+getStatus();
	return str;
}
}
