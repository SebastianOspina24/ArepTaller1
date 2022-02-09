package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;

public class ConcurrentTest extends Thread {

    private static final String USER_AGENT = "Mozilla/5.0";
    private String GET_URL = "https://areptaller1.herokuapp.com/Temperatura/";

    public ConcurrentTest(String url){
        GET_URL = GET_URL+url;
    }

    public static void main(String[] args) {
        ArrayList<ConcurrentTest> temp = new ArrayList<>();
        for(int i =0;i<10;i++){
            temp.add(new ConcurrentTest("Celsius?value="+i));
        }
        for(int i =0;i<10;i++){
            temp.add(new ConcurrentTest("Fahrenheit?value="+i));
        }
        for (ConcurrentTest i : temp)i.start();
    }

    @Override
    public void run(){

        try{
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        // The following invocation perform the connection implicitly before getting the
        // code
        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
    }catch(IOException e){
        System.out.println("Somthing isn't working");
    }
    }

}
