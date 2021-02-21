package lab2;

import java.util.*;

public class Lab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("输入一个待识别的字符串:");
		String str = input.nextLine();
		DFA d = new DFA();
		if (d.judgeString(str))
			System.out.println("字符串可被DFA接受");
		else
			System.out.println("字符串不可被DFA接受");
		input.close();
	}

	static class DFA {
		private List<String> K = Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6", "7" });
		private List<String> Σ = Arrays.asList(new String[] { "a", "b", "c", "d" });
		private String[][] f = { { "3", "2", "", "" }, { "4", "2", "", "" }, { "", "6", "3", "5" },
				{ "", "7", "3", "5" }, { "4", "", "", "" }, { "", "6", "", "" }, { "", "6", "", "" } };
		private List<String> S = Arrays.asList(new String[] { "1" });
		private List<String> Z = Arrays.asList(new String[] { "6", "7" });

		public boolean judgeString(String str) {
			int index = 0;
			String status = S.get(0);
			while (true) {
				if (index == str.length())
					return false;
				if (Σ.contains(str.charAt(index) + "")) {
					if (K.contains(status)) {
						status = f[K.indexOf(status)][Σ.indexOf(str.charAt(index) + "")];
					}
					if (Z.contains(status))
						return true;
					index++;
				} else
					return false;
			}
		}
	}
}
