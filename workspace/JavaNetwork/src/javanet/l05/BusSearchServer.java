package javanet.l05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BusSearchServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(1234);
		while (true) {
			new ServerThread(ss.accept()).start();
		}
	}

	static class ServerThread extends Thread {
		private Socket socket;

		public ServerThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				searchRoute(socket.getInputStream(), socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public static void searchRoute(InputStream ins, OutputStream os) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(ins));
			BufferedReader br2 = new BufferedReader(new FileReader("src/javanet/l05/busRoute.txt"));
			String s;
			String route = br.readLine().trim();
			boolean flag = false;
			PrintWriter pw = new PrintWriter(os);
			while ((s = br2.readLine()) != null) {
				if (s.split(",")[0].equals(route)) {
					pw.println(s.split(",")[1]);
					pw.println();
					pw.flush();
					flag = true;
					break;
				}
			}
			if(!flag){
				pw.println("");
				pw.flush();
			}
			br2.close();
		}

	}

}
