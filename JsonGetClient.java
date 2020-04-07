package com.godoro.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class JsonGetClient {
	
public static void main(String[] args) throws Exception {
		
		String address="http://localhost:8080/JavaClientJDBC/restgetdb";
		URL url=new URL(address);
		URLConnection connection=url.openConnection();
		InputStream in=connection.getInputStream();
		
		String response=read(in);
		System.out.println("Yanıt:\n"+response);
		
		
		
		//String ten jeson içinden veriyi almak(PAsre etmek)
		
				JsonReader jsonReader=Json.createReader(new StringReader(response));
				
				JsonObject jsonObject=jsonReader.readObject();
				jsonReader.close();
				
				long id=jsonObject.getJsonNumber("id").longValue();
				
				String name=jsonObject.getString("name");
				double price=jsonObject.getJsonNumber("price").doubleValue();
				
				System.out.println(id+" "+name+" "+price);
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
