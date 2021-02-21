
public class NewElevator extends Elevator implements ElvtMovement {
	private String[] requests = new String[10];
	private Floor[] floor = new Floor[10];
	
	public NewElevator(){
		this.currentFloor = 1;
		this.state = "UP";
		for (int i = 0; i < indexFloor.length; i ++){
			indexFloor[i] = false;
			floor[i] = new Floor();
		}
	}
	
	public Floor[] getFloor(){
		return this.floor;
	}
	
	public double oppenDoor(){
		return 1.0;
	}
	
	public double getExpectedTime(int n){
		if(n - this.currentFloor > 0){
			this.state = "UP";
		} else {
			this.state = "DOWN";
		}
		return Math.abs(n - this.currentFloor) * 0.5;
	}
	
	public String moveElevate(int n){
		if (n - this.currentFloor > 0){
			this.state = "UP";
			this.currentFloor ++;
			if (this.currentFloor == n)
				return "Arrived";
			if (floor[this.currentFloor - 1].getfloorButton("UP") || indexFloor[this.currentFloor - 1]){
				indexFloor[this.currentFloor - 1] = false;
				floor[this.currentFloor - 1].setButtonOff("UP");
				return "Bring";
			}
		} else if(n - this.currentFloor < 0){
			this.state = "DOWN";
			this.currentFloor --;
			if (this.currentFloor == n)
				return "Arrived";
			if (floor[this.currentFloor - 1].getfloorButton("DOWN") || indexFloor[this.currentFloor - 1]){
				indexFloor[this.currentFloor - 1] = false;
				floor[this.currentFloor - 1].setButtonOff("DOWN");
				return "Bring";
			}
		} else{
			this.state= "STILL";
			return "OppenDoor";
		}
		return "Pass";
		
	}
	
	public String getRequest(int n){
		return this.requests[n - 1];
	}
	
	public void setRequest(int n,String request){
		this.requests[n] = request;
	}
	
	public void setIndexFloor(int n,boolean state){
		indexFloor[n] = state;
	}
	
	public boolean getIndexFloor(int n){
		return indexFloor[n];
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
