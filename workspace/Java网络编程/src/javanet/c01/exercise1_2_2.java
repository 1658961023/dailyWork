package javanet.c01;

import java.io.*;
import java.util.List;

public class exercise1_2_2 {
public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	ObjectInputStream ois = new ObjectInputStream(new FileInputStream("shapes.data"));
	List<Shape> list = (List)ois.readObject();
	for(int i=0;i<list.size();i++){
		list.get(i).printInfo();
	}
}
}
