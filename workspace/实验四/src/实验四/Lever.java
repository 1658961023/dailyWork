package สตั้หฤ;

public class Lever {
	private int position;
	public Lever(){
		
	}
	public Lever(int position){
		this.position=position;
	}
	public void setPosition(int position){
		this.position=position;
	}
	public int getPosition(){
		return position;
	}
	public void leverPosUp(){
		this.position++;
	}
	public void leverPosDown(){
		this.position--;
	}
}
