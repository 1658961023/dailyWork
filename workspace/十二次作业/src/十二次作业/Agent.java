package ʮ������ҵ;


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
		case 1: slever = "ֹͣ";break;
		case 2: slever = "��Ъ";break;
		case 3: slever = "����";break;
		case 4: slever = "����";break;
		}
		
		System.out.println("���Ƹ˵ĵ�λΪ��" + slever );
		System.out.println("�̶��̵Ŀ̶�Ϊ��" + d.getDial());
		System.out.println("��ˢ���ٶ�Ϊ��" + b.getSpeed());
	}
}

