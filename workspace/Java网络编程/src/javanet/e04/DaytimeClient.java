package javanet.e04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class DaytimeClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 13);
		InputStreamReader isr = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String line;
		while((line=br.readLine()) != null){
			System.out.println(line);
		}
		socket.close();
	}
}
