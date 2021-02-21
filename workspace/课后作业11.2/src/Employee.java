
public class Employee extends Person{
protected String Office;
protected double Salary;
protected String date;
public Employee(){
	
}
public Employee(String office,double salary,String date){
	this.Office=office;
	this.Salary=salary;
	this.date=date;
}
public void setOffice(String office){
	this.Office=office;
}
public String getOffice(){
	return Office;
}
public void setSalary(double salary){
	this.Salary=salary;
}
public double getSalary(){
	return Salary;
}
public void setDate(String date){
	this.date=date;
}
public String getDate(){
	return date;
}
@Override
public String toString(){
	String str="";
	str+="Employee "+" \n   Office "+this.getOffice()+"\n   Salary: "+this.getSalary()+"\n   Date: "+this.getDate();
	return str;
}
}
