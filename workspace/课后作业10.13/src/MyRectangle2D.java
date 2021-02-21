
public class MyRectangle2D {
public double x;
public double y;
public void setX(double x){
	this.x=x;
}
public double getX(){
	return x;
}
public void setY(double y){
	this.y=y;
}
public double getY(){
	return y;
}
public double width;
public double height;
public void setWidth(double width){
	this.width=width;
}
public double getWidth(){
	return width;
}
public void setHeight(double height){
	this.height=height;
}
public double getHeight(){
	return height;
}
public void creatRectangle(){
	x=0;
	y=0;
	width=1;
	height=1;
}
public MyRectangle2D(double x,double y,double width,double height){
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
}
public double getAreac(){
	return width*height;
}
public double getPerimeter(){
	return 2*(width+height);
}
public boolean contains(double x,double y){
	if(2*Math.abs(x-this.x)<width&&2*Math.abs(y-this.y)<height)
		return true;
	return false;
}
public boolean contanins(MyRectangle2D r){
	if((this.x-r.x+r.width)/2<this.width/2&&(this.y-r.y+r.height)/2<this.height/2)
		return true;
	return false;
}
public boolean overlaps(MyRectangle2D r){
	if(((Math.abs(this.x-r.x)+r.width)/2>this.width/2&&(Math.abs(this.x-r.x)+r.width)/2<(this.width+r.width)/2)||((Math.abs(this.y-r.y)+r.height)/2>this.height/2&&(Math.abs(this.y-r.y)+r.height)/2<(this.height+r.height)/2))
			return true;
	return false;
}
}
