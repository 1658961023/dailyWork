
public class Control {
	Elevator elevator;
	public Control(){
		this.elevator = new Elevator();
	}
	
	public Control(Elevator elevator){
		this.elevator = elevator;
	}
	
	public void handleDrection(String instraction){
		switch(instraction){
		case "UP":
			elevator.setState("UP");
			break;
		case "DOWN":
			elevator.setState("DOWN");
			break;
		}
	}
	
	public double handle(String instraction){
		double t = 0.0;
		if (Integer.valueOf(instraction) == elevator.getCurrentFloor()){
			t += elevator.oppenDoor();
		} else {
			t += elevator.goToFloor(Integer.valueOf(instraction));
		}
		return t;
	}
	
}
