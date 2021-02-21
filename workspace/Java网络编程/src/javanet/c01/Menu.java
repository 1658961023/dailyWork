package javanet.c01;

import java.util.List;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("1----------------增加学生的成绩");
            System.out.println("2----------------查询所有学生的成绩");
            System.out.println("3----------------查询某学生的成绩");
            System.out.println("4----------------修改某学生的成绩");
            System.out.println("5----------------删除某学生的成绩");

            int select = input.nextInt();
            switch (select) {
                case 1:
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
                    FileHelper.add(grade);
                    break;
                case 2:
                    List<Grade> list = FileHelper.selectALL();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i).printInfo());
                    }
                    break;
                case 3:
                    System.out.print("请输入学号：");
                    String snoo = input.next();
                    if (snoo.length() == 8) {
                        Grade student = FileHelper.selectBySno(snoo);
                        if (student.getSno() == null) {
                            System.out.println("学生不存在");
                        } else {
                            System.out.println(student.printInfo());
                        }
                    } else {
                        System.out.println("请输入学号8位");
                    }
                    break;
                case 4:
                    System.out.print("请输入学号8位：");

                    String snofour = input.next();
                    System.out.print("请输入分数 ：");
                    int student = input.nextInt();
                    if (snofour.length() == 8 && (student <= 100 && student >= 0)) {
                        boolean flag = FileHelper.update(snofour, (byte) student);
                        if (flag == false) {
                            System.out.println("学生不存在");
                        }
                    } else {
                        System.out.println("请输入学号或成绩在0-100");
                    }
                    break;
                case 5:
                    System.out.print("请输入学号：");
                    String snofive = input.next();
                    if (snofive.length() == 8) {
                        FileHelper.delete(snofive);
                    } else {
                        System.out.println("请输入学号8位");
                    }
                    break;
            }

        }

    }

}
