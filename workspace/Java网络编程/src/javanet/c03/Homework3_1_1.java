package javanet.c03;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Homework3_1_1 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("www.baidu.com");
		System.out.println("www.baidu.com��IP��ַΪ"+inet.getHostAddress());
		inet = InetAddress.getByName("www.taobao.com");
		System.out.println("www.taobao.com��IP��ַΪ"+inet.getHostAddress());
		inet = InetAddress.getByName("www.bilibili.com");
		System.out.println("www.bilibili.com��IP��ַΪ"+inet.getHostAddress());
	}
}
