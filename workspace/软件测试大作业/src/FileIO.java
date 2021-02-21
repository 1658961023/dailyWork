import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileIO {
	public static String readFile(String path) throws IOException{
		File file = new File(path);
		if (!file.exists()){
			throw new FileNotFoundException("File is not exist!");
		}
		
		FileInputStream fis = new FileInputStream(file);
		int n;
		StringBuffer sb = new StringBuffer();
		byte[] bytes = new byte[1024];
		while ((n = fis.read(bytes)) != -1){
			sb.append(new String(bytes,0,n));
			bytes = new byte[1024];
		}
		
		fis.close();
		return sb.toString();
	}
	
	public static void writeFile(String path,String content) throws IOException{
		File file = new File(path);
		if (!file.exists()){
			throw new FileNotFoundException("File is not exist!");
		}
		
		FileOutputStream fos = new FileOutputStream(file,true);
		PrintStream p = new PrintStream(fos);
		p.println(content);
		p.close();
	}
}
