package javanet.c04;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.ntp.TimeStamp;

public class Homework4_1_2 {
	
	private static final String HOSTNAME = "ntp1.aliyun.com";

	public static void main(String[] args) {
		try {
			NTPUDPClient timeClient = new NTPUDPClient();
			InetAddress timeServerAddress = InetAddress.getByName(HOSTNAME);
			TimeInfo timeInfo = timeClient.getTime(timeServerAddress);
			TimeStamp timeStamp = timeInfo.getMessage().getTransmitTimeStamp();
			System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分").format(timeStamp.getDate()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
