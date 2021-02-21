package javanet.c01;

import java.util.List;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("1----------------����ѧ���ĳɼ�");
            System.out.println("2----------------��ѯ����ѧ���ĳɼ�");
            System.out.println("3----------------��ѯĳѧ���ĳɼ�");
            System.out.println("4----------------�޸�ĳѧ���ĳɼ�");
            System.out.println("5----------------ɾ��ĳѧ���ĳɼ�");

            int select = input.nextInt();
            switch (select) {
                case 1:
                    Grade grade = new Grade();
                    System.out.print("������ѧ�ţ�");
                    String sno = input.next();
                    if (sno.length() == 8)
                        grade.setSno(sno);
                    else {
                        System.out.println("ѧ��Ϊ8λ");

                    }
                    System.out.print("������������");
                    String name = input.next();
                    if (name.length() >= 1 && name.length() <= 20)
                        grade.setName(name);
                    else {
                        System.out.print("�����ֽ�");

                    }
                    System.out.print("�����������");
                    int s = input.nextInt();
                    if (s <= 100 && s >= 0)
                        grade.setGrade((byte) s);
                    else {
                        System.out.print("������1-100");

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
                    System.out.print("������ѧ�ţ�");
                    String snoo = input.next();
                    if (snoo.length() == 8) {
                        Grade student = FileHelper.selectBySno(snoo);
                        if (student.getSno() == null) {
                            System.out.println("ѧ��������");
                        } else {
                            System.out.println(student.printInfo());
                        }
                    } else {
                        System.out.println("������ѧ��8λ");
                    }
                    break;
                case 4:
                    System.out.print("������ѧ��8λ��");

                    String snofour = input.next();
                    System.out.print("��������� ��");
                    int student = input.nextInt();
                    if (snofour.length() == 8 && (student <= 100 && student >= 0)) {
                        boolean flag = FileHelper.update(snofour, (byte) student);
                        if (flag == false) {
                            System.out.println("ѧ��������");
                        }
                    } else {
                        System.out.println("������ѧ�Ż�ɼ���0-100");
                    }
                    break;
                case 5:
                    System.out.print("������ѧ�ţ�");
                    String snofive = input.next();
                    if (snofive.length() == 8) {
                        FileHelper.delete(snofive);
                    } else {
                        System.out.println("������ѧ��8λ");
                    }
                    break;
            }

        }

    }

}
