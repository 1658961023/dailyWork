package lab1;

import java.io.*;
import java.util.*;

public class Lab1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char G[][] = new char[20][50];
		char VN[] = new char[50];
		char VT[] = new char[50];
		BufferedReader br = new BufferedReader(new FileReader("grammar.txt"));
		String[] lines = br.readLine().split(",");
		G = addGrammar(lines);
		judgeTerminator(lines, G, VN, VT);
		judgeGrammarType(lines);
		br.close();
	}
	
	public static char [][] addGrammar(String [] lines){
		char [][] G = new char[20][50];
		int i=0;
		for (int j = 0; j < lines.length; j++) {
			for (int k = 0; k < lines[i].length(); k++) {
				G[j][k] = lines[i].charAt(k);
				if(!Character.isLetter(G[j][k]) && !":".equals(G[j][k]+"")){
					System.out.println("输入的文法含非法字符");
					System.exit(0);
				}
			}
			i++;
		}
		return G;
	}
	
	public static void judgeTerminator(String[] lines,char[][] G,char[] VN,char[] VT){
		int Vn=0;
		int Vt=0;
		List<Character> listVN = new ArrayList<Character>();
		List<Character> listVT = new ArrayList<Character>();
		for(int m=0;m<lines.length;m++){
			for(int n=0;n<lines[m].length();n++){
				System.out.print(G[m][n]);
				if(Character.isUpperCase(G[m][n]) && !listVN.contains(G[m][n])){
					listVN.add(G[m][n]);
					VN[Vn] = G[m][n];
					Vn++;
				}
				else if(Character.isLowerCase(G[m][n]) && !listVT.contains(G[m][n])){
					listVT.add(G[m][n]);
					VT[Vt] = G[m][n];
					Vt++;
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("非终结符有:");
		for(int x=0;x<VN.length;x++){
			System.out.print(VN[x]+" ");
		}
		System.out.println();
		System.out.println("终结符有:");
		for(int y=0;y<VT.length;y++){
			System.out.print(VT[y]+" ");
		}
	}

	public static void judgeGrammarType(String[] G){
		System.out.println();
		if(isThird(G)){
			System.out.println("该文法是3型文法");
		}
		else if(isSecond(G)){
			System.out.println("该文法是2型文法");
		}
		else if(isFirst(G)){
			System.out.println("该文法是1型文法");
		}
		else if(isZero(G)){
			System.out.println("该文法是0型文法");
		}
		else System.out.println("该文法不是0型文法");
	}
	
	public static boolean isZero(String[] G){
		boolean flag0 = false;
		for(int i=0;i<G.length;i++){
			String left = G[i].split(":")[0];
			flag0 = false;
			for(int j=0;j<left.length();j++){
				if(Character.isUpperCase(G[i].charAt(j))){
					flag0 = true;
				}
			}
		}
		return flag0;
	}
	
	public static boolean isFirst(String[] G){
		boolean flag1 = true;
		if(isZero(G)){
			for(int i=0;i<G.length;i++){
			String left = G[i].split(":")[0];
			String right = G[i].split(":")[1];
			if(right.length() < left.length()){
				flag1 = false;
			}
		}
		}
		else flag1 = false;
		return flag1;
	}
	
	public static boolean isSecond(String[] G){
		boolean flag2 = true;
		if(isFirst(G)){
			for(int i=0;i<G.length;i++){
				String left = G[i].split(":")[0];
				if(left.length()!=1 && !Character.isUpperCase(left.charAt(0))){
					flag2 = false;
				}
			}
		}
		else flag2 = false;
		return flag2;
	}
	
	public static boolean isThird(String[] G){
		boolean flag3 = true;
		if(isSecond(G)){
			for(int i=0;i<G.length;i++){
				String right = G[i].split(":")[1];
				if( !(right.length()==1 && Character.isLowerCase(right.charAt(0))) && !(right.length()==2 && Character.isLowerCase(right.charAt(0)) && Character.isUpperCase(right.charAt(1))) ){
					flag3 = false;
				}
			}
		}
		else flag3 = false;
		return flag3;
	}
}
