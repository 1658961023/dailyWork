package javanet.e03;

public class CalAvg{
	public static void main(String[] args) throws InterruptedException {
		int grades[] = new int [1000];
		for(int i=0;i<grades.length;i++){
			grades[i]=(int)(Math.random()*100)+1;
		}
		MyThread t1 = new MyThread(grades,0,300);
		MyThread t2 =new MyThread(grades,301,600);
		MyThread t3 =new MyThread(grades,601,999);
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		System.out.println("平均分为："+(t1.getAvg()+t2.getAvg()+t3.getAvg())/3);
	}
	
	static class MyThread extends Thread{
		private int start;
		private int end;
		private float avg;
		private int[] grades;
		
		public MyThread(int[] grades,int start, int end) {
			this.start = start;
			this.end = end;
			this.grades = grades;
		}
		public void run() {
		int sum=0;
		for(int i=start;i<end;i++){
			sum+=grades[i];
		}
		avg = sum/grades.length;
		
	}
		public float getAvg() {
			return avg;
		}
	}
	
}
