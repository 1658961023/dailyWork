package javanet.c01;
	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.PrintStream;
	import java.io.RandomAccessFile;
	import java.util.ArrayList;
	import java.util.List;

	public class FileHelper{

		public static boolean update(String sno, byte students) {
			boolean flag = false;
			List<Grade> scores = new ArrayList<Grade>();
			try {
				RandomAccessFile raf = new RandomAccessFile(new File("src/score.data"), "rw");
				String line;
				while ((line = raf.readLine()) != null) {
					line = new String(line.getBytes("ISO-8859-1"), "gbk");

					int k = 0;
					for (int i = line.length() - 1; i >= line.length() - 4; i--) {
						if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {

							k = i;
						}
					}
					Grade grade = new Grade();
					grade.setGrade((byte) Integer.parseInt(line.substring(k)));
					grade.setName(line.substring(8, k));
					grade.setSno(line.substring(0, 8));
					scores.add(grade);

				}
				for (int i = 0; i < scores.size(); i++) {
					if (scores.get(i).getSno().contains(sno)) {
						System.out.println("Grade.get(i).getGrade(0)" + scores.get(i).getGrade());
						scores.get(i).setGrade(students);
						System.out.println("Grade.get(i).getGrade(1)" + scores.get(i).getGrade());
						flag = true;
					}
				}
				FileOutputStream fis = new FileOutputStream(new File("src/score.data"));
				PrintStream printStream = new PrintStream(fis, true);
				for (int j = 0; j < scores.size(); j++) {
					printStream.println(scores.get(j).getSno() + scores.get(j).getName() + scores.get(j).getGrade());
				}

				printStream.close();
				raf.close();

			} catch (Exception e) {
				System.out.println("更新成绩失败");
			}
			return flag;
		}

		public static void delete(String sno) {
			List<Grade> res = new ArrayList<Grade>();
			try {
				RandomAccessFile ra = new RandomAccessFile(new File("src/score.data"), "r");
				String line;
				while ((line = ra.readLine()) != null) {
					line = new String(line.getBytes("ISO-8859-1"), "gbk");

					int k = 0;
					for (int i = line.length() - 1; i >= line.length() - 4; i--) {
						if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {

							k = i;
						}
					}
					Grade grade = new Grade();
					grade.setGrade((byte) Integer.parseInt(line.substring(k)));
					grade.setName(line.substring(8, k));
					grade.setSno(line.substring(0, 8));
					res.add(grade);

				}
				int before = res.size();
				for (int j = 0; j < res.size(); j++) {
					if (res.get(j).getSno().contains(sno)) {
						res.remove(j);
					}
				}
				int after = res.size();
				FileOutputStream fis = new FileOutputStream(new File("src/score.data"));
				PrintStream printStream = new PrintStream(fis, true);
				for (int j = 0; j < res.size(); j++) {
					printStream.println(res.get(j).getSno() + res.get(j).getName() + res.get(j).getGrade());
				}
				printStream.close();
				fis.close();
				ra.close();
				if (before > after) {
					System.out.println(sno + "删除成功");
				} else {
					System.out.println(sno + "该学生不存在文件中");
				}
			} catch (Exception e) {
				System.out.println("删除失败");
			}
		}

		public static List<Grade> selectALL() {
			List<Grade> res = new ArrayList<Grade>();
			try {
				RandomAccessFile ra = new RandomAccessFile(new File("src/score.data"), "r");
				String line;
				while ((line = ra.readLine()) != null) {
					line = new String(line.getBytes("ISO-8859-1"), "gbk");
					int k = 0;
					for (int i = line.length() - 1; i >= line.length() - 4; i--) {
						if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
							k = i;
						}
					}
					Grade grade = new Grade();
					grade.setGrade((byte) Integer.parseInt(line.substring(k)));
					grade.setName(line.substring(8, k).trim());
					grade.setSno(line.substring(0, 8));
					res.add(grade);
				}
				ra.close();
			} catch (Exception e) {
				System.out.println("查询失败");
			}
			return res;
		}

		public static Grade selectBySno(String sno) {
			Grade grade = new Grade();
			try {
				RandomAccessFile ra = new RandomAccessFile(new File("src/score.data"), "r");
				String line;
				while ((line = ra.readLine()) != null) {
					if (line.contains(sno)) {
						line = new String(line.getBytes("ISO-8859-1"), "gbk");
						int k = 0;
						for (int i = line.length() - 1; i >= line.length() - 4; i--) {
							if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
								k = i;
							}
						}
						grade.setGrade((byte) Integer.parseInt(line.substring(k)));
						grade.setName(line.substring(8, k).trim());
						grade.setSno(line.substring(0, 8));
					}
				}
				ra.close();

			} catch (Exception e) {
				System.out.println("查询失败");
			}
			return grade;
		}

		public static void add(Grade grade) {

			List<Grade> list = selectALL();
			boolean flag = true;
			for (int k = 0; k < list.size(); k++) {
				if (list.get(k).getSno().contains(grade.getSno())) {
					flag = false;
					System.out.println("该学生成绩已经存在：" + list.get(k).printInfo());
					break;
				} else {
					flag = true;
				}
			}
			if (flag == true) {
				try {
					RandomAccessFile random = new RandomAccessFile(new File("src/score.data"), "rw");

					random.seek(random.length());
					System.out.println(random.length());
					random.write((grade.getSno()).getBytes());
					long i = random.length();
					random.write((grade.getName()).getBytes());
					random.seek(i + 19);
					random.write((grade.getGrade() + "\n").getBytes());
					System.out.println(random.length());
					random.close();
					System.out.println("添加成绩成功");
				} catch (Exception e) {
					System.out.println("添加成绩失败");
				}
			}
		}
	}
