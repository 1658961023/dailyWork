package javanet.c06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;

public class Homework6_2_MachineB {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(1234);
		BufferedReader br2 = new BufferedReader(
				new InputStreamReader(new FileInputStream("src/javanet/c06/key_rsa.txt")));
		String s = "";
		String privateKey = "";
		while ((s = br2.readLine()) != null) {
			privateKey += s;
		}
		while (true) {
			Socket socket = ss.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = br.readLine();
			String data = msg.split(",")[0];
			String text = msg.split(",")[1];
			System.out.println("���ļ����ݽ��жԳƼ����㷨���ܣ�"
					+ Encrypt(text.getBytes(), Integer.parseInt(decryptByPrivateKey(data, privateKey))));
			System.out.println("˽Կ���ܺ�����룺" + decryptByPrivateKey(data, privateKey));
			System.out.println("��ϢժҪ:" + getMD5Digest(text));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(Encrypt(text.getBytes(), Integer.parseInt(decryptByPrivateKey(data, privateKey))) + ","
					+ getMD5Digest(text));
			pw.flush();
		}
	}

	public static byte[] decryptByPrivateKey(byte[] data, byte[] privateKey) throws Exception {

		// ʵ������Կ����

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		// ����˽Կ

		PrivateKey key = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKey));

		// ���ݽ���

		Cipher cipher = Cipher.getInstance("RSA");

		cipher.init(Cipher.DECRYPT_MODE, key);

		return cipher.doFinal(data);

	}

	public static String decryptByPrivateKey(String data, String privateKey) throws Exception {

		byte[] key = Base64.getDecoder().decode(privateKey);

		return new String(decryptByPrivateKey(Base64.getDecoder().decode(data), key), "UTF-8");

	}

	public static String Encrypt(byte[] bytes, int key) {
		byte[] newBytes = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			newBytes[i] = (byte) (bytes[i] + key - key * 2);
		}
		byte temp;
		for (int i = 0; i < newBytes.length / key; i++) {// ��ĳһ�ν��н���
			temp = newBytes[i];
			newBytes[i] = newBytes[newBytes.length / 2 - i];
			newBytes[newBytes.length / 2 - i] = temp;
		}
		return new String(newBytes);
	}

	public static String getMD5Digest(String msg) throws NoSuchAlgorithmException {
		MessageDigest md5Digest = MessageDigest.getInstance("MD5");
		// ����Ҫ���������
		md5Digest.update(msg.getBytes());
		// ��ɹ�ϣ���㣬�õ�ժҪ
		byte[] md5Encoded = md5Digest.digest();
		return (new BASE64Encoder()).encodeBuffer(md5Encoded);
	}

}
