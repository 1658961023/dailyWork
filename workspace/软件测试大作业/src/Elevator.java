
public class Elevator {
	protected int currentFloor;
	protected String state;
	protected boolean[] indexFloor = new boolean[10];
	public Elevator(){
		this.currentFloor = 1;
		this.state = "UP";
		for (int i = 0; i < indexFloor.length; i ++){
			indexFloor[i] = false;
		}
	}
	
	public double oppenDoor(){
		return 1.0;
	}
	
	public double goToFloor(int n){
		if (n > this.currentFloor){
			this.state = "UP";
		} else if (n < this.currentFloor){
			this.state = "DOWN";
		} else {
			this.state = "STILL";
		}
		double t = Math.abs(n - this.currentFloor) * 0.5;
		this.currentFloor = n;
		return t; 
	}
	
	public void setIndexFloor(int n,boolean state){
		indexFloor[n - 1] = state;
	}
	
	public boolean getIndexFloor(int n){
		return indexFloor[n - 1];
	}
	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return this.state;
	}
	
	public int getCurrentFloor(){
		return this.currentFloor;
	}
	
}
