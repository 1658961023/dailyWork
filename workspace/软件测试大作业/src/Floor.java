
public class Floor {
	private boolean upButton;
	private boolean downButton;
	
	public Floor(){
		
			upButton = false;
			downButton = false;
	}
	
	public void setButtonOn(String direction){
		if (direction.equals("UP")){
			upButton = true;
		} else {
			downButton = true;
		}
	}
	
	public void setButtonOff(String direction){
		if (direction.equals("UP")){
			upButton = false;
		} else {
			downButton = false;
		}
	}
	
	public boolean getfloorButton(String direction){
		if (direction.equals("UP")){
			return upButton;
		} else {
			return downButton;
		}
	}
}
