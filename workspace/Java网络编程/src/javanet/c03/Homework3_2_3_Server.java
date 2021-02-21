package javanet.c03;

import java.io.*;
import java.net.*;

public class Homework3_2_3_Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(1234);
		int flag = 0;
		while (true) {
			try (Socket conn = ss.accept()) {
				if (flag == 3) {
					ss.close();
					break;
				}
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String[] nums = br.readLine().split(",");
				int sum = 0;
				float avg = 0;
				float var = 0;
				int temp = 0;
				for (int i = 0; i < nums.length; i++) {
					sum += Integer.parseInt(nums[i]);
				}
				System.out.println(nums.length);
				avg = sum / nums.length;
				for (int j = 0; j < nums.length; j++) {
					temp += Math.pow(Integer.parseInt(nums[j]) - avg, 2);
				}
				var = temp / nums.length;
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));
				pw.println(sum);
				pw.println(avg);
				pw.println(var);
				pw.flush();
			}
		}
	}
}
