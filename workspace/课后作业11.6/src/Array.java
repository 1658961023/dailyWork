import java.util.ArrayList;
import java.util.Date;

public class Array {
	public static void main(String[] args){
ArrayList<Object> array=new ArrayList<Object>();
array.add(new Loan());
array.add(new Circle());
array.add(new String("java"));
array.add(new Date());
for(int i=0;i<array.size();i++){
	System.out.println(array.get(i).toString());
}
	}
}
