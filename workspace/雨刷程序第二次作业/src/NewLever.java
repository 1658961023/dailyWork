
public class NewLever extends Lever {
	public NewLever(){
		
	}
public NewLever(int maxlever){
	super(maxlever);
}
	public int leverUp()
	{
		if(lever < maxlever)
			lever++;
		return lever;
	}
	
	public int leverDown()
	{
		if(lever > 1)
			lever --;
		return lever;
	}
}
