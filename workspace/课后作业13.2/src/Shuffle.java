import java.util.ArrayList;

public class Shuffle {
	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<Number>();
		for (int i = 0; i < 10; i++) {
			list.add(i+1);
		}
		System.out.print("Before :"+list+"\nShuffle :");
		shuffle(list);
	}

	public static void shuffle(ArrayList<Number> list) {
		ArrayList<Number> newarray = new ArrayList<Number>();
		int sum=list.size();
		for (int i = 0; i < sum; i++) {
			int index = (int)( Math.random() * list.size());
				newarray.add(list.get(index));
				list.remove(index);
		}
		list.clear();
		System.out.print(newarray);
	}
}
