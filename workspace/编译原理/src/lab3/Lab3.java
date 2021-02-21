package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("输入一个待分析的字符串:");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		LL1 ll1 = new LL1();
		if (ll1.judgeLL1(ll1.convertStringToList(s))) {
			System.out.println("字符串可被LL1文法接受");
		} else {
			System.out.println("字符串不可被LL1文法接受");

		}
		input.close();
	}

	static class LL1 {
		private List<String> VN = Arrays.asList(new String[] { "i", "+", "*", "(", ")", "#" });
		private List<String> VT = Arrays.asList(new String[] { "E", "A", "T", "B", "F" });
		private List<String> GS = Arrays
				.asList(new String[] { "E:TA", "A:+TA", "A:e", "T:FB", "B:*FB", "B:e", "F:i", "F:(E)" });
		private String[][] LLTABLE = { { "TA", "", "", "TA", "", "" }, { "", "+TA", "", "", "e", "e" },
				{ "FB", "", "", "FB", "", "" }, { "", "e", "*FB", "", "e", "e" }, { "i", "", "", "(E)", "", "" } };
		private List<String> STACK = new ArrayList<>();

		public boolean judgeLL1(List<String> input) {
			STACK.add("#");
			STACK.add("E");
			String X = null;
			while (input.size() > 0 || STACK.size() != 1) {
				X = STACK.get(STACK.size() - 1);
				if (VT.contains(X)) {
					if (input.size() > 1) {
						if (findLLTable(X, input.get(0)) != "") {
							String temp = findLLTable(X, input.get(0));
							System.out.println(STACK.toString() + "  " + input.toString() + "  " + X + "->" + temp);
							STACK.remove(STACK.size() - 1);
							for (int i = temp.length(); i > 0; i--) {
								STACK.add(temp.charAt(i - 1) + "");
							}
						} else
							return false;
					} else {
						if (findLLTable(X, "#") != "") {
							String temp = findLLTable(X, "#");
							System.out.println(STACK.toString() + "  " + input.toString() + "  " + X + "->" + temp);
							STACK.remove(STACK.size() - 1);
							for (int i = temp.length(); i > 0; i--) {
								STACK.add(temp.charAt(i - 1) + "");
							}
						} else
							return false;
					}
				} else if (X.equals(input.get(0))) {
					String temp = input.get(0);

					if (temp.equals("#")) {
						System.out.println(STACK.toString() + "  " + input.toString() + "  " + "接受");
						return true;
					} else {
						STACK.remove(STACK.size() - 1);
						input.remove(0);
						System.out.println(STACK.toString() + "  " + input.toString() + "  " + temp + "匹配");
					}

				} else if (X.equals("e")) {
					STACK.remove(STACK.size() - 1);
				}
			}
			return false;
		}

		public String findLLTable(String vt, String vn) {
			return LLTABLE[VT.indexOf(vt)][VN.indexOf(vn)];
		}

		public List<String> convertStringToList(String s) {
			List<String> list = new ArrayList<>();
			for (int i = 0; i < s.length(); i++) {
				list.add(s.charAt(i) + "");
			}
			return list;
		}
	}
}
