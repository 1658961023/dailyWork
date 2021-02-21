package ÊµÑé°Ë;

public class CalLetters {
private String str;
public CalLetters(){
	
}
public CalLetters(String str){
	this.str=str;
}

public String getStr() {
	return str;
}
public void setStr(String str) {
	this.str = str;
}
public int[] getLetters(String str) {
	str=this.str;
	int[] letters = new int[26];
	for (int i = 0; i < str.length(); i++) {
		letters[str.charAt(i) - 'a']++;
	}
	return letters;
}
}
