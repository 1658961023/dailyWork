package javanet.c01;

import java.io.*;
import java.util.ArrayList;

public class exercise1_1_3 {
public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream("random.txt");
	FileOutputStream fos = new FileOutputStream("test.txt",true);
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	String line;
	ArrayList<String> list = new ArrayList<>();
	while((line = br.readLine())!=null){
		list.add(line.substring(line.length()-2, line.length()));
	}
	for(int i=0;i<list.size();i++){
		int num = Integer.valueOf(list.get(i));
		if(num>50){
			System.out.println(num);
			bw.write(""+num);
			bw.newLine();
		}
			
	}
	br.close();
	bw.close();
}
}
