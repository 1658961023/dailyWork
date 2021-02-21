
public class Fan_test {
	public static void main(String[] args){
		Fan f1=new Fan();
		Fan f2=new Fan();
		f1.setFan(3,true,10,"yellow");
		f2.setFan(2, false, 5,"blue");
		System.out .println(f1.toString());
		System.out .println(f2.toString());
	}
}
