package javanet.c01;

import java.io.*;

public class exercise1_1_2 {
public static void main(String[] args) throws IOException {
	File fout = new File("random.txt");
	FileOutputStream fos = new FileOutputStream(fout);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
    for (int i = 1; i < 11; i++) {
        bw.write("Number "+i+":"+(int)((Math.random()*99)+1));
        bw.newLine();
    }
    bw.close();
}
}
