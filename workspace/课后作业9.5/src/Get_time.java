import java.util.*;
public class Get_time {
	public static void main(String[] args){
		Calendar time=GregorianCalendar.getInstance();
		System.out.println("Now is "+time.get(GregorianCalendar.YEAR)+" �� "+(time.get(GregorianCalendar.MONTH)+1)+" �� "+time.get(GregorianCalendar.DAY_OF_MONTH)+" �� ");
		time.setTimeInMillis(1234567898765L);
		System.out.println("Now is "+time.getTime());
	}
}
