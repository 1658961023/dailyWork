package javanet.c03;

import java.io.*;
import java.net.*;

public class Homework3_2_3_Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		int flag = 0;
		while (true) {
			Socket socket = new Socket("localhost", 1234);
			System.out.println("�������������:(���ŷֿ�)");
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String nums = input.readLine();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			pw.println(nums);
			pw.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String result = null;
			int line = 0;
			while ((result = br.readLine()) != null) {
				if (line == 0)
					System.out.println("���ֺ�Ϊ" + result);
				if (line == 1)
					System.out.println("����ƽ����Ϊ" + result);
				if (line == 2)
					System.out.println("���ַ���Ϊ" + result);
				line++;
			}
			br.close();
			flag++;
			if (flag == 3) {
				System.out.println("�������������ݣ��ر�����...");
				socket.close();
				break;
			}
		}
	}
}
