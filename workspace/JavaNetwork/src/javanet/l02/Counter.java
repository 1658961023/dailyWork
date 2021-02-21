package javanet.l02;

public class Counter {
    private int c = 30;
    public  void decrement() {
    	if(c>0)
    		c--;
    	System.out.println(Thread.currentThread()+"="+c);
    }
}

