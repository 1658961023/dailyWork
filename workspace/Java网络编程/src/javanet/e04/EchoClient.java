package javanet.e04;

import java.io.*;
import java.net.Socket;

public class EchoClient {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket("localhost", 7);
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintStream out = new PrintStream(client.getOutputStream());
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while (flag) {
			System.out.print("输入客户端消息：");
			String line = input.readLine();
			out.println(line);
			if ("bye".equals(line)) {
				flag = false;
			} else {
				String echo = br.readLine();
				System.out.println(echo);

			}
			client.close();
			br.close();
		}

	}
}
