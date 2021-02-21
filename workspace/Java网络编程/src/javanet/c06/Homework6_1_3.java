package javanet.c06;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class Homework6_1_3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		KeyPair keyPair = getKeyPair();
		// ��Կ
		String publicKey = getPublicKey(keyPair);
		// ˽Կ
		String privateKey = getPrivateKey(keyPair);
		System.out.println("��Կ��\n" + publicKey);
		System.out.println("˽Կ��\n" + privateKey);
		String data = "���  ���磡Hello World!!";
		System.out.println("����ǰ��"+data);
		String s1 = encryptByPrivateKey(data, privateKey);
		System.out.println("���ܺ������:" + s1);
		String s2 = decryptByPublicKey(s1, publicKey);
		System.out.println("���ܺ������:" + s2 + "\n\n");

	}

	public static KeyPair getKeyPair() throws Exception {
		return getKeyPair(null);
	}

	public static KeyPair getKeyPair(String password) throws Exception { // ʵ������Կ������
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA"); // ��ʼ����Կ������
		if (password == null) {
			keyPairGenerator.initialize(512);
		} else {
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes("UTF-8"));
			keyPairGenerator.initialize(512, secureRandom);
		} // ������Կ��
		return keyPairGenerator.generateKeyPair();
	}

	public static byte[] getPrivateKeyBytes(KeyPair keyPair) {
		return keyPair.getPrivate().getEncoded();
	}

	public static String getPrivateKey(KeyPair keyPair) {
		return Base64.getEncoder().encodeToString(getPrivateKeyBytes(keyPair));
	}

	public static byte[] getPublicKeyBytes(KeyPair keyPair) {
		return keyPair.getPublic().getEncoded();
	}

	public static String getPublicKey(KeyPair keyPair) {
		return Base64.getEncoder().encodeToString(getPublicKeyBytes(keyPair));
	}


	public static byte[] encryptByPrivateKey(byte[] data, byte[] privateKey) throws Exception {

		// ʵ������Կ����

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		// ����˽Կ

		PrivateKey key = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKey));

		// ���ݼ���

		Cipher cipher = Cipher.getInstance("RSA");

		cipher.init(Cipher.ENCRYPT_MODE, key);

		return cipher.doFinal(data);

	}


	public static String encryptByPrivateKey(String data, String privateKey) throws Exception {

		byte[] key = Base64.getDecoder().decode(privateKey);

		return Base64.getEncoder().encodeToString(encryptByPrivateKey(data.getBytes("UTF-8"), key));

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



	public static String encryptByPublicKey(String data, String publicKey) throws Exception {

		byte[] key = Base64.getDecoder().decode(publicKey);

		return Base64.getEncoder().encodeToString(encryptByPublicKey(data.getBytes("UTF-8"), key));

	}

	public static byte[] decryptByPrivateKey(byte[] data, byte[] privateKey) throws Exception {

		// ʵ������Կ����

		KeyFactory keyFactory = KeyFactory.getInstance("UTF-8");

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

	public static byte[] decryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {

		// ʵ������Կ����

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		// ������Կ

		PublicKey key = keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));

		// ���ݽ���

		Cipher cipher = Cipher.getInstance("RSA");

		cipher.init(Cipher.DECRYPT_MODE, key);

		return cipher.doFinal(data);

	}

	public static String decryptByPublicKey(String data, String publicKey) throws Exception {

		byte[] key = Base64.getDecoder().decode(publicKey);

		return new String(decryptByPublicKey(Base64.getDecoder().decode(data), key), "UTF-8");

	}
}
