package 十二次作业;


public class Agent extends AbstractAgent{

	
	public Agent()
	{
		super();
	}
	
	public Agent(AbstractLever l,AbstractDial d,AbstractBrush b)
	{
		super(l,d,b);
	}	
	
	public void doSpeed()
	{
		int speed = 0;
		switch(l.getLever())
		{
		case 1:speed = 0;break;
		case 2:
			switch(d.getDial())
			{
			case 1: speed = 4;break;
			case 2: speed = 6;break;
			case 3: speed = 12;break;
			}
			break;
		case 3: speed = 30;break;
		case 4: speed = 60;break;
		}
		b.setSpeed(speed);
	}
	
	public void show()
	{
		String slever = "";
		switch(l.getLever())
		{
		case 1: slever = "停止";break;
		case 2: slever = "间歇";break;
		case 3: slever = "低速";break;
		case 4: slever = "高速";break;
		}
		
		System.out.println("控制杆的档位为：" + slever );
		System.out.println("刻度盘的刻度为：" + d.getDial());
		System.out.println("雨刷的速度为：" + b.getSpeed());
	}
}

