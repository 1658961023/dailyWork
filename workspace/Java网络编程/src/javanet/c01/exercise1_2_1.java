package javanet.c01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class exercise1_2_1 {
public static void main(String[] args) throws FileNotFoundException, IOException {
	List<Shape> list = new ArrayList<>();
	for(int i=0;i<5;i++){
		if(Math.random()>0.5){
			Circle c = new Circle((int)((Math.random()*5)+1));
			list.add(c);
		}
		else{
			Rectangle r = new Rectangle((int)((Math.random()*5)+1),(int)((Math.random()*5)+1));
			list.add(r);
		}
	}
	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("shapes.data"));
	for(int i=0;i<list.size();i++){
		list.get(i).printInfo();
	}
	oos.writeObject(list);
	oos.close();
}
}
