package µÚ¶şÌâ;

import java.util.ArrayList;
import java.util.Collections;

public class PointTest {
	public static void main(String[] args) {
		ArrayList<PointSorter> arrays=new ArrayList<PointSorter>();
		for(int i=0;i<10;i++){
			int x=(int)(Math.random()*10+1);
			int y=(int)(Math.random()*10+1);
			arrays.add(new PointSorter(x,y));
		}
		Collections.sort(arrays);
		for(PointSorter pointsorter:arrays){
			System.out.println(pointsorter.toString());
		}
	}
}
