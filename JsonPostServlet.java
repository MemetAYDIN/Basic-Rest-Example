package com.godor.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/restpost")
public class JsonPostServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String jsonString=read(request.getInputStream());
		System.out.println("Yanıt:\n"+response);
		
		
		
		//String ten jeson içinden veriyi almak(PAsre etmek)
		
				JsonReader jsonReader=Json.createReader(new StringReader(jsonString));
				
				JsonObject jsonObject=jsonReader.readObject();
				jsonReader.close();
				
				long id=jsonObject.getJsonNumber("id").longValue();
				
				String name=jsonObject.getString("name");
				double price=jsonObject.getJsonNumber("price").doubleValue();
				
				System.out.println(id+" "+name+" "+price);
				
			
				response.setContentType("application/json; charset=utf-8");
				PrintWriter out=response.getWriter();
				out.append("{\"result\":\"Oldu\"}");
				
		
	}
	
	private static String read(InputStream in) throws IOException
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
