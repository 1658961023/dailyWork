package javanet.c02;

public class Homework2_2_1 {
	private static int sum = 20;
	public static void main(String[] args) {
		Thread[] t = new Thread[100];
		Tickets ticket = new Tickets();
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(ticket);
			t[i].setName("«Ú√‘" + i);
			t[i].start();
		}

	}
	static class Tickets implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (this) {
				if (sum > 0) {
					System.out.println(Thread.currentThread().getName() + "«¿µΩ“ª’≈∆±");
					sum--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
}
}
