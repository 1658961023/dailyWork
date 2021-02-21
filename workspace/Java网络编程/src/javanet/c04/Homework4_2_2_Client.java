package javanet.c04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Homework4_2_2_Client {

	public static void main(String[] args) throws IOException {
		int num = (int) (Math.random() * 50) + 1;
		String str = "";
		for (int i = 0; i < num; i++) {
			str += (int) (Math.random() * 1001)+" ";
		}
		byte[] buff = str.getBytes();
		System.out.println(str);
		DatagramSocket socket = new DatagramSocket();
		DatagramPacket request = new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), 1234);
		DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
		socket.send(request);
		socket.receive(response);
		String result = new String(response.getData(), 0, response.getLength());
		System.out.println("计算结果为:" + result);
		socket.close();
	}

}
