package javanet.l01;

import java.io.*;

public class CopyFiles implements FilenameFilter {
	public static void main(String[] args) {
		File dirA = new File("a");
		File dirB = new File("b");
		String[] a = dirA.list();
		for (int i = 0; i < a.length; i++) {
			CopyFiles cf = new CopyFiles();
			System.out.println(a[i].toString());
			System.out.println(cf.accept(dirB, a[i].toString()));
			if (!cf.accept(dirB, a[i].toString())) {
				try{
				File newfile = new File("b/" + a[i].toString());
				FileInputStream fis = new FileInputStream(dirA + "/" + a[i].toString());
				FileOutputStream fos = new FileOutputStream(newfile);
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = fis.read(b)) != -1) {
					fos.write(b, 0, len);
				}
				fos.flush();
				fos.close();
				fis.close();
			}
			catch(Exception exception){
				System.out.println("¸´ÖÆÎÄ¼þÊ§°Ü£¡");
			}
			}
		}
	}

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		String[] b = dir.list();
		for (int i = 0; i < b.length; i++) {
			if (name.equals(b[i].toString())) {
				return true;
			}
		}
		return false;
	}
}
