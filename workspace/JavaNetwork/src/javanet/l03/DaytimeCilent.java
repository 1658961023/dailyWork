package javanet.l03;

import java.io.*;
import java.net.*;

public class DaytimeCilent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("localhost",2007);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			System.out.println("从服务器获取到的时间是:"+dis.readInt()+"年"+(dis.readByte()+1)+"月"+dis.readByte()+"日"+dis.readByte()+"时"+dis.readByte()+"分"+dis.readByte()+"秒");
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
