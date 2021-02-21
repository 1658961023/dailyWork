package javanet.c01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// delete();
		// add();
		// select();
		update();

	}

	public static void update() {
		try {
			RandomAccessFile raf = new RandomAccessFile(new File("src/score.data"), "rw");
			String line = null;
			long lastPoint = 0; // 记住上一次的偏移量
			while ((line = raf.readLine()) != null) {
				final long ponit = raf.getFilePointer();
				if (line.contains("16201201")) {
					// System.out.println(line);
					Grade grade = new Grade();
					int k = 0;
					for (int i = line.length() - 1; i >= line.length() - 4; i--) {
						if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
							// System.out.print(line.charAt(i));
							k = i;
						}
					}
					grade.setGrade((byte) (1));
					grade.setName(line.substring(8, k));
					grade.setSno(line.substring(0, 8));
					line = grade.getSno() + grade.getName() + grade.getGrade();
					System.out.println(line);
					raf.seek(lastPoint);

					break;
				}
				lastPoint = ponit;
			}
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void select() {
		List<Grade> res = new ArrayList<Grade>();
		try {
			RandomAccessFile ra = new RandomAccessFile(new File("src/score.data"), "r");
			String line;
			while ((line = ra.readLine()) != null) {
				line = new String(line.getBytes("ISO-8859-1"), "gbk");
				// System.out.println(line);
				int k = 0;
				for (int i = line.length() - 1; i >= line.length() - 4; i--) {
					if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
						// System.out.print(line.charAt(i));
						k = i;
					}
				}
				Grade grade = new Grade();
				grade.setGrade((byte) Integer.parseInt(line.substring(k)));
				grade.setName(line.substring(8, k).trim());
				grade.setSno(line.substring(0, 8));
				res.add(grade);
				System.out.println(line.substring(0, 8));
				System.out.println(line.substring(8, k).trim());
				System.out.println(Integer.parseInt(line.substring(k)));
			}
			ra.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int j = 0; j < res.size(); j++)
			// System.out.println(res.get(i).getSno()+res.get(i).getName()+res.get(i).getScore());
			System.out.println(res.get(j).printInfo());
	}

	public static void add() {
		Scanner input = new Scanner(System.in);

		Grade grade = new Grade();
		System.out.print("请输入学号：");
		String sno = input.next();
		if (sno.length() == 8)
			grade.setSno(sno);
		else {
			System.out.println("学号为8位");

		}
		System.out.print("请输入姓名：");
		String name = input.next();
		if (name.length() >= 1 && name.length() <= 20)
			grade.setName(name);
		else {
			System.out.print("超出字节");

		}
		System.out.print("请输入分数：");
		int s = input.nextInt();
		if (s <= 100 && s >= 0)
			grade.setGrade((byte) s);
		else {
			System.out.print("分数在1-100");

		}
		System.out.println(grade.getGrade());
		System.out.println(grade.getSno());
		System.out.println(grade.getName());
		input.close();
		try {
			RandomAccessFile random = new RandomAccessFile(new File("src/score.data"), "rw");
			try {
				random.seek(random.length());
				System.out.println(random.length());
				random.write((grade.getSno()).getBytes());
				long i = random.length();
				random.write((grade.getName()).getBytes());
				random.seek(i + 19);
				random.write((grade.getGrade() + "\n").getBytes());
				System.out.println(random.length());
				random.close();
			} catch (IOException e) {
				System.out.println("IOException");
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		}
	}

	public static void delete() {
		List<Grade> res = new ArrayList<Grade>();
		try {
			RandomAccessFile ra = new RandomAccessFile(new File("src/score.data"), "r");
			String line;
			while ((line = ra.readLine()) != null) {
				line = new String(line.getBytes("ISO-8859-1"), "gbk");
				// System.out.println(line);
				int k = 0;
				for (int i = line.length() - 1; i >= line.length() - 4; i--) {
					if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
						// System.out.print(line.charAt(i));
						k = i;
					}
				}
				Grade grade = new Grade();
				grade.setGrade((byte) Integer.parseInt(line.substring(k)));
				grade.setName(line.substring(8, k));
				grade.setSno(line.substring(0, 8));
				res.add(grade);

			}
			res.remove(2);

			FileOutputStream fis = new FileOutputStream(new File("src/score.data"));
			PrintStream printStream = new PrintStream(fis, true);
			for (int j = 0; j < res.size(); j++) {
				printStream.println(res.get(j).getSno() + res.get(j).getName() + res.get(j).getGrade());
			}

			printStream.close();
			fis.close();

			ra.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
