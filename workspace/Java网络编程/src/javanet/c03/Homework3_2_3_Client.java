package javanet.c03;

import java.io.*;
import java.net.*;

public class Homework3_2_3_Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		int flag = 0;
		while (true) {
			Socket socket = new Socket("localhost", 1234);
			System.out.println("输入任意个数字:(逗号分开)");
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
					System.out.println("数字和为" + result);
				if (line == 1)
					System.out.println("数字平均数为" + result);
				if (line == 2)
					System.out.println("数字方差为" + result);
				line++;
			}
			br.close();
			flag++;
			if (flag == 3) {
				System.out.println("接受完三轮数据，关闭连接...");
				socket.close();
				break;
			}
		}
	}
}
