import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Cal_RightRate extends Cal_type_info {
	private TextField rate_tf;
	private double rate;

	public Cal_RightRate(TextArea tx1, TextArea tx2, TextField rateTF) {
		super(tx1, tx2);
		this.rate_tf = rateTF;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void getRightRate() {
		double rightCount = 0;
		Text[] right = new Text[super.tx1.getText().length()];
		Text[] wrong = new Text[super.tx1.getText().length()];
		int count = 0;
		int count2 = 0;
		for (int i = 0; i < tx2.getText().length(); i++) {
			if (Compare(tx1.getText().charAt(i), tx2.getText().charAt(i))) {
				rightCount++;
				right[count].setText("" + tx2.getText().charAt(i));
				count++;
				right[count].setFill(Color.GRAY);
			} else {
				wrong[count2].setText("" + tx2.getText().charAt(i));
				count2++;
				wrong[count2].setFill(Color.RED);
			}
			setRate((double) (rightCount / tx2.getText().length()) * 100);
			rate_tf.setText("" + getRate());
		}

	}

	public boolean Compare(char ch1, char ch2) {
		if (ch1 == ch2)
			return true;
		return false;
	}
}
