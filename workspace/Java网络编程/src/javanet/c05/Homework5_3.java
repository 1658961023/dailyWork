package javanet.c05;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import sun.net.www.http.HttpClient;

public class Homework5_3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//getUrls();//获取给定网页中所包含的css、js、图片以及超链接的对应地址
		autoLogin();// 按照给定网页中的登录表单实现自动登录并能获取登录后的页面内容
	}

	public static void getUrls() {
		URL url = null;
		URLConnection urlconn = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		String regex = "https://[\\w+\\.?/?]+\\.[A-Za-z]+";
		Pattern p = Pattern.compile(regex);
		try {
			url = new URL("https://www.bilibili.com/");
			urlconn = url.openConnection();
			pw = new PrintWriter(new FileWriter("src/javanet/c05/urls.txt"), true);
			br = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
			String buf = null;
			while ((buf = br.readLine()) != null) {
				Matcher buf_m = p.matcher(buf);
				while (buf_m.find()) {
					pw.println(buf_m.group());
				}
			}
			BufferedReader br2 = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/javanet/c05/urls.txt")));
			String str;
			while ((str = br2.readLine()) != null) {
				System.out.println(str);
			}
			br2.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pw.close();
		}
	}

	public static void autoLogin() throws IOException{
		List<String> params = new ArrayList<>();
		String action = null;
		Boolean formStart = false;
		boolean formEnd = false;
		URL url = new URL("http://localhost:8080/login.html");
		URLConnection conn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String s;
		Pattern p=Pattern.compile("action=\"(.*?)\"");
		Pattern p2 = Pattern.compile("name=\"(.*?)\"");
		while((s=br.readLine())!=null){
			if(s.contains("action")){
				Matcher m = p.matcher(s);
				while(m.find()){
					action = m.group().substring(m.group().indexOf("action")+8,m.group().length()-1);
				}
			}
			if(s.contains("form")){
                formStart = true;
            }
            if(s.contains("/form")){
                formEnd = true;
            }
            if(s.contains("input") && formStart && !formEnd ){
            	Matcher m = p2.matcher(s);
            	while(m.find()){
            		params.add(m.group().substring(m.group().indexOf("name")+6,m.group().length()-1));
            	}                
            }
		}
		URL newUrl = new URL("http://localhost:8080/"+action);
		URLConnection newConn = newUrl.openConnection();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(newConn.getInputStream()));
		while((s=br2.readLine())!=null){
			System.out.println(s);
		}
	}
}
