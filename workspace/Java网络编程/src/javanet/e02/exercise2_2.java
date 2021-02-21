package javanet.e02;

public class exercise2_2 implements Runnable{
	private String name;
	 public exercise2_2(String name) {
		// TODO Auto-generated constructor stub
		 this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<11;i++){
			System.out.println(this.name+" Thread:"+i);
		}
	}
	public static void main(String[] args) {
		new Thread(new exercise2_2("T1")).start();
		new Thread(new exercise2_2("T2")).start();
		new Thread(new exercise2_2("T3")).start();
	}
}
