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
		String text = "Hello World!!南昌航空大学";
		String s = "";
		String publicKey = "";
		while ((s = br.readLine()) != null) {
			publicKey += s;
		}
		System.out.println("发送的文件内容："+text);
		System.out.println("生成的随机密码：" + secretCode);
		System.out.println("公钥加密后:" + encryptByPublicKey(secretCode, publicKey));
		Socket socket = new Socket("localhost", 1234);
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		pw.println(encryptByPublicKey(secretCode, publicKey) + "," + text);
		pw.flush();
		br.close();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg = br2.readLine();
		System.out.println("解密后的文件内容：" + Decrypt(msg.split(",")[0].getBytes(), Integer.parseInt(secretCode)));
		System.out.println("机器B发送的消息摘要：" + msg.split(",")[1]);
		System.out.println("计算的消息摘要："+getMD5Digest(text));
		socket.close();
	}

	public static String encryptByPublicKey(String data, String publicKey) throws Exception {

		byte[] key = Base64.getDecoder().decode(publicKey);

		return Base64.getEncoder().encodeToString(encryptByPublicKey(data.getBytes("UTF-8"), key));

	}

	public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {

		// 实例化密钥工厂

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		// 生成公钥

		PublicKey key = keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));

		// 数据加密

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
		// 更新要计算的内容
		md5Digest.update(msg.getBytes());
		// 完成哈希计算，得到摘要
		byte[] md5Encoded = md5Digest.digest();
		return (new BASE64Encoder()).encodeBuffer(md5Encoded);
	}
}
