package ʮ������ҵ;


public class LeverNew extends AbstractLever implements Up_down{
	
	public LeverNew()
	{
		super();
	}
	
	public LeverNew(int maxlever)
	{
		super(maxlever);
	}
	
	public int getLever()
	{
		return lever;
	}
	@Override
	public void Up()
	{
		if(lever < maxlever)
			lever++;
	}
	@Override
	public void Down()
	{
		if(lever > 1)
			lever --;
	}
}

