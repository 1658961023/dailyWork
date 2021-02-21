import java.util.ArrayList;

public class Request {
	protected ArrayList<String[]> arrayListFLR = new ArrayList<String[]>(); //用来判断楼层请求是否完成
	protected ArrayList<String[]> arrayListELR = new ArrayList<String[]>(); //用来判断电梯请求是否完成
	protected double runTimeFR = 0.0,runTimeER = 0.0,FRTime = 0.0,ERTime = 0.0; //最后两个变量分别是楼层最新请求的时间，电梯请求最新时间
	Elevator elevator = new Elevator();
	Floor[] floor = new Floor[10]; //十层楼
	Control control = new Control(elevator);
	
	//初始化楼层
	public Request(){
		for(int i = 0; i < floor.length; i++){
			floor[i] = new Floor();
		}
	}
	
	//更新楼层请求完成情况
	public void isFloorRequestCompetition(){
		for (int i = 0; i < arrayListFLR.size(); i ++){
			if  ((FRTime - Double.valueOf(arrayListFLR.get(i)[0])) > Double.valueOf(arrayListFLR.get(i)[1])){
				floor[Integer.valueOf(arrayListFLR.get(i)[3]) - 1].setButtonOff(arrayListFLR.get(i)[2]);
				arrayListFLR.remove(i);
				i--; //上面删除后，后面的元素会前移一个，所以 i--一次
			}
		}
	}
	
	//更新电梯请求完成情况
	public void isElevatorRequestCompetition(){
		for (int i = 0; i < arrayListELR.size(); i ++){
			if ((ERTime - Double.valueOf(arrayListELR.get(i)[0])) > Double.valueOf(arrayListELR.get(i)[1])){
				elevator.setIndexFloor(Integer.valueOf(arrayListELR.get(i)[2]), false);
				arrayListELR.remove(i);
				i--; //上面删除后，后面的元素会前移一个，所以 i--一次
			}
		}
	}
	
	//处理请求
	public double executeRequest(String[] request,double Time){
		switch(request[0]){
		case "FR":
			this.FRTime = Double.valueOf(request[3]); //更新请求最新时间
			isFloorRequestCompetition(); //判断执行中的请求是否完成
			if (request[2].equals("UP")){ //判断该请求是否重复
				if (floor[Integer.valueOf(request[1]) - 1].getfloorButton("UP"))
					return Time;
			} else {
				if (floor[Integer.valueOf(request[1]) - 1].getfloorButton("DOWN"))
					return Time;
			}
			floor[Integer.valueOf(request[1]) - 1].setButtonOn(request[2]);
			runTimeFR = control.handle(request[1]);
			if (Time < Double.valueOf(request[3])){
				Time = Double.valueOf(request[3]) + runTimeFR;
			} else {
				Time += runTimeFR;
			}
			String[] sFR = new String[4];
			sFR[0] = request[3]; //请求时间
			sFR[1] = String.valueOf(runTimeFR); //请求运行时间
			sFR[2] = request[2]; //方向
			sFR[3] = request[1]; //楼层
			arrayListFLR.add(sFR); //将该请求信息存入数组链表，后面根据请求最新时间来判断该请求是否完成
			break;
		case "ER":
			this.ERTime = Double.valueOf(request[2]);
			isElevatorRequestCompetition();
			if (elevator.getIndexFloor(Integer.valueOf(request[1]))){  //判断该请求是否重复
				return Time;
			}
			elevator.setIndexFloor(Integer.valueOf(request[1]), true);
			runTimeER = control.handle(request[1]);
			if (Time < Double.valueOf(request[2])){
				Time = Double.valueOf(request[2]) + runTimeER;
			} else {
				Time += runTimeER;
			}
			String[] sER = new String[3];
			sER[0] = request[2]; //请求时间
			sER[1] = String.valueOf(runTimeER);
			sER[2] = request[1]; //楼层
			arrayListELR.add(sER);
			break;
		default:
			break;
		}
		return Time;
	}
}
