package com.WebServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddNumbers extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int a = Integer.parseInt(req.getParameter("num1"));
		int b = Integer.parseInt(req.getParameter("num2"));
		
		int result = a + b;
		
//		req.setAttribute("result", result);
		
//		res.getWriter().println("Result is " + result);
		
//		RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
		
//		res.sendRedirect("sq?result=" + result);
		
//		HttpSession session = req.getSession();
//		session.setAttribute("result", result);
		
		
		Cookie cookie = new Cookie("result", result + "");
		res.addCookie(cookie);

		res.sendRedirect("sq");
	}
}
