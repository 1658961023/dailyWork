
public class Staff extends Employee{
private String title;
public Staff(){
	
}
public Staff(String title) {
	// TODO Auto-generated constructor stub
	this.title=title;
}
public void setTitle(String title){
	this.title=title;
}
public String getTitle(){
	return title;
}
@Override 
public String toString(){
	String str="";
	str+="Staff \n"+"   Title: "+this.getTitle();
	return str;
}
}
