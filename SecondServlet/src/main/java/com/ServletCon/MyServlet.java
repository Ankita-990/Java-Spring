package com.ServletCon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet
{
	protected void deGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		out.println("Hi</br>");
		
//		ServletContext ctx = getServletContext();
//		String name = ctx.getInitParameter("name");
		
		ServletConfig con = getServletConfig();
		String name = con.getInitParameter("name");
		
		out.println(name);	
	}
}
