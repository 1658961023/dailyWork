
public class NewDial extends Dial{
	public NewDial(){
		
	}
	public NewDial(int maxdial){
		super(maxdial);
	}
	public int dialUp()
	{
		if(dial < maxdial)
			dial++;
		return dial;
	}
	
	public int dialDown()
	{
		if(dial > 1)
			dial --;
		return dial;
	}

}
