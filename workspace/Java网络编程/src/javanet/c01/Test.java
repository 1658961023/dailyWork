package javanet.c01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        String line = null;
        LinkedList<String> list = new LinkedList<String>();
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if(list.get(i).contains("test")){
                System.out.println(list.get(i));
            }
        }
        reader.close();
    }

}
