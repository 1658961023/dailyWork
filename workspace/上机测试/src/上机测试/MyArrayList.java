package ÉÏ»ú²âÊÔ;

public class MyArrayList {
private Object [] list;
private int next;
public MyArrayList(){
	this.list=new Object[16];
}

public Object[] getList() {
	return list;
}

public void setList(Object[] list) {
	for(int i=0;i<list.length;i++){
		this.list[i]=list[i];
	}
}

public int getNext() {
	return next;
}

public void setNext(int next) {
	this.next = next;
}

public void add(Object o){
	boolean full=true;
	for(int i=0;i<this.list.length;i++){
		if(this.list[i]==null){
			this.list[i]=o;
			full=false;
		}
	}
	if(full==true){
		Object [] newobj=new Object[this.list.length*2];
		for(int i=0;i<newobj.length;i++){
			newobj[i]=this.list[i];
		}
		this.setList(newobj);
	}
}
public Object get(int index){
	return this.list[index];
}
public int size(){
	int count=0;
	for(int i=0;i<this.list.length;i++){
		if(this.list[i]!=null){
			count++;
		}
	}
	return count;
}
}
