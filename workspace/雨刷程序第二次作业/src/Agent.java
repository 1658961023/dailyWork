public abstract class Agent {
	protected Lever lever;
	protected Dial dial;
	protected Brush brush;
	
	public Agent()
	{
	}
	public Agent(Lever lever,Dial dial,Brush brush){
		this.lever=lever;
		this.dial=dial;
		this.brush=brush;
	}
	
	public int getLever()
	{
		return lever.getLever();
	}
	
	public int getDial()
	{
		return dial.getDial();
	}
	public abstract void doSpeed();
	public abstract void show();
	}
