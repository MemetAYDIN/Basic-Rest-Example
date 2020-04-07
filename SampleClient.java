package com.godoro.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SampleClient {
	
	
	
	public static void main(String[] args) throws Exception {
		
		String address="http://localhost:8080/Java09/sapmle";
		URL url=new URL(address);
		URLConnection connection=url.openConnection();
		InputStream in=connection.getInputStream();
		
		String response=read(in);
		System.out.println("Yanıt:\n"+response);
		
		
		
	}
	
	private static String read(InputStream in) throws Exception
	{
		BufferedReader reader=new BufferedReader(
				new InputStreamReader(in,"utf-8"));
		
		StringBuilder builder=new StringBuilder();
		String line=null;
		while((line=reader.readLine())!=null)
		{
			builder.append(line).append("\r\n");
			
		}
		return builder.toString();
	}

}
