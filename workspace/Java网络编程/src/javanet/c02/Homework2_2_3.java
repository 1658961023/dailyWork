package javanet.c02;

public class Homework2_2_3 {
	private static int sum = 0;

	public static void main(String[] args) {
		Object lock = new Object();
		Thread t1 = new Thread(new Input(lock));
		Thread t2 = new Thread(new Sale(lock));
		t1.start();
		t2.start();
	}

	static class Input implements Runnable {
		private Object lock;

		public Input(Object lock) {
			this.lock = lock;
		}

		public void input() {
			synchronized (lock) {
				if (sum >= 10) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				while (sum < 10) {
					int inputNum = (int) (Math.random() * 50) + 50;
					sum += inputNum;
					System.out.println("����" + inputNum + " ʣ��" + sum);
				}
				lock.notify();
			}
		}

		@Override
		public void run() {
			while (true) {
				input();
			}
		}
	}

	static class Sale implements Runnable {
		private Object lock;

		public Sale(Object lock) {
			this.lock = lock;
		}

		public void sale() {
			synchronized (lock) {
				if (sum < 10) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				while (sum >= 10) {
					int saleNum = (int) (Math.random() * sum) + 1;
					sum -= saleNum;
					System.out.println("����" + saleNum + " ʣ��" + sum);
					try {
						long wait = (long) ((Math.random() * 2000)) + 1;
						System.out.println("�ȴ�"+wait+"ms");
						Thread.sleep(wait);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				lock.notify();
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				sale();
			}
		}
	}
}
