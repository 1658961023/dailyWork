package µÚÈıÌâ;

public class Tea {
public static void main(String[] args) {
	TeaSize medium=new SmallCup();
	TeaKind blacktea=new GreenTea();
	System.out.println(medium.getSize()+blacktea.getKind());
}
}
