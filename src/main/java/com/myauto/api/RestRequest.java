package com.myauto.api;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.myauto.util.Util;


/**
 * Created by File on 2017/6/17.
 */
public class RestRequest {
    private URL url;
    private String method;
    private String username;
    private String password;

    public RestRequest(String url, String method, String username, String password) throws MalformedURLException {
        this.url = new URL(url);
        this.method = method;
        this.username = username;
        this.password = password;
    }

    public String sendRequest() throws Throwable {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String authStr = username + ":" + password;
        String authStrEnc = new String(Base64.encodeBase64(authStr.getBytes()));

        connection.setRequestMethod(method);
        connection.setRequestProperty("Authorization", "Basic " + authStrEnc);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Charset", "UTF-8");

        connection.setDoOutput(true); //to be checked

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write("test".getBytes(Util.CHARTSET)); //to be checked
        outputStream.flush(); //to be checked
        outputStream.close(); //to be checked

        connection.connect(); //to be checked

        int responseCode = connection.getResponseCode();
        System.out.println("responseCode=" + responseCode);

        String readLine;
        StringBuilder responseStr = new StringBuilder();
        BufferedReader responseReader;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Util.CHARTSET));
        } else {
            responseReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Util.CHARTSET));
        }

        while ((readLine = responseReader.readLine()) != null) {
            responseStr.append(readLine).append("\n");
        }
        responseReader.close();

        return responseStr.toString();
    }

}
