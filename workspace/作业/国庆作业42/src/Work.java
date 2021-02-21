public class Work {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 7; i++) {
			if (i < 2)
				sum += 4;
			else
				sum += 4 * 7 * Math.pow(8, i - 2);
		}
		System.out.println("0~7可以组成" + sum + "个奇数");
	}
}
