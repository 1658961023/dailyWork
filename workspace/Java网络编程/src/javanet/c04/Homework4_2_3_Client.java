package javanet.c04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Homework4_2_3_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			int a = (int) (Math.random() * 10) + 1;
			int b = (int) (Math.random() * 10) + 1;
			String point = a + "," + b;
			System.out.println(point);//随机生成坐标
			DatagramSocket socket;
			try {
				socket = new DatagramSocket();
				DatagramPacket request = new DatagramPacket(point.getBytes(), point.getBytes().length,
						InetAddress.getLocalHost(), 1234);
				DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
				socket.send(request);
				socket.receive(response);
				String result = new String(response.getData(), 0, response.getLength());
				System.out.println(result);
				Thread.sleep(2000);//休眠2秒，定时发送
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
