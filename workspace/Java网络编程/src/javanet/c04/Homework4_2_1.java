package javanet.c04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Random;

public class Homework4_2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
			try (DatagramSocket socket = new DatagramSocket(1234)) {
				String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
				char[] codes = new char[6];
				for (int i = 0; i < 6; i++) {
					Random random = new Random();
					int index = random.nextInt(s.length());
					codes[i] = s.charAt(index);
				}
				String result = String.valueOf(codes);
				DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
				socket.receive(request);
				System.out.println(result);
				DatagramPacket response = new DatagramPacket(result.getBytes(), result.getBytes().length,
						request.getAddress(), request.getPort());
				socket.send(response);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
