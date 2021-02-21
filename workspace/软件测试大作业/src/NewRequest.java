import java.io.IOException;
import java.util.ArrayList;

public class NewRequest extends Request{
	private double Time = 0.0,runTime = 0.0; //最后两个变量分别是楼层最新请求的时间，电梯请求最新时间
	NewElevator elevator = new NewElevator();
	NewControl control = new NewControl(elevator);
	ArrayList<String[]> a = new ArrayList<String[]>();
	String[] Mrequest;
	String pathW = "./elevatorResult.txt";
	
	
	//初始化楼层
	public NewRequest(){
		
	}
	
	public int getMax(int x,int y){
		if (x > y){
			return x;
		} else
			return y;
	}
	
	public int getMin(int x,int y){
		if (x < y){
			return x;
		} else
			return y;
	}
	
	public void getIncidentalRequest(LinkQueue que){
		for(int i = 0; i < que.queueSize(); i ++){
			switch(que.get(i)[0]){
			case "FR":
				if (elevator.getState().equals(que.get(i)[2]) 
					&& Integer.valueOf(que.get(i)[1]) < getMax(elevator.getCurrentFloor(),Integer.valueOf(Mrequest[1]))
					&& Integer.valueOf(que.get(i)[1]) > getMin(elevator.getCurrentFloor(),Integer.valueOf(Mrequest[1]))
					&&	Integer.valueOf(que.get(i)[3]) - Time < control.getExpectedTime(Integer.valueOf(que.get(i)[1]))){
					que.toHead(i);
					a.add(que.poll());
					i--;
				}
				break;
			case "ER":
				if ((elevator.getState().equals("UP") && Integer.valueOf(que.get(i)[1]) > elevator.getCurrentFloor() 
					|| elevator.getState().equals("DOWN") && Integer.valueOf(que.get(i)[1]) < elevator.getCurrentFloor())
					&& Integer.valueOf(que.get(i)[2]) - Time < control.getExpectedTime(Integer.valueOf(que.get(i)[1]))
					&& Integer.valueOf(que.get(i)[1]) != Integer.valueOf(Mrequest[1])){
					que.toHead(i);
					a.add(que.poll());
					i--;
				}
				break;
			}
		}
	}

	//处理请求
	public void executeRequest(LinkQueue que) throws NumberFormatException, IOException{
		Mrequest = que.poll();
		
		switch(Mrequest[0]){
		case "FR":
			this.FRTime = Integer.valueOf(Mrequest[3]); //更新请求最新时间
			isFloorRequestCompetition(); //判断执行中的请求是否完成
			//判断该请求是否重复
			if (control.getElevator().getFloor()[Integer.valueOf(Mrequest[1]) - 1].getfloorButton(Mrequest[2])){
				FileIO.writeFile(pathW,"SAME[" +Mrequest[0]+","+Mrequest[1]+","+Mrequest[2]+","+Mrequest[3]+"]"); //输出重复请求
				return ;
			}
				
			control.getElevator().getFloor()[Integer.valueOf(Mrequest[1]) - 1].setButtonOn(Mrequest[2]); //设置目标楼层按钮
			elevator.setRequest(Integer.valueOf(Mrequest[1]) - 1,Mrequest[0] +","+Mrequest[1] + ","+Mrequest[2] + ","+Mrequest[3]);
			runTime = control.getExpectedTime(Integer.valueOf(Mrequest[1]));
			getIncidentalRequest(que);
			
			if (a.size() != 0){
				handleIncidentalRequest();
				getResult(Integer.valueOf(Mrequest[1]),que);
			} else 
			{
				Time = (Time > Integer.valueOf(Mrequest[3])) ? Time : Integer.valueOf(Mrequest[3]);
				getResult(Integer.valueOf(Mrequest[1]),que);
			}
			saveExecutedFR(Mrequest);
			break;
		case "ER":
			this.ERTime = Integer.valueOf(Mrequest[2]);
			isElevatorRequestCompetition();
			if (elevator.getIndexFloor(Integer.valueOf(Mrequest[1]) - 1)){  //判断该请求是否重复
				FileIO.writeFile(pathW,"SAME[" +Mrequest[0]+","+Mrequest[1]+","+Mrequest[2]+"]");
				return ;
			}
			elevator.setIndexFloor(Integer.valueOf(Mrequest[1]) - 1, true);
			elevator.setRequest(Integer.valueOf(Mrequest[1]) - 1,Mrequest[0] +","+Mrequest[1] + ","+Mrequest[2]);
			runTime = control.getExpectedTime(Integer.valueOf(Mrequest[1]));
			getIncidentalRequest(que);
			
			if (a.size() != 0){
				handleIncidentalRequest();
				getResult(Integer.valueOf(Mrequest[1]),que);
			} else 
			{
				Time = (Time > Integer.valueOf(Mrequest[2])) ? Time : Integer.valueOf(Mrequest[2]);
				getResult(Integer.valueOf(Mrequest[1]),que);
			}
			saveExecutedER(Mrequest);
		default:
			break;
		}
		return ;
	}
	
	public void getResult(int n,LinkQueue que) throws IOException{
		if (elevator.getCurrentFloor() == n){ //处理电梯在当前楼层直接开关门
			control.Handle(n);
			Time += 1.0;
			//System.out.println("("+elevator.getCurrentFloor()+","+elevator.getState()+ "," + Time+")");
			FileIO.writeFile(pathW,"["+elevator.getRequest(elevator.getCurrentFloor())+"]/("+elevator.getCurrentFloor()+","+elevator.getState()+ "," + Time+")");
			return;
		}
		while (elevator.getCurrentFloor() != n){
			switch(control.Handle(n)){
			case "Bring":
				Time += 0.5;
				//System.out.println("("+elevator.getCurrentFloor()+","+elevator.getState()+ "," + Time+")");
				FileIO.writeFile(pathW,"["+elevator.getRequest(elevator.getCurrentFloor())+"]/("+elevator.getCurrentFloor()+","+elevator.getState()+ "," + Time+")");
				runTime += 1.0; //捎带了一个请求，执行时间增加一秒
				Time += 1.0;//开关门一秒
				getIncidentalRequest(que);
				handleIncidentalRequest();
				break;
			case "Pass":
				Time += 0.5;
				break;
			case "Arrived":
				Time += 0.5;
				//System.out.println("("+elevator.getCurrentFloor()+","+elevator.getState()+ "," + Time+")");
				FileIO.writeFile(pathW,"["+elevator.getRequest(elevator.getCurrentFloor())+"]/("+elevator.getCurrentFloor()+","+elevator.getState()+ "," + Time+")");
				Time += 1.0;//开关门一秒
				break;
			case "OppenDoor":
				Time += 1.0;
				//System.out.println("("+elevator.getCurrentFloor()+","+elevator.getState()+ "," + Time+")");
				FileIO.writeFile(pathW,"["+elevator.getRequest(elevator.getCurrentFloor())+"]/("+elevator.getCurrentFloor()+","+elevator.getState()+ "," + Time+")");
				break;
			}
			
		}
	}
	
	public void saveExecutedFR(String[] Mrequest){
		String[] sFR = new String[4];
		sFR[0] = Mrequest[3]; //请求时间
		sFR[1] = String.valueOf(runTime); //请求运行时间
		sFR[2] = Mrequest[2]; //方向
		sFR[3] = Mrequest[1]; //楼层
		arrayListFLR.add(sFR); //将该请求信息存入数组链表，后面根据请求最新时间来判断该请求是否完成
	}
	
	public void saveExecutedER(String[] Mrequest){
		String[] sER = new String[3];
		sER[0] = Mrequest[2]; //请求时间
		sER[1] = String.valueOf(runTime);
		sER[2] = Mrequest[1]; //楼层
		arrayListELR.add(sER);
	}
	
	public void handleIncidentalRequest() throws IOException{
		for (int i = 0; i < a.size(); i++){
			switch(a.get(i)[0]){
			case "FR":
				if (control.getElevator().getFloor()[Integer.valueOf(a.get(i)[1]) - 1].getfloorButton(a.get(i)[2])){
					FileIO.writeFile(pathW,"SAME[" + a.get(i)[0] +","+a.get(i)[1] + ","+a.get(i)[2]+ ","+a.get(i)[3]+"]");
				} else{
					control.getElevator().getFloor()[Integer.valueOf(a.get(i)[1]) - 1].setButtonOn(a.get(i)[2]);
					elevator.setRequest(Integer.valueOf(a.get(i)[1]) - 1,a.get(i)[0] +","+a.get(i)[1] + ","+a.get(i)[2] + ","+a.get(i)[3]);
				}
				a.remove(i);
				i--;
				break;
			case "ER":
				if(Integer.valueOf(a.get(i)[1]) > Integer.valueOf(Mrequest[1]) && elevator.getState().equals("UP")
					|| Integer.valueOf(a.get(i)[1]) < Integer.valueOf(Mrequest[1]) && elevator.getState().equals("DOWN"))
					Mrequest[1] = a.get(i)[1];
				if (control.getElevator().getIndexFloor(Integer.valueOf(a.get(i)[1]) - 1)){
					FileIO.writeFile(pathW,"SAME[" + a.get(i)[0] +","+a.get(i)[1] + ","+a.get(i)[2]+"]");
				} else{
					control.getElevator().setIndexFloor(Integer.valueOf(a.get(i)[1]) - 1, true);
					elevator.setRequest(Integer.valueOf(a.get(i)[1]) - 1,a.get(i)[0] +","+a.get(i)[1] + ","+a.get(i)[2]);
				}
				a.remove(i);
				i--;
				break;
			}
		}
	}
}
