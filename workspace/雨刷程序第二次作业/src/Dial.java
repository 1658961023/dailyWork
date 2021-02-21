public abstract class Dial {
	protected int dial = 1;
	protected int maxdial=0;
	public Dial()
	{
		dial = 1;
	}
	
	public Dial(int maxdial)
	{
		this.setMaxDial(maxdial);
	}
	
	public int getDial()
	{
		return dial;
	}
	public int getMaxDial(){
		return maxdial;
	}
	public void setMaxDial(int maxdial){
		this.maxdial=maxdial;
	}	
	public abstract int dialUp();
	public abstract int dialDown();
}
