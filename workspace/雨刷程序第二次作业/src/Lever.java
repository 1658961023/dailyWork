public abstract  class Lever {
	protected int maxlever = 0;
	protected int lever =1;
	public Lever()
	{
		lever = 1;
	}
	
	public Lever(int maxlever)
	{
		this.setMaxLever(maxlever);
	}
	
	public int getLever()
	{
		return lever;
	}
	public int getMaxLever(){
		return maxlever;
	}
	public void setMaxLever(int maxlever){
		this.maxlever=maxlever;
	}
public abstract int leverUp();
public abstract int leverDown();
}
