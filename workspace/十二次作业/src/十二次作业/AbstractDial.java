package 十二次作业;


public abstract class AbstractDial implements Up_down{
	
	protected int dial = 1;
	protected int maxDial = 1;
	
	public AbstractDial()
	{
		dial = 1;
	}
	
	public AbstractDial(int maxDial)
	{
		setMaxDial(maxDial);
	}
	
	public int getMaxDial()
	{
		return maxDial;
	}
	
	public void setMaxDial(int maxDial)
	{
		this.maxDial = maxDial;
	}
	@Override 
	public void Up(){
		if(dial < maxDial)
			dial++;
	}
	@Override 
	public void Down(){

		if(dial > 1)
			dial --;
	}
	public abstract int getDial();	
}

