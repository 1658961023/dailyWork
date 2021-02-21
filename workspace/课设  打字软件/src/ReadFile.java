import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
private String filename;
private String filetxt = "";
public ReadFile() {

}

public String getFilename() {
	return filename;
}

public void setFilename(String filename) {
	this.filename = filename;
}

public String getFiletxt() {
	return filetxt;
}

public void setFiletxt(String filetxt) {
	this.filetxt += filetxt;
}
public String read() throws IOException{
	Scanner input=new Scanner(new File(this.filename));
	while(input.hasNext()){
		this.setFiletxt(input.nextLine()+"\n");
	}
	input.close();
	return this.getFiletxt();
}
}
