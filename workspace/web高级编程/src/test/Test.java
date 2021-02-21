package test;

import java.io.*;
import java.util.Scanner;
import org.apache.commons.codec.digest.*;

public class Test {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
        System.out.print("�����˺ţ�");
        String account = scanner.nextLine();
        System.out.print("�������룺");
        String password = scanner.nextLine();
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("src/test/user.txt")));
        String inputAccount = bf.readLine();
        String inputPassword = bf.readLine();
        if (inputAccount.equals(account) && inputPassword.equals(sha256hex(password))){
            System.out.println("��¼�ɹ�");
        }else {
            System.out.println("��¼ʧ��");
        }
        bf.close();
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
