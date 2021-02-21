
public class MyString1 {
	private char[] StringChar;
public MyString1(char[] chars){
	StringChar=chars;
}
public int length(){
	return StringChar.length;
}
public char charAt(int index){
	return StringChar[index-1];
}
public MyString1 substring(int begin,int end){
	char [] newstr = new char [end-begin+1];
	int a=0;
	for(int i=begin-1;i<end;i++){
		newstr[a]=StringChar[i];
		a++;
	}
	MyString1 newstring=new MyString1(newstr);
	return newstring;
}
public MyString1 toLowerCase(){
	char [] newstr = new char [StringChar.length];
	for(int i=0;i<StringChar.length;i++){
		if(StringChar[i]<'Z'&&StringChar[i]>'A'){
			StringChar[i]-=32;
			newstr[i]=StringChar[i];
		}
		else {
			StringChar[i]=StringChar[i];
			newstr[i]=StringChar[i];
		}
	}
	MyString1 newstring=new MyString1(newstr);
	return newstring;
}
public boolean equals(MyString1 s){
	boolean equals=true;
	for(int i=0;i<s.length();i++){
		if(StringChar[i]!=s.charAt(i)){
			equals=false;
		}
	}
	return equals;
}
public static MyString1 valueOf(boolean b){
	char []a={'t','r','u','e'};
	char []a2={'f','a','l','s','e'};
	if(b){
		MyString1 newstr=new MyString1(a);
		return newstr;
	}
	else{
		MyString1 newstr=new MyString1(a2);
		return newstr;
	}
}
}
