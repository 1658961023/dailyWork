package µÚÒ»Ìâ;

import java.util.ArrayList;

public class TriangleTest {
	public static void main(String[] args) {
	ArrayList<Double> list1=new ArrayList<Double>();
	ArrayList<Double> list2=new ArrayList<Double>();
	ArrayList<Double> list3=new ArrayList<Double>();
	list1.add(3.0);
	list1.add(4.0);
	list1.add(5.0);
	list2.add(3.0);
	list2.add(4.0);
	list2.add(5.0);
	list3.add(3.0);
	list3.add(3.0);
	list3.add(3.0);
Triangle t1=new Triangle(list1);
Triangle t2=new Triangle(list2);
Triangle t3=new Triangle(list3);
System.out.println(t1.equals(t2));
System.out.println(t1.equals(t3));
}
}
