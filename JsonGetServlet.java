package com.godor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/restget")
public class JsonGetServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		JsonObject jsonObject=Json
				.createObjectBuilder()
				.add("id", 301)
				.add("name","Cep Telefonu")
				.add("price",3540)
				.build();
		
		String jsonString=jsonObject.toString();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out=response.getWriter();
		out.append(jsonString);
		
		
	}
	

}
