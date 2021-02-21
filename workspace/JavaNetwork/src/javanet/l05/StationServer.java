package javanet.l05;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StationServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new sendStationThread(1234)).start();
	}

	static class sendStationThread implements Runnable {
		private int port;
		private Map<String, int[]> buses = new HashMap<>();

		public sendStationThread(int port) {
			this.port = port;
			buses.put("1", new int[] { (int) (Math.random() * 22) + 1, (int) (Math.random() * 22) + 1,
					(int) (Math.random() * 22) + 1 });
			buses.put("233", new int[] { (int) (Math.random() * 27) + 1, (int) (Math.random() * 27) + 1,
					(int) (Math.random() * 27) + 1 });
			buses.put("501", new int[] { (int) (Math.random() * 17) + 1, (int) (Math.random() * 17) + 1,
					(int) (Math.random() * 17) + 1 });
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			DatagramSocket socket = null;
			try {
				socket = new DatagramSocket(port);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			while (true) {
				for (int i = 0; i < 3; i++) {
					buses.get("1")[i] = (int) (Math.random() * 22) + 1;
					buses.get("233")[i] = (int) (Math.random() * 27) + 1;
					buses.get("501")[i] = (int) (Math.random() * 17) + 1;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DatagramPacket response = new DatagramPacket(new byte[64], 64);
				try {
					socket.receive(response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String route = new String(response.getData(), 0, 64).trim();
				System.out.println(route);
				String s;
				if (buses.get(route) == null) {
					s = "";
				} else {
					s = buses.get(route)[0] + "," + buses.get(route)[1] + "," + buses.get(route)[2];
				}
				byte[] buf = s.getBytes();
				DatagramPacket request = new DatagramPacket(buf, buf.length, response.getAddress(), response.getPort());
				request.setData(buf);
				try {
					socket.send(request);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
