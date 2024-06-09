
package com.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sq")
public class SquareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
//		int r = Integer.parseInt(req.getParameter("result"));
		
//		HttpSession session = req.getSession();
//		
//		int r = (int) session.getAttribute("result");
		
		int r = 0;
		Cookie[] cookies = req.getCookies();
		
		for(Cookie c: cookies) {
			if(c.getName().equals("result")) {
				r = Integer.parseInt(c.getValue());
			}
		}
		
		r = r * r;
		
		PrintWriter out = res.getWriter();
		out.println("Square is " + r);
	}

}
