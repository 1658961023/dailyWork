import java.util.*;

public class Sum {
public static void main(String[] args){
	System.out.println("Enter 5 numbers:");
	Scanner input=new Scanner(System.in);
	ArrayList<Double> array=new ArrayList<Double>();
	for(int i=0;i<5;i++){
		array.add(input.nextDouble());
	}
	System.out.println("The sum is:"+sum(array));
	input.close();
}
public static double sum(ArrayList<Double> list){
	double sum=0;
	for(int i=0;i<list.size();i++ ){
		 sum += list.get(i);
	}
	return sum;
}
}
