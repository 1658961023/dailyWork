package javanet.c01;

import java.io.*;
import java.util.*;

public class Exercise1_3_1 {
	public static void menu() {
		System.out.println("ѡ���ܣ�");
		System.out.println("1.����ѧ��");
		System.out.println("2.ɾ��ѧ��");
		System.out.println("3.�޸ĳɼ�");
		System.out.println("4.��ѯ�ɼ�");
	}

	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile("score.data", "rw");
		Scanner input = new Scanner(System.in);
		Exercise1_3_1 e = new Exercise1_3_1();
		int choice = 0;
		menu();
		choice = input.nextInt();
		switch (choice) {
		case 1:
			System.out.println("����ѧ�ţ��������ɼ�:");
			input.nextLine();
			String sno = input.nextLine();
			String name = input.nextLine();
			String score = input.nextLine();
			e.add(file, "ѧ��:" + sno + "����:" + name + "�ɼ�:" + score + "\n");
			System.out.println("��ӳɹ���");
			break;
		case 2:
			System.out.println("����ѧ��ѧ��:");
			input.nextLine();
			String sno2 = input.nextLine();
			e.delete(file, sno2);
			System.out.println("ɾ���ɹ���");
			break;
		case 3:
			System.out.println("����ѧ��ѧ��:");
			input.nextLine();
			String sno3 = input.nextLine();
			System.out.println("������޸ĵĳɼ�:");
			String new_score = input.nextLine();
			e.update(file, sno3, new_score);
			System.out.println("�޸ĳɹ���");
			break;
		case 4:
			System.out.println("����ѧ��ѧ��:");
			input.nextLine();
			String sno1 = input.nextLine();
			System.out.println(e.select(file, sno1));
			break;
		}
	}

	public void add(RandomAccessFile file, String student) throws IOException {
		file.seek(file.length());
		file.write(student.getBytes());
	}

	public void delete(RandomAccessFile file, String sno) throws IOException {
		String line = null;
		while ((line = file.readLine()) != null) {
			if (line.indexOf(sno) != -1) {
				String s = new String(line.getBytes("8859_1"), "gbk");
				long pointer = file.getFilePointer();
				file.seek(pointer - line.length());
				System.out.println(s);
				byte[] null_str = new byte[line.length()];
				String str = new String(null_str);
				file.write(str.getBytes());
			}
		}
	}

	public void update(RandomAccessFile file, String sno, String score) throws IOException {
		String line = null;
		while ((line = file.readLine()) != null) {
			if (line.indexOf(sno) != -1) {
				String s = new String(line.getBytes("8859_1"), "gbk");
				long pointer = file.getFilePointer();
				file.seek(pointer - line.length());
				System.out.println(s);
				String s2 = s.replaceAll(s.substring(s.indexOf("�ɼ�:") + 3), score) + "\n";
				System.out.println(s2);
				file.write(s2.getBytes());
			}
		}
	}

	public List<String> select(RandomAccessFile file, String sno) throws UnsupportedEncodingException, IOException {
		String line = null;
		List<String> list = new ArrayList<>();
		while ((line = file.readLine()) != null) {
			if (line.indexOf(sno) != -1) {
				String s = new String(line.getBytes("8859_1"), "gbk");
				System.out.println(s);
				String score = s.substring(s.indexOf("�ɼ�:") + 3);
				list.add("ѧ�� " + sno + "�ɼ�Ϊ:" + score);
			}
		}
		return list;
	}
}
