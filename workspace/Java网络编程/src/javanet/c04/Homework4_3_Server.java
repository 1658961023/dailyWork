package javanet.c04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Homework4_3_Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DatagramSocket socket = new DatagramSocket(1234);
        DatagramPacket packet = null;
        while(true){
            packet = new DatagramPacket(new byte[1024], 1024);
            socket.receive(packet);//阻塞
            Thread thread = new Thread(new ServeThread(socket, packet));
            thread.start();           
        }

	}

	static class ServeThread implements Runnable {
		DatagramSocket socket = null;
		DatagramPacket packet = null;

		public ServeThread(DatagramSocket socket, DatagramPacket packet) {
			this.socket = socket;
			this.packet = packet;
		}

		@Override
		public void run() {
			String info = null;
			InetAddress address = null;
			int port = 1234;
			DatagramPacket packet2 = null;
			try {
				info = new String(packet.getData(), 0, packet.getLength());
				System.out.println("客户端"+packet.getPort()+"请求题目...");
				address = packet.getAddress();
				port = packet.getPort();
				String question = getRandomQuestion();
				packet2 = new DatagramPacket(question.getBytes(), question.getBytes().length, address, port);
				socket.send(packet2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public String getRandomQuestion() {
			try {
				int i = 0;
				BufferedReader br = new BufferedReader(new FileReader("src/javanet/c04/questions.txt"));
				int index = (int) (Math.random() * 19)+1;
				System.out.println("取出题目"+index);
				String q;
				while ((q=br.readLine()) != null) {
					if (i == index) {
						return q;
					} else
						i++;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";

		}
	}

}
