package javanet.l01;

import java.io.*;

public class HexIO2 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("Test2.txt");
			FileWriter fw = new FileWriter("TestOut.txt");
			int b, n = 0;
			while ((b = fis.read()) != -1) {
				fw.write(" " + Integer.toHexString(b));
				if (((++n) % 10) == 0)
					fw.write("\n");
			}
			fis.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
