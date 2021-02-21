package javanet.c04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework4_1_1 {

	public final static int PORT = 37;
	public final static String HOST = "time.nist.gov";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress host = null;

		try {
			if (args.length > 0) {
				host = InetAddress.getByName(args[0]);
			} else {
				host = InetAddress.getByName(HOST);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UDPPoke poker = new UDPPoke(host,PORT);
		byte [] response = poker.poke();
		if(response == null){
			System.out.println("No response within alltted time");
		} else if(response.length != 4){
			System.out.println("unrecongized response format");
			return;
		}

		long differenceBetweenEpochs = 2208988800L;
		
		long secondsSince1990 = 0;
		for(int i=0;i<4;i++){
			secondsSince1990 = (secondsSince1990 << 8) | (response[i] & 0x000000FF);
		}
		long secondsSince1970 = secondsSince1990 - differenceBetweenEpochs;
		long msSince1970 = secondsSince1970*1000;
		Date time = new Date(msSince1970);
		
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分").format(time));
	}

}
