package javanet.l02;

public class Lab2_2 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyThread(1, 3));
		Thread t2 = new Thread(new MyThread(4, 7));
		Thread t3 = new Thread(new MyThread(8, 10));
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
	}

	static class MyThread implements Runnable {
		private int start;
		private int end;

		public MyThread(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			for (int i = start; i <= end; i++) {
				System.out.println(i);
			}
		}

	}
}
