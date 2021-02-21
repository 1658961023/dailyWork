package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab4 {
	public static void main(String[] args) {
		System.out.println("输入一个待分析的输入串:");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		OPG opg = new OPG();
		if (opg.judgeOPG(opg.convertStringToList(s))) {
			System.out.println("接受");
		} else
			System.out.println("文法不可接受");
		input.close();
	}

	static class OPG {
		private List<String> VN = Arrays.asList(new String[] { "+", "*", "|", "i", "(", ")", "#" });
		private List<String> VT = Arrays.asList(new String[] { "A", "E", "T", "F", "P" });
		private String[][] OPGTABLE = { { ">", "<", "<", "<", "<", ">", ">" }, { ">", ">", "<", "<", "<", ">", ">" },
				{ ">", ">", "<", "<", "<", ">", ">" }, { ">", ">", ">", "", "", ">", ">" },
				{ "<", "<", "<", "<", "<", "=", "" }, { ">", ">", ">", "", "", ">", ">" },
				{ "<", "<", "<", "<", "<", "", "=" } };
		private List<String> STACK = new ArrayList<>();

		private boolean judgeOPG(List<String> input) {
			STACK.add("#");
			String current = input.get(0);
			input.remove(0);
			while (STACK.size() != 1 || input.size() >= 0) {
				if (VN.contains(STACK.get(STACK.size() - 1))) {
					if (OPGTABLE[VN.indexOf(STACK.get(STACK.size() - 1))][VN.indexOf(current)].equals("<")) {
						System.out.println(
								STACK.toString() + "  " + "<" + " " + current + "  " + input.toString() + "  " + "移进");
						String temp = current;
						current = input.get(0);
						input.remove(0);
						STACK.add(temp);
					} else if (OPGTABLE[VN.indexOf(STACK.get(STACK.size() - 1))][VN.indexOf(current)].equals(">")) {
						System.out.println(
								STACK.toString() + "  " + ">" + "  " + current + "  " + input.toString() + "  " + "归约");
						STACK.remove(STACK.size() - 1);
						STACK.add("N");
					} else
						return false;
				} else if (STACK.get(STACK.size() - 1).equals("N")) {
					if (OPGTABLE[VN.indexOf(STACK.get(STACK.size() - 2))][VN.indexOf(current)].equals("<")) {
						System.out.println(
								STACK.toString() + "  " + "<" + "  " + current + "  " + input.toString() + "  " + "移进");
						String temp = current;
						current = input.get(0);
						input.remove(0);
						STACK.add(temp);
					} else {
						System.out.println(
								STACK.toString() + "  " + ">" + "  " + current + "  " + input.toString() + "  " + "归约");
						while (!findFirst(STACK, current).equals(STACK.get(STACK.size() - 1))) {
							if (findFirst(STACK, current).equals(""))
								return false;
							else
								STACK.remove(STACK.size() - 1);
						}
						STACK.add("N");
						if (OPGTABLE[VN.indexOf(STACK.get(STACK.size() - 2))][VN.indexOf("#")].equals("=")) {
							System.out.println(STACK.toString() + "  " + "=" + "  " + current + "  " + input.toString()
									+ "  " + "接受");
							return true;
						}
					}
				}
			}
			if (STACK.get(STACK.size() - 1).equals("#"))
				return true;
			else
				return false;
		}

		public List<String> convertStringToList(String s) {
			List<String> list = new ArrayList<>();
			for (int i = 0; i < s.length(); i++) {
				list.add(s.charAt(i) + "");
			}
			return list;
		}

		public String findFirst(List<String> stack, String current) {
			for (int i = 0; i < stack.size(); i++) {
				if (OPGTABLE[VN.indexOf(STACK.get(i))][VN.indexOf(current)].equals(">")
						|| OPGTABLE[VN.indexOf(STACK.get(i))][VN.indexOf(current)].equals("=")) {
					return STACK.get(i);
				}
			}
			return "";
		}
	}
}
