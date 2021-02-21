
public class NewAgent extends Agent{
	public NewAgent(){
		super();
	}
	public NewAgent(Lever lever,Dial dial,Brush brush){
		super(lever,dial,brush);
	}
	public void doSpeed()
	{
		int speed = 0;
		switch(getLever())
		{
		case 1:speed = 0;break;
		case 2:
			switch(getDial())
			{
			case 1: speed = 4;break;
			case 2: speed = 6;break;
			case 3: speed = 12;break;
			case 4: speed = 18;break;
			case 5: speed =24;break;
			}
			break;
		case 3: speed = 30;break;
		case 4: speed = 60;break;
		case 5: speed = 120;break;
		}
		brush.setSpeed(speed);
	}
	
	public void show()
	{
		String slever = "";
		switch(lever.getLever())
		{
		case 1: slever = "ֹͣ";break;
		case 2: slever = "��Ъ";break;
		case 3: slever = "����";break;
		case 4: slever = "����";break;
		case 5: slever = "������";break;
		}
		
		System.out.println("���Ƹ˵ĵ�λΪ��" + slever );
		System.out.println("�̶��̵Ŀ̶�Ϊ��" + dial.getDial());
		System.out.println("��ˢ���ٶ�Ϊ��" + brush.getSpeed());
	}

}
