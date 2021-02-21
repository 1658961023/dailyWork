package javanet.c03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework3_3_Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(1234);
		while (true) {
			Thread t = new Thread(new MyThread(ss.accept()));
			t.start();
		}
	}
	static class MyThread implements Runnable{
		private Socket socket;		
		public MyThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try (Socket conn = socket) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String[] nums = br.readLine().split(",");
				int sum = 0;
				float avg = 0;
				float var = 0;
				int temp = 0;
				for (int i = 0; i < nums.length; i++) {
					sum += Integer.parseInt(nums[i]);
				}
				avg = sum / nums.length;
				for (int j = 0; j < nums.length; j++) {
					temp += Math.pow(Integer.parseInt(nums[j]) - avg, 2);
				}
				var = temp / nums.length;
				System.out.println(sum);
				System.out.println(avg);
				System.out.println(var);
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));
				pw.println(sum);
				pw.println(avg);
				pw.println(var);
				pw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
