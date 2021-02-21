package javanet.e09;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CreateKey {

	public class Keys {

	}

	public static final String KEY_ALGORITHM = "RSA";
	private static final String PUBLIC_KEY = "RSAPublicKey";
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	// ��ù�Կ
	public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
		// ���map�еĹ�Կ���� תΪkey����
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return encryptBASE64(key.getEncoded());
	}

	// ���˽Կ
	public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
		// ���map�е�˽Կ���� תΪkey����
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return encryptBASE64(key.getEncoded());
	}

	// ���뷵��byte
	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	// ���뷵���ַ���
	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	// map�����д�Ź�˽Կ
	public static Map<String, Object> initKey() throws Exception {
		// ��ö��� KeyPairGenerator ���� RSA 1024���ֽ�
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(1024);
		// ͨ������ KeyPairGenerator ��ȡ����KeyPair
		KeyPair keyPair = keyPairGen.generateKeyPair();

		// ͨ������ KeyPair ��ȡRSA��˽Կ����RSAPublicKey RSAPrivateKey
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		// ��˽Կ�������map��
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}

	public static void main(String[] args) {
		Map<String, Object> keyMap;
		try {
			keyMap = initKey();
			String publicKey = getPublicKey(keyMap);
			System.out.println("���ɹ�Կ��\n"+publicKey);
			PrintWriter pw = new PrintWriter(new FileOutputStream("src/javanet/e09/key_rsa_pub.txt"));
			pw.write(publicKey);
			pw.close();
			String privateKey = getPrivateKey(keyMap);
			System.out.println("����˽Կ��\n"+privateKey);
			PrintWriter pw2 = new PrintWriter(new FileOutputStream("src/javanet/e09/key_rsa.txt"));
			pw2.write(privateKey);
			pw2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
