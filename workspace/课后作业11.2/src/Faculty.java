
public class Faculty extends Employee{
private String worktime;
private String level;
public Faculty(){
	
}
public Faculty(String worktime, String level) {
	this.worktime=worktime;
	this.level=level;
}
public void setWorktime(String worktime){
	this.worktime=worktime;
}
public String getWorktime(){
	return worktime;
}
public void setLevel(String level){
	this.level=level;
}
public String getLevel(){
	return level;
}
@Override
public String toString(){
	String str="";
	str+="Faculty \n"+"   Worktime:"+this.getWorktime()+"\n   Level: "+this.getLevel();
	return str;
}
}
