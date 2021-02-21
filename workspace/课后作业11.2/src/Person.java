
public class Person {
protected String name;
protected String address;
protected String phone;
protected String email;
public Person(){
	
}
public Person(String name,String address,String phone,String email){
	this.name=name;
	this.address=address;
	this.phone=phone;
	this.email=email;
}
public String getName(){
	return name;
}
public void setName(String name){
	this.name=name;
}
public String getAddress(){
	return address;
}
public void setAddress(String address){
	this.address=address;
}
public String getPhone(){
	return phone;
}
public void setPhone(String phone){
	this.phone=phone;
}
public String getEmail(){
	return email;
}
public void setEmail(String email){
	this.email=email;
}
@Override
public String toString(){
	String str="";
	str+="Person\n   Name: "+this.name+"\n   Address: "+this.address+"\n   Phone: "+this.phone+"\n   Email:"+this.email;
	return str;
}
}
