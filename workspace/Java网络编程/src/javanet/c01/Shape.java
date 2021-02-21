package javanet.c01;

import java.io.Serializable;

public abstract class Shape implements Serializable{
	public abstract double getArea();
	public void printInfo(){
		System.out.println(getClass().getSimpleName()+" has area: "+getArea());
	}
}
