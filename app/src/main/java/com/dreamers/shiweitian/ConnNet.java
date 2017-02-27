package com.dreamers.shiweitian;

import android.widget.Toast;

import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnNet 
{
	private static final String URLVAR="http://60.205.182.144:8080/shiweitian3/";

	//通过url获取网络连接  connection
	public HttpURLConnection getConn(String urlpath)
	{
		String finalurl=URLVAR+urlpath;
		HttpURLConnection connection = null;
		try {
			URL url=new URL(finalurl);
			connection=(HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod("POST");
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return connection;

	}
	public HttpPost gethttPost(String uripath)
	{	
		HttpPost httpPost=new HttpPost(URLVAR+uripath);
		System.out.println(URLVAR+uripath);
		return httpPost;
	}

}
