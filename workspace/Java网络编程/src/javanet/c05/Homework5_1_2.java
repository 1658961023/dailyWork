package javanet.c05;

import java.net.MalformedURLException;
import java.net.URL;

public class Homework5_1_2 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL url = new URL("https://www.baidu.com/");
		System.out.println("协议  " + url.getProtocol());
		System.out.println("主机  " + url.getHost());
		System.out.println("端口号  " + url.getPort());
		System.out.println("路径  " + url.getPath());
		System.out.println("请求参数  " + url.getQuery());
		System.out.println("定位位置  " + url.getRef());
	}

}
