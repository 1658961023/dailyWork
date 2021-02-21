package javanet.c05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Homework5_2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ssocket = new ServerSocket(1234);
			while (true) {
				Socket socket = ssocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream os = new PrintStream(socket.getOutputStream());
				String request = br.readLine().trim();
				System.out.println(request);
				StringTokenizer st = new StringTokenizer(request);
				// Read in the method
				String header_method = st.nextToken();
				// Check if we support the method
				if (!header_method.equals("GET")) {
					os.println("HTTP/1.0 501 Not Implemented");
					os.flush();
					return;
				}
				String num1 = request.substring(request.indexOf("a=") + 2, request.indexOf("&"));
				String num2 = request.substring(request.indexOf("b=") + 2, request.length() - 9);
				int a = Integer.parseInt(num1);
				int b = Integer.parseInt(num2);

				StringBuffer responseDocument = new StringBuffer();
				responseDocument.append("<html>\r\n<head>\r\n<title>My HTTP Server</title>\r\n</head>\r\n<body>\r\n");
				responseDocument.append("<h3>" + num1 + "*" + num2 + "=" + a * b + "</h3>\r\n");
				// Now we return the response
				os.print("HTTP/1.0 200 OK\r\n");
				os.print("Content-type: text/html\r\n\r\n");
				os.print(responseDocument);
				os.flush();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
