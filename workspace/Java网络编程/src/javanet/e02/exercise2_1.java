package javanet.e02;

public class exercise2_1 extends Thread {
	public exercise2_1(String name){
		super(name);
	}
	public static void main(String[] args) {
		new exercise2_1("t1").start();
		new exercise2_1("t2").start();
		new exercise2_1("t3").start();
	}
	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println(this.getName()+" Thread:"+i);
		}
	}
}
