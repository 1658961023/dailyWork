package javanet.c05;

import java.net.MalformedURLException;
import java.net.URL;

public class Homework5_1_2 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		URL url = new URL("https://www.baidu.com/");
		System.out.println("Э��  " + url.getProtocol());
		System.out.println("����  " + url.getHost());
		System.out.println("�˿ں�  " + url.getPort());
		System.out.println("·��  " + url.getPath());
		System.out.println("�������  " + url.getQuery());
		System.out.println("��λλ��  " + url.getRef());
	}

}
