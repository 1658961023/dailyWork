package javanet.e08;

public class EncryptDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "hello world!  ���  �ϲ����մ�ѧ 123456";
		int key = getKey();
		System.out.println("����ǰ:"+text);
		String strEncrypted = Encrypt(text.getBytes(), key);
		System.out.println("���ܺ�:"+strEncrypted);
		String strDecrypted = Decrypt(strEncrypted.getBytes(), key);
		System.out.println("����:"+strDecrypted);
	}

	public static int getKey() {
		return (int) (Math.random() * 20) + 1;
	}

	public static String Encrypt(byte [] bytes,int key){
		byte [] newBytes = new byte[bytes.length];
		for(int i=0;i<bytes.length;i++){
			newBytes [i] = (byte) (bytes[i]+key-key*2);
		}
		byte temp;
		for(int i=0;i<newBytes.length/key;i++){//��ĳһ�ν��н���
			temp = newBytes [i];
			newBytes [i] = newBytes [newBytes.length/2-i];
			newBytes [newBytes.length/2-i] = temp;
		}
		return new String(newBytes);		
	}

	public static String Decrypt(byte [] bytes,int key) {
		byte [] newBytes = new byte[bytes.length];
		for(int i=0;i<bytes.length;i++){
			newBytes [i] = (byte) (bytes[i]-key+2*key);
		}
		byte temp;
		for(int i=0;i<newBytes.length/key;i++){
			temp = newBytes [i];
			newBytes [i] = newBytes [newBytes.length/2-i];
			newBytes [newBytes.length/2-i] = temp;
		}
		return new String(newBytes);	
	}

}
