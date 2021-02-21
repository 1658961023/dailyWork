package javanet.c03;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Homework3_1_2 {

	public static void main(String[] args) throws UnknownHostException, SocketException {
		// TODO Auto-generated method stub
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println("本机IP地址为：" + inet.getHostAddress());
		byte[] mac = NetworkInterface.getByInetAddress(inet).getHardwareAddress();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				sb.append("-");
			}
			String s = Integer.toHexString(mac[i] & 0xFF);
			sb.append(s.length() == 1 ? 0 + s : s);
		}
		System.out.println("本机MAC地址是:"+sb.toString().toUpperCase());
		//若程序运行异常，请关闭网络连接后再运行。
	}

}
