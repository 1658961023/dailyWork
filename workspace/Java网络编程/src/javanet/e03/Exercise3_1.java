package javanet.e03;

public class Exercise3_1 extends Thread{
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	public static void main(String[] args) {
		new Exercise3_1().start();
		while(true){
			synchronized (lock1) {
				synchronized (lock2) {
				System.out.println("main thread ...");	
				}
			}
		}
	}
	
	public void run(){
		while(true){
			synchronized (lock2) {
				synchronized (lock1) {
				System.out.println("child thread ...");	
				}
			}
		}
	}
}
