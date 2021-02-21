package javanet.c02;

public class Homework2_1_3 {
	private static int sum=1;
	public static void main(String[] args) {
		Thread t1 = new Thread(new Cal(1,3));
		Thread t2 = new Thread(new Cal(4,6));
		Thread t3 = new Thread(new Cal(7,10));
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("10! ÊÇ"+sum);
	}
	
	static class Cal implements Runnable{
		private int start;
		private int end;
		public Cal(int s,int e){
			this.start = s;
			this.end = e;
		}
		@Override
		public synchronized void run() {
			// TODO Auto-generated method stub
			for(int i=start;i<=end;i++){
				sum *= i;
			}
		}
		
	}
}
