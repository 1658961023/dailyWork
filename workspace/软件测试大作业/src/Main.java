
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		double t2 = -1.0;
		String fileContent = "";
		String pathR = "./elevatorTest.txt";
		String pathW = "./elevatorResult.txt";
		String[] instractions;
		String[] TEMP;
		LinkQueue que = new LinkQueue();
		NewRequest request = new NewRequest();
		
		fileContent = FileIO.readFile(pathR);
		instractions = fileContent.split("\r\n");
		if (!instractions[instractions.length-1].equals("RUN")){
			FileIO.writeFile(pathW,"ERROR#未找到执行命令RUN");
			System.exit(0);
		}
		
		String st = instractions[0];
		if (!st.equals("(FR,1,UP,0)")){
			FileIO.writeFile(pathW,"ERROR#第一个请求必须为:(FR,1,UP,0)");
			System.exit(0);
		}
		
		for (int i = 0;i < instractions.length - 1; i++){
			instractions[i] = instractions[i].replaceAll("\\s+","");
			if (ValidateRequestion.isLegalRequestion(instractions[i]) != true){
				FileIO.writeFile(pathW, "INVALID["+instractions[i].replaceAll("\\(|\\)", "")+"]");
				continue;
			}
			instractions[i] = instractions[i].replaceAll("\\(|\\)", ""); //删除括号
			TEMP = instractions[i].split(",");
			if (Double.valueOf(TEMP[TEMP.length -1 ]) >= t2){
				que.add(instractions[i].split(","));
				t2 = Double.valueOf(TEMP[TEMP.length -1 ]);
			} else {
				FileIO.writeFile(pathW,"INVALID["+instractions[i]+"]");
			}
		}
		while (que.queueSize() != 0)
		request.executeRequest(que);
	}
}

