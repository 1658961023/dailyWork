package �������ʵ��һ;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ��һ��_������ {
		public static void main(String[] args) {
			float a=0;
			float b=0;
			float c=0;
			Scanner input = new Scanner(System.in);
			System.out.println("���������߳��ȣ�([1,200]  �ո�ֿ�)");
			try {
				a=input.nextFloat();
				b=input.nextFloat();
				c=input.nextFloat();
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.out.println("�������ݷǷ���");
				System.exit(0);
			}
		if((a<1||a>200)||(b<1||b>200)||(c<1||c>200)){//���ж������Ƿ�Ϸ�
				System.out.println("�������ݷǷ���");
			}
			else if(((a+b)<=c)||((a+c)<=b)||((b+c)<=a)){//�ж��������Ƿ����
				System.out.println("�������Σ�");
			}
			else if(a==b&&b==c){//�жϵȱ�������
				System.out.println("�ȱ�������");
			}
			else if((a==b)||(a==c)||(b==c)){//�жϵ���������
				if(((a*a+b*b)==(c*c))||((a*a+c*c)==(b*b))||((b*b+c*c)==(a*a))){//�жϵ���ֱ��������
					System.out.println("����ֱ��������");
				}
				else{//�ǵ���ֱ�������εĵ���������
				System.out.println("����������");}
			}
			else if(((a*a+b*b)==(c*c))||((a*a+c*c)==(b*b))||((b*b+c*c)==(a*a))){//�ж�ֱ��������
				System.out.println("ֱ��������");
			}
			else{//������������Ϊһ��������
				System.out.println("һ��������");
			}
		}
}
