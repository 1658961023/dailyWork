package javanet.c02;

import java.util.Random;

public class Homework2_1_1 extends Thread{
	public Homework2_1_1(String name){
		super(name);
	}
	public static void main(String[] args) {
		new Homework2_1_1("硬币1").start();
		new Homework2_1_1("硬币2").start();
		new Homework2_1_1("硬币3").start();
	}
	public void run() {
		int front = 0;
		for (int i = 0; i < 20; i++) {
			Random random = new Random();
			if(random.nextInt(2) == 1){
				front++;
				System.out.println(this.getName()+" 正面  ");
			}
			else{
				System.out.println(this.getName()+" 反面  ");
			}
		}
		if(front>3){
			System.out.println(this.getName()+"投出3次以上正面");
		}
	}
}
