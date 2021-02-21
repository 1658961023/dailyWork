package 十二次作业;


public class Lever extends AbstractLever implements Up_down{
	
	public Lever()
	{
		super();
	}
	
	public Lever(int maxlever)
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
