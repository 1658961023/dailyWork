package javanet.c03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Homework3_1_4 {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost", 13);
		InputStreamReader isr = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		
		while((line=br.readLine()) != null){
			Date date = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd").parse(line);
			System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分").format(date));
		}
		socket.close();
	}

}
