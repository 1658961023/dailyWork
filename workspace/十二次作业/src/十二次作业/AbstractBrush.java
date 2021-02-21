package 十二次作业;


public abstract class AbstractBrush {
	
	protected int speed = 0;
	
	public AbstractBrush(int speed)
	{
		this.speed = speed;
	}
	
	public AbstractBrush()
	{
		this.speed = 0;
	}
	
	public abstract int getSpeed();
	
	public abstract void setSpeed(int speed);	

}

