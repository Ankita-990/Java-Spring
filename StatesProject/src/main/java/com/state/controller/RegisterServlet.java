package com.state.controller;

import java.io.IOException;	

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.state.model.States;
import com.state.service.StateService;
import com.state.service.serviceImpl.StateServiceImpl;


@WebServlet("/states/*")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StateService service = new StateServiceImpl();
		States state = new States();
		
		String url = request.getRequestURI();	
		String reqfor = "";
			
		if(url.contains("/editpage")) {
			reqfor = "/editpage";
		} else if(url.contains("/delete")) {
			reqfor = "/delete";
		}
		
		try {
			switch(reqfor) {
			case "/editpage": 
				String id = request.getParameter("id");
				state = service.getStateById(Integer.parseInt(id));
				request.setAttribute("key", state);
				RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
				rd.include(request, response);
				break;

			
			case "/delete":
				 int sid = Integer.parseInt(request.getParameter("id"));
				 service.deleteState(sid);
				 response.sendRedirect(request.getContextPath() + "/states");
				 break;
				 
			default:
				service.listOfStates();
				request.setAttribute("service", service);
				rd = request.getRequestDispatcher("statePage.jsp");
				rd.include(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			StateService service = new StateServiceImpl();
			States state = new States();
			
			String url = request.getRequestURI();
			String reqfor = "";
			
			if(url.contains("/add")) {
				reqfor = "/add"; 
			} else if(url.contains("/update")) {
				reqfor = "/update";
			}
		
			
			switch(reqfor) {
				case "/add":
					int sid = Integer.parseInt(request.getParameter("sid"));
					String sname = request.getParameter("sname");
					state.setSid(sid);
					state.setSname(sname);
					service.newState(state);
					response.sendRedirect(request.getContextPath() + "/states");
					break;
					
				case "/update":
					sid = Integer.parseInt(request.getParameter("id"));
					sname = request.getParameter("sname");
					state.setSid(sid);
					state.setSname(sname);
					service.updateState(state);
					
				default:
					response.sendRedirect(request.getContextPath() + "/states");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
