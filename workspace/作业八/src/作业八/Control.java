package ×÷Òµ°Ë;

public class Control {
	private int level;
	public Control(){
		
	}
	public void setLevel(int level){
		this.level=level;
	}
	public int getLevel(){
		return level;
	}
	public int upLevel(){
		return level++;
	}
	public int lowLevel(){
		return level--;
	}
}
