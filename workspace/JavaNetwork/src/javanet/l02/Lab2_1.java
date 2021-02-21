package javanet.l02;

import java.util.Scanner;

public class Lab2_1 {
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入线程数目:");
		int num = scanner.nextInt();
		for(int i = 0;i<num;i++){
			Thread t = new Thread(new MyThread(),"Thread"+(i+1));
			t.start();
			t.join();
		}
		scanner.close();
	}
	static class MyThread implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName()+"...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
