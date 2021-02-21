package javanet.c06;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.net.util.Base64;

public class Homework6_1_2 {

	public static void main(String[] args) {
		String str = "���  ���磡Hello World!!";
		System.out.println("����ǰ : " + str);
		encryptAES(str);
	}

	public static void encryptAES(String s) {
		try {
			// ����KEY
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();
			// keyת��
			Key key = new SecretKeySpec(keyBytes, "AES");
			// ����
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(s.getBytes());
			System.out.println("���ܺ� : " + Base64.encodeBase64String(result));
			// ����
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println("���ܺ� : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
