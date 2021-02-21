public class Work {
	public static void main(String[] args) {
		int num = (int) (Math.random() * 99999 + 1);
		System.out.println(num);
		int figures = 0;
		for (int i = 1; i < 6; i++) {
			if ((num / (Math.pow(10, i)) >= 1 && (num / Math.pow(10, i)) < 10)) {
				figures = i + 1;
			}
		}
		System.out.println(num + " is " + figures + " figures");
		for (int j = 1; j < figures + 1; j++) {
			System.out.print((int) ((num % (Math.pow(10, j))) / Math.pow(10, j) * 10) + " ");
		}
	}
}
