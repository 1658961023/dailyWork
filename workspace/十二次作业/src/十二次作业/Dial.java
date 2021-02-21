package 十二次作业;


public class Dial extends AbstractDial implements Up_down{
	
	
	public Dial()
	{
		super();
	}
	
	public Dial(int lever)
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

