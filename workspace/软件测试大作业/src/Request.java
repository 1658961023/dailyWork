import java.util.ArrayList;

public class Request {
	protected ArrayList<String[]> arrayListFLR = new ArrayList<String[]>(); //�����ж�¥�������Ƿ����
	protected ArrayList<String[]> arrayListELR = new ArrayList<String[]>(); //�����жϵ��������Ƿ����
	protected double runTimeFR = 0.0,runTimeER = 0.0,FRTime = 0.0,ERTime = 0.0; //������������ֱ���¥�����������ʱ�䣬������������ʱ��
	Elevator elevator = new Elevator();
	Floor[] floor = new Floor[10]; //ʮ��¥
	Control control = new Control(elevator);
	
	//��ʼ��¥��
	public Request(){
		for(int i = 0; i < floor.length; i++){
			floor[i] = new Floor();
		}
	}
	
	//����¥������������
	public void isFloorRequestCompetition(){
		for (int i = 0; i < arrayListFLR.size(); i ++){
			if  ((FRTime - Double.valueOf(arrayListFLR.get(i)[0])) > Double.valueOf(arrayListFLR.get(i)[1])){
				floor[Integer.valueOf(arrayListFLR.get(i)[3]) - 1].setButtonOff(arrayListFLR.get(i)[2]);
				arrayListFLR.remove(i);
				i--; //����ɾ���󣬺����Ԫ�ػ�ǰ��һ�������� i--һ��
			}
		}
	}
	
	//���µ�������������
	public void isElevatorRequestCompetition(){
		for (int i = 0; i < arrayListELR.size(); i ++){
			if ((ERTime - Double.valueOf(arrayListELR.get(i)[0])) > Double.valueOf(arrayListELR.get(i)[1])){
				elevator.setIndexFloor(Integer.valueOf(arrayListELR.get(i)[2]), false);
				arrayListELR.remove(i);
				i--; //����ɾ���󣬺����Ԫ�ػ�ǰ��һ�������� i--һ��
			}
		}
	}
	
	//��������
	public double executeRequest(String[] request,double Time){
		switch(request[0]){
		case "FR":
			this.FRTime = Double.valueOf(request[3]); //������������ʱ��
			isFloorRequestCompetition(); //�ж�ִ���е������Ƿ����
			if (request[2].equals("UP")){ //�жϸ������Ƿ��ظ�
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
			sFR[0] = request[3]; //����ʱ��
			sFR[1] = String.valueOf(runTimeFR); //��������ʱ��
			sFR[2] = request[2]; //����
			sFR[3] = request[1]; //¥��
			arrayListFLR.add(sFR); //����������Ϣ���������������������������ʱ�����жϸ������Ƿ����
			break;
		case "ER":
			this.ERTime = Double.valueOf(request[2]);
			isElevatorRequestCompetition();
			if (elevator.getIndexFloor(Integer.valueOf(request[1]))){  //�жϸ������Ƿ��ظ�
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
			sER[0] = request[2]; //����ʱ��
			sER[1] = String.valueOf(runTimeER);
			sER[2] = request[1]; //¥��
			arrayListELR.add(sER);
			break;
		default:
			break;
		}
		return Time;
	}
}
