package javanet.l03;

import java.io.*;
import java.net.*;
import java.util.*;

public class DaytimeServer {
		public static void main(String[] args) {
			try {
				ServerSocket ss=new ServerSocket(2007);
				while(true){
					new SeverThread(ss.accept()).start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
		

		static class SeverThread extends Thread{
			private Socket socket;
			
			public SeverThread(Socket socket) {
				this.socket = socket;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				DataOutputStream out;
				try {
					out = new DataOutputStream(
							socket.getOutputStream());
					writeTime(out);
					out.close();
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		  
				
			}
			
		}
		public static void writeTime(DataOutputStream out) throws IOException{
			Calendar current=Calendar.getInstance();
			out.writeInt(current.get(Calendar.YEAR));
			out.writeByte(current.get(Calendar.MONTH));
			out.writeByte(current.get(Calendar.DAY_OF_MONTH));
			out.writeByte(current.get(Calendar.HOUR_OF_DAY));
			out.writeByte(current.get(Calendar.MINUTE));
			out.writeByte(current.get(Calendar.SECOND));
		}
}
