package µÚÒ»Ìâ;

import java.util.ArrayList;

public class Triangle extends GeometricObject implements Comparable{
private ArrayList<Double> threesides;
public Triangle(){
	
}
public Triangle(ArrayList<Double> threesides) {
	// TODO Auto-generated constructor stub
	this.threesides=threesides;
}
public void setThreeSides(ArrayList<Double> threesides){
	this.threesides=threesides;
}
public ArrayList<Double> getThreeSides(){
	return threesides;
}
public double getPeremeter(){
	return  threesides.get(0)+threesides.get(1)+threesides.get(2);
}
public double getArea(){
	double p=getPeremeter()/2;
	return Math.sqrt(p*(p-threesides.get(0))*(p-threesides.get(1))*(p-threesides.get(2)));
}
@Override
public String toString(){
	String str="";
	str=str+"The color is "+getColor()+"\nThe area is "+getArea()+"\nThe peremeter is "+getPeremeter();
	return str;
}
@Override
public boolean equals(Triangle triangle1) {
	// TODO Auto-generated method stub
	if(triangle1.getArea()==this.getArea())
		return true;
	return false;
}
}

