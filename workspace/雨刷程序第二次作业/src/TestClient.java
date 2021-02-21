import java.util.Scanner;

public class TestClient{
	public static void menu()
	{
		System.out.println("==================Please choose operation============");
		System.out.println("\t==========1:Lever Up===========");
		System.out.println("\t==========2:Lever Down=========");
		System.out.println("\t==========3:Dial Up============");
		System.out.println("\t==========4:Dial Down==========");
		System.out.println("\t==========0:Quit===============");
		System.out.println("=====================================================");
		System.out.println("Input the number(0~4):");
	}
	
	public static void main(String[] args)
	{
		Agent newagent = new NewAgent();
		newagent.lever=new NewLever(5);
		newagent.dial=new NewDial(5);
		newagent.brush=new Brush();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		menu();
		while(true)
		{
			choice = input.nextInt();
			if(choice == 0)
				break;
			switch(choice)
			{
			case 1:
				if(newagent.lever.getLever() >= newagent.lever.getMaxLever())
				{
					System.out.println("控制杆已经处于高速档位，不能再升档！");
					menu();
				}
				else
				{
					newagent.lever.leverUp();
				}
				break;
			case 2:
				if(newagent.lever.getLever() <= 1)
				{
					System.out.println("控制杆已经处于停止档位，不能再降档！");
					menu();
				}
				else
				{
					newagent.lever.leverDown();
				}
				break;
			case 3:
				if(newagent.getDial() >= newagent.dial.getMaxDial())
				{
					System.out.println("刻度盘已经处于最高刻度，不能再升档！");
					menu();
				}
				else
				{
					newagent.dial.dialUp();
				}
				break;
			case 4:
				if(newagent.getDial() <= 1)
				{
					System.out.println("刻度盘已经处于最低刻度，不能再降档！");
					menu();
				}
				else
				{
					newagent.dial.dialUp();
				}
				break;
			}
			newagent.doSpeed();
			newagent.show();
		}
		input.close();
	}
}
