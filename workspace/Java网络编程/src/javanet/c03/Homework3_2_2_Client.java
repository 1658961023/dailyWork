package javanet.c03;

import java.io.*;
import java.net.*;
import java.util.*;

public class Homework3_2_2_Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("输入两个数:");
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		input.close();
		Socket socket = new Socket("localhost",12345);
		InputStream ins = socket.getInputStream();
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		pw.println(num1);
		pw.println(num2);
		pw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(ins));
		System.out.println("两个数和为"+br.readLine());
		ins.close();
		pw.close();
		br.close();
		socket.close();
	}

}
