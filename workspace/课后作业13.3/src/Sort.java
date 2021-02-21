import java.util.ArrayList;

public class Sort {
	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<Number>();
		for (int i = 0; i < 10; i++) {
			list.add((int) (Math.random() * 100));
		}
		System.out.print("Before:" + list + "\nSort:");
		sort(list);

	}

	public static void sort(ArrayList<Number> list) {
		ArrayList<Number> newarray = new ArrayList<Number>();
		int sum = list.size();
		for (int i = 0; i < sum; i++) {
			Number min = list.get(0);
			int minindex = 0;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).intValue() < min.intValue()) {
					min = list.get(j);
					minindex = j;
				}
			}
			newarray.add(min);
			list.remove(minindex);
		}
		System.out.print(newarray);
	}
}
