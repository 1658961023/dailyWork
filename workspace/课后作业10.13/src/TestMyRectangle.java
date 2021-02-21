
public class TestMyRectangle {
public static void main(String[] args) {
	MyRectangle2D r1=new MyRectangle2D(2,2,5.5,4.9);
	System.out.println("Area is :"+r1.getAreac()+" Perimeter is :"+r1.getPerimeter());
	System.out.println(r1.contains(3, 3)+" "+r1.contanins(new MyRectangle2D(4,5,10.5,3.2))+" "+r1.overlaps(new MyRectangle2D(3, 5, 5.5, 3.2)));
}
}
