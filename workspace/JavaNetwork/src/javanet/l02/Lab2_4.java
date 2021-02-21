package javanet.l02;

public class Lab2_4 {
	public static void main(String[] args) {
		Counter c = new Counter();
		for(int i = 0;i<300;i++){
			new Thread(new CounterThread(c),"Ïß³Ì"+i).start();
		}
	}
	static class CounterThread implements Runnable{
		private Counter c;
		public CounterThread(Counter c) {
			this.c = c;
		}
		public void run() {
			// TODO Auto-generated method stub
			synchronized (c) {
				c.decrement();
			}
		}
		
	}
}
