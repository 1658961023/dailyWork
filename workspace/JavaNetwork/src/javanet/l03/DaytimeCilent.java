package javanet.l03;

import java.io.*;
import java.net.*;

public class DaytimeCilent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("localhost",2007);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			System.out.println("�ӷ�������ȡ����ʱ����:"+dis.readInt()+"��"+(dis.readByte()+1)+"��"+dis.readByte()+"��"+dis.readByte()+"ʱ"+dis.readByte()+"��"+dis.readByte()+"��");
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
