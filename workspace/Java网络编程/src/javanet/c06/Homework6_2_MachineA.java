package javanet.c06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import sun.misc.BASE64Encoder;

public class Homework6_2_MachineA {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src/javanet/c06/key_rsa_pub.txt")));
		String secretCode = (int) (Math.random() * 20) + 1 + "";
		String text = "Hello World!!�ϲ����մ�ѧ";
		String s = "";
		String publicKey = "";
		while ((s = br.readLine()) != null) {
			publicKey += s;
		}
		System.out.println("���͵��ļ����ݣ�"+text);
		System.out.println("���ɵ�������룺" + secretCode);
		System.out.println("��Կ���ܺ�:" + encryptByPublicKey(secretCode, publicKey));
		Socket socket = new Socket("localhost", 1234);
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		pw.println(encryptByPublicKey(secretCode, publicKey) + "," + text);
		pw.flush();
		br.close();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg = br2.readLine();
		System.out.println("���ܺ���ļ����ݣ�" + Decrypt(msg.split(",")[0].getBytes(), Integer.parseInt(secretCode)));
		System.out.println("����B���͵���ϢժҪ��" + msg.split(",")[1]);
		System.out.println("�������ϢժҪ��"+getMD5Digest(text));
		socket.close();
	}

	public static String encryptByPublicKey(String data, String publicKey) throws Exception {

		byte[] key = Base64.getDecoder().decode(publicKey);

		return Base64.getEncoder().encodeToString(encryptByPublicKey(data.getBytes("UTF-8"), key));

	}

	public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {

		// ʵ������Կ����

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		// ���ɹ�Կ

		PublicKey key = keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));

		// ���ݼ���

		Cipher cipher = Cipher.getInstance("RSA");

		cipher.init(Cipher.ENCRYPT_MODE, key);

		return cipher.doFinal(data);

	}

	public static String Decrypt(byte[] bytes, int key) {
		byte[] newBytes = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			newBytes[i] = (byte) (bytes[i] - key + 2 * key);
		}
		byte temp;
		for (int i = 0; i < newBytes.length / key; i++) {
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
