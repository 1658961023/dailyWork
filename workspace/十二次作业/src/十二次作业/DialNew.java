package 十二次作业;


public class DialNew extends AbstractDial implements Up_down{
	
	
	public DialNew()
	{
		super();
	}
	
	public DialNew(int lever)
	{
		super(lever);
	}
	
	public int getDial()
	{
		return dial;
	}
	@Override
	public void Up()
	{
		if(dial < maxDial)
			dial++;
	}
	@Override 
	public void Down()
	{
		if(dial > 1)
			dial --;
	}
}
