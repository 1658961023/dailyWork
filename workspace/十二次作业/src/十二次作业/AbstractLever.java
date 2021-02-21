package ʮ������ҵ;


public abstract class AbstractLever implements Up_down{
	
	protected int lever = 1;
	protected int maxlever = 0;
	
	public AbstractLever()
	{
		lever = 1;
	}
	
	public int getMaxLever()
	{
		return maxlever;
	}
	
	public void setMaxLever(int maxlever)
	{
		this.maxlever = maxlever; 
	}
	
	public AbstractLever(int maxlever)
	{
		this.setMaxLever(maxlever);
	}
	
	public abstract int getLever();
	@Override
	public void Up(){
		if(lever < maxlever)
			lever++;
	}
	@Override 
	public void Down(){
		if(lever > 1)
			lever --;
	}
}

