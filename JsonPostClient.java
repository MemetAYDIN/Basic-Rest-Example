package com.godoro.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class JsonPostClient {
	
	public static void main(String[] args) throws Exception {
		
		String address="http://localhost:8080/Java09/restpost";
		URL url=new URL(address);
		URLConnection connection=url.openConnection();
		connection.setDoOutput(true);
		
		
		JsonObject jsonObject=Json
				.createObjectBuilder()
				.add("id", 301)
				.add("name","Cep Telefonu")
				.add("price",3540)
				.build();
		String jsonString=jsonObject.toString();
		write(connection.getOutputStream(), jsonString);
		
		//InputStream in=connection.getInputStream();
		//String jsonResponse=read(in);
		String jsonResponse=read(connection.getInputStream());
		JsonReader jsonReader=Json.createReader(new StringReader(jsonResponse));
		JsonObject responseObject=jsonReader.readObject();
		jsonReader.close();
		
		String result=responseObject.getString("result");
		System.out.println("Sonuç: "+result);
		
		
	}
	
	
	public static  void write(OutputStream out,String string) throws IOException
	{
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
		bw.write(string);
		bw.close();
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
