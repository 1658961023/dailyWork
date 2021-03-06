package 十二次作业;

import java.util.Scanner;

public class Brush_test {
	public static void menu() {
		System.out.println("==================Please choose operation============");
		System.out.println("\t==========1:Lever Up===========");
		System.out.println("\t==========2:Lever Down=========");
		System.out.println("\t==========3:Dial Up============");
		System.out.println("\t==========4:Dial Down==========");
		System.out.println("\t==========0:Quit===============");
		System.out.println("=====================================================");
		System.out.println("Input the number(0~4):");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//第一种雨刷尝试
		//AbstractAgent agent = new Agent();
		//agent.l = new Lever(4);
		//agent.d = new Dial(3);
		//agent.b = new Brush();
		//第二种雨刷尝试
		AbstractAgent agent = new AgentNew();
		agent.l = new LeverNew(5);
		agent.d = new DialNew(4);
		agent.b = new Brush();
		Scanner input = new Scanner(System.in);
		int choice = 0;
			
		menu();
		try{ //很多同学问input为什么会报警告，其实input要进行close（）操作，参考这段代码，以后会讲
			while(true)
			{
				choice = input.nextInt();
				if(choice == 0)
					break;
				switch(choice)
				{
				case 1:
					if(agent.getLever() >= agent.l.getMaxLever())
					{
						System.out.println("控制杆已经处于高速档位，不能再升档！");
						menu();
						continue;
					}
					else
					{
						agent.l.Up();
					}
					break;
				case 2:
					if(agent.getLever() <= 1)
					{
						System.out.println("控制杆已经处于停止档位，不能再降档！");
						menu();
						continue;
					}
					else
					{
						agent.l.Down();
					}
					break;
				case 3:
					if(agent.getDial() >= agent.d.getMaxDial())
					{
						System.out.println("刻度盘已经处于最高刻度，不能再升档！");
						menu();
						continue;
					}
					else
					{
						agent.d.Up();
					}
					break;
				case 4:
					if(agent.getDial() <= 1)
					{
						System.out.println("刻度盘已经处于最低刻度，不能再降档！");
						menu();
						continue;
					}
					else
					{
						agent.d.Down();
					}
					break;
				default:
					System.out.println("请输入数字0~4");
					menu();
					continue;
				} //switch
				
				agent.doSpeed();
				agent.show();
				menu();
			}  //while
		
		}finally{
			input.close();
		}		
	}
}

