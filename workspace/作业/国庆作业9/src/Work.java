
public class Work {
	public static void main(String[] args) {
		double sum=0,height=100;
		for(int i=0;i<10;i++){
			sum+=height;
			height/=2;
			sum+=height;
	}
		System.out.println("��������"+sum+"��  ��ʮ�η���"+height+"��");
	}
}
