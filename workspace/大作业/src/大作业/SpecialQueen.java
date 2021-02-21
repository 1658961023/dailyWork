package ´ó×÷Òµ;

import java.util.LinkedList;

public class SpecialQueen {
	LinkedList<Customer> Young_up;
	LinkedList<Customer> Old_up;
	LinkedList<Customer> Young_down;
	LinkedList<Customer> Old_down;
	public SpecialQueen() {
		super();
		setYoung_up(new LinkedList<Customer>());
		setOld_up(new LinkedList<Customer>());
		setYoung_down(new LinkedList<Customer>());
		setOld_down(new LinkedList<Customer>());
	}

	
	public LinkedList<Customer> getOld_down() {
		return Old_down;
	}


	public void setOld_down(LinkedList<Customer> old_down) {
		Old_down = old_down;
	}


	public LinkedList<Customer> getYoung_up() {
		return Young_up;
	}
	public void setYoung_up(LinkedList<Customer> young_up) {
		Young_up = young_up;
	}
	public LinkedList<Customer> getOld_up() {
		return Old_up;
	}
	public void setOld_up(LinkedList<Customer> old_up) {
		Old_up = old_up;
	}
	public LinkedList<Customer> getYoung_down() {
		return Young_down;
	}
	public void setYoung_down(LinkedList<Customer> young_down) {
		Young_down = young_down;
	}
	
}
