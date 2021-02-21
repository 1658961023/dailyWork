
public class NewControl extends Control{
	private NewElevator elevator;
	public NewControl(){
		this.elevator = new NewElevator();
	}
	
	public NewControl(NewElevator elevator){
		this.elevator = elevator;
	}
	
	public NewElevator getElevator(){
		return this.elevator;
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
	
	public double getExpectedTime(int n){
		double t = 0.0;
		t += elevator.getExpectedTime(n);
		return t;
	}
	
	public String Handle(int n){
			return elevator.moveElevate(n);
	}
	
}

