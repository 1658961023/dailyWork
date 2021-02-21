package javanet.c01;

import java.io.*;
import java.util.ArrayList;

public class exercise1_1_1 {
public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("test.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line;
		ArrayList<String> list = new ArrayList<>();
		while((line = br.readLine())!=null){
			//System.out.println(line);
			list.add(line);
		}
		for(int i=0;i<list.size();i++){
			String str = list.get(i);
			if(str.indexOf("test")!=-1){
				System.out.println(str);
			}
		}
		br.close();
}
}
