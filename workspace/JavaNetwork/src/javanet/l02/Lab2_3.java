package javanet.l02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("Test.txt");
		Thread t1 = new Thread(new CopyFiles(file,new File("a/")),"文件1");
		Thread t2 = new Thread(new CopyFiles(file,new File("b/")),"文件2");
		Thread t3 = new Thread(new CopyFiles(file,new File("c/")),"文件3");
		t1.start();
		t2.start();
		t3.start();
	}
	
	static class CopyFiles implements Runnable{
		private File file;
		private File dir;
		public  CopyFiles(File f,File d) {
			// TODO Auto-generated constructor stub
			this.file = f;
			this.dir = d;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			File copyfile = new File(dir.getName()+ "/" + file.getName());
			FileInputStream fis;
			FileOutputStream fos;
			try {
				fis = new FileInputStream(file);
				fos = new FileOutputStream(copyfile);
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = fis.read(b)) != -1) {
					fos.write(b, 0, len);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"复制完成...");
		}
	}

}
