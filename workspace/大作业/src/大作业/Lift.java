package 大作业;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Lift {
	final int MAX = 13;
	int floor;
	boolean UpOrDown;
	boolean isOpen;
	int peopleNum;
	boolean isFloor; // 是否到达楼层
	LinkedList<Customer> List_OnLift;
	public Lift(int floor, boolean upOrDown, int peopleNum, boolean isFloor) {
		super();
		this.floor = floor;
		UpOrDown = upOrDown;
		this.peopleNum = peopleNum;
		this.isOpen = false;
		this.isFloor = isFloor;
		List_OnLift = new LinkedList<Customer>();
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public boolean isUpOrDown() {
		return UpOrDown;
	}

	public void setUpOrDown(boolean upOrDown) {
		UpOrDown = upOrDown;
	}

	public int getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}

	public boolean isFloor() {
		return isFloor;
	}

	public void setFloor(boolean isFloor) {
		this.isFloor = isFloor;
	}

	public void sort() {
		Collections.sort(List_OnLift, new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {

				if (UpOrDown) {
					if (o1.DF > o2.DF) {
						return 1;
					} else if (o1.DF < o2.DF) {
						return -1;
					}
				} else {
					if (o1.DF < o2.DF) {
						return 1;
					} else if (o1.DF > o2.DF) {
						return -1;
					}
				}
				if (o1.Age < o2.Age) {
					return 1;
				} else if (o1.Age > o2.Age) {
					return -1;
				}
				return 0;
			}
		});

	}

}
