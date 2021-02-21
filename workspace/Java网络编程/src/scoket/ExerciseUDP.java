package scoket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExerciseUDP {
	private final static int PORT = 37;
	private static final String HOSTNAME = "time.nist.gov"; 
	public static void main(String[] args) {
		try(DatagramSocket socket = new DatagramSocket(0)){
			socket.setSoTimeout(5000);
			InetAddress host = InetAddress.getByName(HOSTNAME);
			DatagramPacket request = new DatagramPacket(new byte[1], 1 , host , PORT);
			DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
			socket.send(request);
			socket.receive(response);
			ByteBuffer bb = ByteBuffer.allocate(1024);
			bb.put(response.getData(),0,response.getData().length);
			bb.flip();
			Long result = bb.getLong();
			Date date = new Date(result);
			System.out.println(date);
			System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(date));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
