package javanet.c03;

import java.io.*;
import java.net.*;

public class Homework3_2_2_Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ssocket = new ServerSocket(12345);
			try(Socket connection = ssocket.accept()){
				InputStream ins = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(ins));
				String num1 = br.readLine();
				String num2 = br.readLine();
				int result = Integer.parseInt(num1)+Integer.parseInt(num2);
				System.out.println(num1+"+"+num2+"="+result);
				PrintWriter pw = new PrintWriter(connection.getOutputStream(),true);
				pw.println(result);
				pw.flush();	
		}
	}

}
