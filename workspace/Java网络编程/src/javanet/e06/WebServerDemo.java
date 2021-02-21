package javanet.e06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebServerDemo {
    public static void main(String[] args) {
        try {
            URL server = new URL("https://10.254.164.99:10253");
            BufferedReader br = new BufferedReader(new InputStreamReader(server.openStream()));
            String inputLine;
            boolean formStart = false;
            boolean formEnd = false;
            while ((inputLine = br.readLine() )!= null){
                if(inputLine.contains("form")){
                    formStart = true;
                }
                if(inputLine.contains("/form")){
                    formEnd = true;
                }
                if(inputLine.contains("input") && formStart && !formEnd ){
                    System.out.println(inputLine.substring(inputLine.indexOf("name=")+6,inputLine.length()-2));
                }
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
