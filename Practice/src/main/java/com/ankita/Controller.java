package com.ankita;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/register")
public class Controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		request.setAttribute("uname", uname);
		request.setAttribute("pass", pass);
		
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.include(request, response);
		
		response.getWriter().println(request.getContextPath());
	}

}
