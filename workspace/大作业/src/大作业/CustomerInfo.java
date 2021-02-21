package ´ó×÷Òµ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerInfo {
	public void writeInfo() throws IOException {
		File file = new File("d:/workspace/data.txt");
		PrintWriter output = new PrintWriter(file);
		for (int i = 0; i < 4; i++) {
			int ID = i + 1;
			int age = (int) (Math.random() * 70 + 10);
			int ComingTime = (int) (Math.random() * 100 + 1);
			int DF = (int) (Math.random() * 10 + 1);
			int SF = (int) (Math.random() * 10 + 1);
			Customer passages = new Customer(ID, age, ComingTime, DF, SF);
			output.print(passages.getID() + "\t");
			output.print(passages.getAge() + "\t");
			output.print(passages.getComingTime() + "\t");
			output.print(passages.getDF() + "\t");
			output.println(passages.getSF() + "\t");
		}
		output.close();
	}

	public LinkedList<Customer> readInfo() throws FileNotFoundException, IOException, ClassNotFoundException {
		Scanner input = new Scanner(new File("d:/workspace/data.txt"));
		LinkedList<Customer> p = new LinkedList<Customer>();
		while (input.hasNext()) {
			int ID = input.nextInt();
			int Age = input.nextInt();
			int ComingTime = input.nextInt();
			int DF = input.nextInt();
			int SF = input.nextInt();
			p.add(new Customer(ID, Age, ComingTime, DF, SF));
		}
		input.close();
		return p;
	}
}