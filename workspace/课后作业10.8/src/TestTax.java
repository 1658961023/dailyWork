
public class TestTax {
	public static void main(String[] args) {
		int[][] brackers2009 = { { 8350, 33950, 52250, 171550, 372950 }, { 16700, 67900, 137050, 208850, 372950 },
				{ 8350, 33950, 68525, 104425, 186425 }, { 11950, 45500, 117450, 190200, 372950 } };
		double[] rates2009 = { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 };
		int[][] brackers2001 = { { 27050, 65550, 136750, 297350 }, { 45200, 109250, 166500, 297350 },
				{ 22600, 54625, 83250, 148675 }, { 36250, 93650, 151650, 297350 } };
		double[] rates2001 = { 0.15, 0.275, 0.305, 0.355, 0.391 };
		Tax newtax;
		System.out.println("\t\t\t\t\t2001年");
		System.out.println("\t单身纳税人\t已婚公共或丧偶纳税人\t已婚单身纳税人\t家庭纳税人");
		for (double i = 50000; i <= 60000; i += 1000) {
			newtax = new Tax(Tax.SINGLE_FILER, brackers2001, rates2001, i);
			showTax(newtax);
			newtax = new Tax(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW, brackers2001, rates2001, i);
			showTax(newtax);
			newtax = new Tax(Tax.MARRIED_SEPARATELY, brackers2001, rates2001, i);
			showTax(newtax);
			newtax = new Tax(Tax.HEAD_OF_HOUSEHOLD, brackers2001, rates2001, i);
			showTax(newtax);
			System.out.println();
		}
		System.out.println("\t\t\t\t\t2009年");
		System.out.println("\t单身纳税人  已婚公共或丧偶纳税人   已婚单身纳税人  家庭纳税人");
		for (double i = 50000; i <= 60000; i += 1000) {
			newtax = new Tax(Tax.SINGLE_FILER, brackers2009, rates2009, i);
			showTax(newtax);
			newtax = new Tax(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW, brackers2009, rates2009, i);
			showTax(newtax);
			newtax = new Tax(Tax.MARRIED_SEPARATELY, brackers2009, rates2009, i);
			showTax(newtax);
			newtax = new Tax(Tax.HEAD_OF_HOUSEHOLD, brackers2009, rates2009, i);
			showTax(newtax);
			System.out.println();
		}
	}

	public static void showTax(Tax tax) {
		System.out.print("\t" + tax.getTax() + "\t");
	}
}
