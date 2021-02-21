package javanet.c02;

import java.util.Random;

public class Homework2_1_2 implements Runnable {
	private static float sum=0;
	private static float front=0;


	public static void main(String[] args) throws InterruptedException {
		Homework2_1_2 coin = new Homework2_1_2();
		Thread coin1 = new Thread(coin,"硬币1");
		Thread coin2 = new Thread(coin,"硬币2");
		Thread coin3 = new Thread(coin,"硬币3");
		coin1.start();
		coin2.start();
		coin3.start();
		coin1.join();
		coin2.join();
		coin3.join();
		System.out.println("出现正面的概率是" + front/sum);
	}

	public synchronized void run() {
			int num = (int) (Math.random() * 9) + 1;
			System.out.println(num);
			for (int i = 0; i < num; i++) {
				sum++;
				Random random = new Random();
				if (random.nextInt(2) == 1) {
					front++;
					System.out.println(Thread.currentThread().getName()+ " 正面  ");

				} else {
					System.out.println(Thread.currentThread().getName()+ " 反面  ");
				}
			}
		}
}
