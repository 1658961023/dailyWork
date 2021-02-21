package javanet.c04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Homework4_2_3_Server {

	private static final double safeDis = 10;// 设定安全距离为10,中心位置坐标为(0,0)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			try (DatagramSocket socket = new DatagramSocket(1234)) {
				byte[] point = new byte[1024];
				DatagramPacket request = new DatagramPacket(point, point.length);
				socket.receive(request);
				System.out.println(new String(point, 0, 1024).trim());
				String result = "";
				int a = Integer.parseInt(new String(point, 0, 1024).trim().split(",")[0]);
				int b = Integer.parseInt(new String(point, 0, 1024).trim().split(",")[1]);
				double distance = Math.pow(a * a + b * b, 0.5);
				if (distance < safeDis) {
					result = "Safe distance...";
				} else {
					result = "警报：超出安全距离！";
				}
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
