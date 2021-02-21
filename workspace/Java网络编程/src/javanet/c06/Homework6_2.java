package javanet.c06;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Homework6_2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		KeyPair keyPair = getKeyPair();
		// 公钥
		String publicKey = getPublicKey(keyPair);
		// 私钥
		String privateKey = getPrivateKey(keyPair);
		PrintWriter pw = new PrintWriter(new FileOutputStream("src/javanet/c06/key_rsa_pub.txt"));
		pw.write(publicKey);
		pw.close();
		PrintWriter pw2 = new PrintWriter(new FileOutputStream("src/javanet/c06/key_rsa.txt"));
		pw2.write(privateKey);
		pw2.close();
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
}
