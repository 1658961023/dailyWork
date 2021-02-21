import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Cal_TypeSpeed extends Cal_type_info {
	private long startTime;
	private long endTime;
	private double speed;
	private TextField speed_tf;
	private boolean First;

	public Cal_TypeSpeed(TextArea tx1, TextArea tx2,TextField speed_tf, boolean first) {
		super(tx1, tx2);
		this.speed_tf = speed_tf;
		this.First = first;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public double getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getSpeed() {
		return speed;
	}

	public boolean isFirst() {
		return First;
	}

	public void setFirst(boolean first) {
		First = first;
	}

	public void getTypeSpeed() {
		if (tx2.getText().length()==1) {
			this.setFirst(true);
			this.setStartTime(System.currentTimeMillis());
		}
		this.setEndTime(System.currentTimeMillis());
		this.setSpeed(tx2.getText().length()/((this.getEndTime() - this.getStartTime()) / 1000)*60);
		this.speed_tf.setText(""+getSpeed());
	}
}
