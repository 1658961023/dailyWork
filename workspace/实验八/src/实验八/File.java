package ʵ���;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InterruptedIOException;

public class File {
private String fileName;
public File(){
	
}
public File(String name){
	this.fileName=name;
}

public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getString(String s) throws IOException {
	String text = "";
	String line = null;
	try {
		BufferedReader br = new BufferedReader(new FileReader(s));
		while ((line = br.readLine()) != null) {
			text += line;
			;
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("�ļ������ڣ�����");
	} catch (InterruptedIOException e2) {
		System.out.println("��Ч�����룡����");
	}
	return text;
}
}
