package ʮ������ҵ;


public abstract class AbstractAgent {
	
	protected AbstractLever l;
	protected AbstractDial d;
	protected AbstractBrush b;
	
	public AbstractAgent()
	{
	}
	
	public AbstractAgent(AbstractLever l,AbstractDial d,AbstractBrush b)
	{
		this.l = l;
		this.d = d;
		this.b = b;
	}
	
	public int getLever()
	{
		return l.getLever();
	}
	
	public int getDial()
	{
		return d.getDial();
	}
	
	public abstract void doSpeed();
	public abstract void show();	

}

