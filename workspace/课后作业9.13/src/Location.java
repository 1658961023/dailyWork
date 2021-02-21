public class Location {
	public int row,column;
	public double maxValue;
	public  Location(){
		
	}
	public Location(double maxValue,int row,int column){
		
	}
	public double getMaxValue(){
		return maxValue;
	}
	public int getRow(){
		return row;
	}
	public int getColumn(){
		return column;
	}
	static Location shuzu=new Location();
	public static Location locateLargest(double [][] a){
		int i,j,index_row=0,index_column=0;
		for(i=0;i<a.length;i++){
			for(j=0;j<a[i].length;j++){
				if(a[i][j]>shuzu.maxValue)
					{shuzu.maxValue=a[i][j];
					shuzu.row=i;
					shuzu.column=j;
					}
			}
		}
		return shuzu;
	}
}
