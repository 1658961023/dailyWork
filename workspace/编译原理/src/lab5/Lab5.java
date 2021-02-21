package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/***
 * ����ԭ��ʵ��5
 * 
 * @author msmw
 *
 */
public class Lab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���봮abab#��������");
		Scanner input = new Scanner(System.in);
		LR1 lr1 = new LR1();
		if (lr1.judgeLR1(lr1.convertStringToList("abab#"))) {
			System.out.println("����");
		} else {
			System.out.println("������");
		}
	}

	/***
	 * LR1�ķ���
	 * 
	 * @author msmw
	 *
	 */
	static class LR1 {
		private List<String> VN = Arrays.asList(new String[] { "a", "b", "#" });
		private List<String> VT = Arrays.asList(new String[] { "S", "B" });
		private List<String> GS = Arrays.asList(new String[] { "S':S", "S:BB", "B:aB", "B:b" });
		private String[][] ACTION = { { "S:3", "S:4", "" }, { "", "", "acc" }, { "S:6", "S:7", "" },
				{ "S:3", "S:4", "" }, { "r:3", "r:3", "" }, { "", "", "r:1" }, { "S:6", "S:7", "" }, { "", "", "r:3" },
				{ "r:2", "r:2", "" }, { "", "", "r:2" } };
		private String[][] GOTO = { { "1", "2" }, { "", "" }, { "", "5" }, { "", "8" }, { "", "" }, { "", "" },
				{ "", "9" }, { "", "" }, { "", "" }, { "", "" } };
		private List<String> statusSTACK = new ArrayList<>();
		private List<String> characterSTACK = new ArrayList<>();

		/***
		 * �﷨��������
		 * 
		 * @param input
		 * @return
		 */
		private boolean judgeLR1(List<String> input) {
			System.out.printf("%30s%30s%30s%15s%5s\n", "״̬ջ ", "����ջ", "���봮", "ACTION", "GOTO");
			statusSTACK.add("0");
			characterSTACK.add("#");
			String a = input.get(0);
			while (true) {
				if (ACTION[Integer.parseInt(statusSTACK.get(statusSTACK.size() - 1))][VN.indexOf(a)].split(":")[0]
						.equals("S")) {
					System.out.printf("%15s%15s%15s%10s%10s\n", statusSTACK.toString(), characterSTACK.toString(),
							input.toString(),
							"S" + ACTION[Integer.parseInt(statusSTACK.get(statusSTACK.size() - 1))][VN.indexOf(a)]
									.split(":")[1],
							"");
					statusSTACK.add(ACTION[Integer.parseInt(statusSTACK.get(statusSTACK.size() - 1))][VN.indexOf(a)]
							.split(":")[1]);
					characterSTACK.add(a);
					input.remove(0);
					a = input.get(0);
				} else {
					if (ACTION[Integer.parseInt(statusSTACK.get(statusSTACK.size() - 1))][VN.indexOf(a)].split(":")[0]
							.equals("r")) {
						System.out.printf("%15s%15s%15s%10s", statusSTACK.toString(), characterSTACK.toString(),
								input.toString(),
								"r" + ACTION[Integer.parseInt(statusSTACK.get(statusSTACK.size() - 1))][VN.indexOf(a)]
										.split(":")[1]);
						int j = Integer.parseInt(
								ACTION[Integer.parseInt(statusSTACK.get(statusSTACK.size() - 1))][VN.indexOf(a)]
										.split(":")[1]);
						int e = GS.get(j).split(":")[1].length();
						for (int i = 0; i < e; i++) {
							characterSTACK.remove(characterSTACK.size() - 1);
							statusSTACK.remove(statusSTACK.size() - 1);
						}
						characterSTACK.add(GS.get(j).split(":")[0]);
						if (!GOTO[Integer.parseInt(statusSTACK.get(statusSTACK.size() - 1))][VT
								.indexOf(characterSTACK.get(characterSTACK.size() - 1))].equals("")) {
							System.out.println("  " + GOTO[Integer.parseInt(statusSTACK.get(statusSTACK.size() - 1))][VT
									.indexOf(characterSTACK.get(characterSTACK.size() - 1))]);
							statusSTACK.add(GOTO[Integer.parseInt(statusSTACK.get(statusSTACK.size() - 1))][VT
									.indexOf(characterSTACK.get(characterSTACK.size() - 1))]);
						} else
							System.out.println();
					} else {
						if (ACTION[Integer.parseInt(statusSTACK.get(statusSTACK.size() - 1))][VN.indexOf(a)]
								.split(":")[0].equals("acc")) {
							return true;
						} else
							return false;
					}
				}
			}
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
