
public class MyString2 {
private String str;
public MyString2(String s){
	str=s;
}
public int compare(String s){
	for(int i=0;i<s.length();i++){
		if(str.charAt(i)>s.charAt(i)){
			return 1;
		}
		if(str.charAt(i)<s.charAt(i)){
			return -1;
		}
	}
	return 0;
}
public MyString2 substring(int begin){
	char [] newstr=new char[str.length()-begin+1];
	int a=0;
	for(int i=begin;i<str.length();i++){
		newstr[a]=str.charAt(i);
	}
	MyString2 newstring=new MyString2(newstr.toString());
	return newstring;
}
public MyString2 toUppercase(){
	char [] newstr=new char[str.length()];
	for(int i=0;i<str.length();i++){
		if(str.charAt(i)>'a'&&str.charAt(i)<'z'){
			newstr[i]=(char) (str.charAt(i)+32);
		}
		else{
			newstr[i]=str.charAt(i);
		}
	}
	MyString2 newstring=new MyString2(newstr.toString());
	return newstring;
}
public char[] toChars(){
	char [] newstr=new char[str.length()];
	for(int i=0;i<str.length();i++){
		newstr[i]=str.charAt(i);
	}
	return newstr;
}
public static MyString2 valueOf(boolean b){
	String a="true";
	String a2="false";
	if(b){
		MyString2 newstring=new MyString2(a);
		return newstring;
	}
	else{
		MyString2 newstring=new MyString2(a2);
		return newstring;
	}
}
}
