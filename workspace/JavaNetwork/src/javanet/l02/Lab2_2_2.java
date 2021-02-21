package javanet.l02;

public class Lab2_2_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyThread t1 = new MyThread(1,4);
		MyThread t2 = new MyThread(5,7);
		MyThread t3 = new MyThread(8,10);
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
	}

	static class MyThread extends Thread{
		private int start;
		private int end;
		public MyThread(int s,int e){
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
