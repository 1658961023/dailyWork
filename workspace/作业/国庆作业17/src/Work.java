public class Work {
	public static void main(String[] args) {
		for(char i='x';i<='z';i++)
			for(char j='x';j<='z';j++)
				for(char k='x';k<='z';k++)
					if(i!=j&&i!=k&&j!=k&&i!='x'&&k!='x'&&k!='z')
						System.out.println("a vs "+i+", b vs "+j+", c vs "+k);
	}
}
