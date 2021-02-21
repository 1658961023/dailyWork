public class Work {
	public static void main(String[] args) {
		int[] a = new int[11];
		int next = 1;
		for (int i = 0; i <=10; i++) {
			for (int j = 0; j <= 10 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				int now = a[k];
				a[k] = next + now;
				next = now;
				System.out.print(a[k]+" ");
			}

			System.out.println();
		}
	}
}
