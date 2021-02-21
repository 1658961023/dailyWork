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
		// 公钥
		String publicKey = getPublicKey(keyPair);
		// 私钥
		String privateKey = getPrivateKey(keyPair);
		System.out.println("公钥：\n" + publicKey);
		System.out.println("私钥：\n" + privateKey);
		String data = "你好  世界！Hello World!!";
		System.out.println("加密前："+data);
		String s1 = encryptByPrivateKey(data, privateKey);
		System.out.println("加密后的数据:" + s1);
		String s2 = decryptByPublicKey(s1, publicKey);
		System.out.println("解密后的数据:" + s2 + "\n\n");

	}

	public static KeyPair getKeyPair() throws Exception {
		return getKeyPair(null);
	}

	public static KeyPair getKeyPair(String password) throws Exception { // 实例化密钥生成器
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA"); // 初始化密钥生成器
		if (password == null) {
			keyPairGenerator.initialize(512);
		} else {
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes("UTF-8"));
			keyPairGenerator.initialize(512, secureRandom);
		} // 生成密钥对
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

		// 实例化密钥工厂

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		// 生成私钥

		PrivateKey key = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKey));

		// 数据加密

		Cipher cipher = Cipher.getInstance("RSA");

		cipher.init(Cipher.ENCRYPT_MODE, key);

		return cipher.doFinal(data);

	}


	public static String encryptByPrivateKey(String data, String privateKey) throws Exception {

		byte[] key = Base64.getDecoder().decode(privateKey);

		return Base64.getEncoder().encodeToString(encryptByPrivateKey(data.getBytes("UTF-8"), key));

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



	public static String encryptByPublicKey(String data, String publicKey) throws Exception {

		byte[] key = Base64.getDecoder().decode(publicKey);

		return Base64.getEncoder().encodeToString(encryptByPublicKey(data.getBytes("UTF-8"), key));

	}

	public static byte[] decryptByPrivateKey(byte[] data, byte[] privateKey) throws Exception {

		// 实例化密钥工厂

		KeyFactory keyFactory = KeyFactory.getInstance("UTF-8");

		// 生成私钥

		PrivateKey key = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKey));

		// 数据解密

		Cipher cipher = Cipher.getInstance("RSA");

		cipher.init(Cipher.DECRYPT_MODE, key);

		return cipher.doFinal(data);

	}

	

	public static String decryptByPrivateKey(String data, String privateKey) throws Exception {

		byte[] key = Base64.getDecoder().decode(privateKey);

		return new String(decryptByPrivateKey(Base64.getDecoder().decode(data), key), "UTF-8");

	}

	public static byte[] decryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {

		// 实例化密钥工厂

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		// 产生公钥

		PublicKey key = keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));

		// 数据解密

		Cipher cipher = Cipher.getInstance("RSA");

		cipher.init(Cipher.DECRYPT_MODE, key);

		return cipher.doFinal(data);

	}

	public static String decryptByPublicKey(String data, String publicKey) throws Exception {

		byte[] key = Base64.getDecoder().decode(publicKey);

		return new String(decryptByPublicKey(Base64.getDecoder().decode(data), key), "UTF-8");

	}
}
