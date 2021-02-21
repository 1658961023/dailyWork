package javanet.c05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Homework5_2_1 {

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
				String page = request.substring(request.indexOf("page=") + 5, request.length() - 9);

				StringBuffer responseDocument1 = new StringBuffer();
				responseDocument1.append("<html>\r\n<head>\r\n<title>HTTP Server</title>\r\n</head>\r\n<body>\r\n");
				responseDocument1.append("<h3>Ò³Ãæ1</h3>\r\n");
				responseDocument1.append("<img src=\"http://pic41.nipic.com/20140429/12728082_192158998000_2.jpg\">\r\n");	
				StringBuffer responseDocument2 = new StringBuffer();
				responseDocument2.append("<html>\r\n<head>\r\n<title>HTTP Server</title>\r\n</head>\r\n<body>\r\n");
				responseDocument2.append("<h3>Ò³Ãæ2</h3>\r\n");
				responseDocument2.append("<img src=\"http://pic.58pic.com/58pic/14/61/00/58PIC4V58PICm9B_1024.jpg\">\r\n");
				StringBuffer responseDocument404 = new StringBuffer();
				responseDocument404.append("<html>\r\n<head>\r\n<title>HTTP Server</title>\r\n</head>\r\n<body>\r\n");
				responseDocument404.append("<img src=\"https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1555151358240&amp;di=1a2fa4339b1ed9ad78065f81816d6b1b&amp;imgtype=0&amp;src=http%3A%2F%2Fwww.daochongyingxiao.com%2Fdata%2Fupload%2Fimage%2F20181012%2F1539306152764366.png\">\r\n");
				switch (page) {
				case "1":
					os.print("HTTP/1.1 200 OK\r\n");
					os.print("Content-type: text/html\r\n\r\n");
					os.print(responseDocument1);
					os.flush();
					break;
				case "2":
					os.print("HTTP/1.1 200 OK\r\n");
					os.print("Content-type: text/html\r\n\r\n");
					os.print(responseDocument2);
					os.flush();
					break;
				default:
					os.print("HTTP/1.1 404 not found\r\n");
					os.print("Content-type: text/html\r\n\r\n");
					os.print(responseDocument404);
					os.flush();
					break;
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
