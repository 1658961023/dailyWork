package ´ó×÷Òµ;

import java.io.Serializable;

public class Customer implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int ID;
	protected int ComingTime;
	protected int Age;
	protected int SF;
	protected int DF;
	protected int LeavingTime = 0;
	
	public Customer() {
		
	}
	public Customer(int iD, int comingTime, int age, int sourceFloor, int destinationFloor) {
		super();
		ID = iD;
		Age = age;
		ComingTime = comingTime;
		SF = sourceFloor;
		DF = destinationFloor;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	public int getComingTime() {
		return ComingTime;
	}
	public void setComingTime(int comingTime) {
		ComingTime = comingTime;
	}
	
	public int getSF() {
		return SF;
	}
	public void setSF(int sF) {
		SF = sF;
	}
	public int getDF() {
		return DF;
	}
	public void setDF(int dF) {
		DF = dF;
	}
	public int getLeavingTime() {
		return LeavingTime;
	}
	public void setLeavingTime(int leavingTime) {
		LeavingTime = leavingTime;
	}
	
}
