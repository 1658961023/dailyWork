package javanet.c03;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Homework3_1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		try {
			socket = new Socket("localhost", 13);
			System.out.println("daytime服务端口开启");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("daytime服务端口关闭");
		}
		
		try {
			socket = new Socket("localhost", 7);
			System.out.println("echo服务端口开启");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("echo服务端口关闭");
		} 
	
		try {
			socket = new Socket("localhost", 80);
			System.out.println("web服务端口开启");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("web服务端口关闭");
		}
		
	}

}
