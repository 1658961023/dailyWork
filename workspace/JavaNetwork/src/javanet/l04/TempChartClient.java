package javanet.l04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class TempChartClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new clientThread(1234));
		t.start();
	}

	static class clientThread implements Runnable {
		private List<Integer> temps = new ArrayList<>();
		private int port;
		public clientThread(int port) {
			super();
			this.port = port;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub			
			DatagramSocket socket=null;
			try {
				socket = new DatagramSocket();
			} catch (SocketException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while (true) {
				try {
					temps.add((int) (Math.random() * 60) - 20);
					byte[] buf = temps.get(temps.size() - 1).toString().getBytes();
					System.out.println(temps.get(temps.size() - 1).toString());					
					DatagramPacket request = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), port);
					request.setData(buf);
					socket.send(request);
					Thread.sleep(1000);
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
}
