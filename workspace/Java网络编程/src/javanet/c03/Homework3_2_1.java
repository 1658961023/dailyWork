package javanet.c03;

import java.io.*;
import java.net.*;

public class Homework3_2_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(1234);
		while(true){
			try(Socket connection = server.accept()){
				Writer out = new OutputStreamWriter(connection.getOutputStream());
				out.write("send"+(int)((Math.random()*100)+1)+"...");
				out.flush();
			}
		}
	}

}
