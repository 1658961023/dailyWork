package javanet.c04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;


public class Homework4_2_2_Server {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		while(true){
			try(DatagramSocket socket = new DatagramSocket(1234)){
				byte[] nums = new byte[1024];
				DatagramPacket request = new DatagramPacket(nums, nums.length);
				socket.receive(request);
				System.out.println(new String(nums, 0, 1024).trim());
				Integer result = 0;
				String[] recStr = new String(nums, 0, 1024).trim().split(" ");
				for(int i=0;i<recStr.length;i++){
					result += Integer.parseInt(recStr[i]);
				}
				DatagramPacket response = new DatagramPacket(result.toString().getBytes(), result.toString().getBytes().length, request.getAddress(), request.getPort());
				socket.send(response);
			}
		}
		
	}

}
