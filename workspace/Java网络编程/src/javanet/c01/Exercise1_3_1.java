package javanet.c01;

import java.io.*;
import java.util.*;

public class Exercise1_3_1 {
	public static void menu() {
		System.out.println("选择功能：");
		System.out.println("1.增加学生");
		System.out.println("2.删除学生");
		System.out.println("3.修改成绩");
		System.out.println("4.查询成绩");
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
			System.out.println("输入学号，姓名，成绩:");
			input.nextLine();
			String sno = input.nextLine();
			String name = input.nextLine();
			String score = input.nextLine();
			e.add(file, "学号:" + sno + "姓名:" + name + "成绩:" + score + "\n");
			System.out.println("添加成功！");
			break;
		case 2:
			System.out.println("输入学生学号:");
			input.nextLine();
			String sno2 = input.nextLine();
			e.delete(file, sno2);
			System.out.println("删除成功！");
			break;
		case 3:
			System.out.println("输入学生学号:");
			input.nextLine();
			String sno3 = input.nextLine();
			System.out.println("输入待修改的成绩:");
			String new_score = input.nextLine();
			e.update(file, sno3, new_score);
			System.out.println("修改成功！");
			break;
		case 4:
			System.out.println("输入学生学号:");
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
				String s2 = s.replaceAll(s.substring(s.indexOf("成绩:") + 3), score) + "\n";
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
				String score = s.substring(s.indexOf("成绩:") + 3);
				list.add("学号 " + sno + "成绩为:" + score);
			}
		}
		return list;
	}
}
