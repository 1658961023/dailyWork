import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateRequestion {
	
	static String[] regexStr = {"\\(FR,\\d+,(UP|DOWN),\\d+\\.?\\d{0,}\\)","\\(ER,\\d+,\\d+\\.?\\d{0,}\\)"};
	
	
	
	public static boolean isLegalRequestion(String str){
		String[] strs;
		strs = str.split(",");
		for (int i = 0; i < regexStr.length; i ++){
			Pattern pattern = Pattern.compile(regexStr[i]);
			Matcher matcher = pattern.matcher(str);
			if(matcher.matches() == true){
				if (Integer.valueOf(strs[1]) < 1 || Integer.valueOf(strs[1]) > 10){
					return false;
				} else if (strs[0].equals("(FR")){
					switch (strs[2]){
					case "UP":
						if (strs[1].equals("10")){
							return false;
						} else 
							return true;
					case "DOWN":
						if (strs[1].equals("1")){
							return false;
						}
						else
							return true;
					}
				} else {
					return true;
				}
			}
		}
		return false;
	}
}

