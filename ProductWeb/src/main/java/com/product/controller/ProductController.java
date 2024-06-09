package com.product.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.Product;
import com.product.service.ServiceProduct;
import com.product.service.serviceImpl.ServiceProductImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductController/*")
public class ProductController extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServiceProduct service = new ServiceProductImpl();
		Product product	= new Product();
		
		String url = request.getRequestURI();
		String req = "";
		
//		System.out.println("URI request " + url);
		
		if(url.contains("/edit")) {
			req = "/edit";
		} else if(url.contains("/delete")) {
			req = "/delete";
		} else if(url.contains("/searchproduct")) {
			req = "/searchproduct";
		}
		
		
			try {
				switch(req) {
				case "/edit":
					int id = Integer.parseInt(request.getParameter("id"));
					product = service.getById(id);
					request.setAttribute("key", product);
					RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
					rd.include(request, response);
					break;
					
				case "/delete":
					id = Integer.parseInt(request.getParameter("id"));
					service.deleteServiceProduct(id);
					response.sendRedirect(request.getContextPath() + "/ProductController");
					break;
					
				case "/searchproduct":
					String search = request.getParameter("search");
					service.getByName(search);
					service.productServiceList();
					response.sendRedirect(request.getContextPath() + "/ProductController");
//					request.setAttribute("searchp", service);
//					rd = request.getRequestDispatcher("/search.jsp");
//					rd.include(request, response);
					break;
					
				default:					
					service.productServiceList();
					request.setAttribute("service", service);
					rd = request.getRequestDispatcher("productlist.jsp");
					rd.include(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServiceProduct service = new ServiceProductImpl();
		Product product = new Product();
		
		String url = request.getRequestURI();
		String req = "";
		
//		System.out.println("URI request" + url);
		
		if(url.contains("/add")) {
			req = "/add";
		} else if(url.contains("/update")) {
			req = "/update";
		} else if(url.contains("/search")) {
			req = "/search";
		}
		
		try {
			switch(req) {
			case "/add":
				int id = Integer.parseInt(request.getParameter("pid"));
				String name = request.getParameter("pname");
				String desc = request.getParameter("pdesc");
				String category = request.getParameter("pcatg");
				product.setPid(id);
				product.setPname(name);
				product.setPdesc(desc);
				product.setPcatagory(category);
				service.createServiceProduct(product);
				response.sendRedirect(request.getContextPath() + "/ProductController");
				break;
				
			case "/search":
				id = Integer.parseInt(request.getParameter("pid"));
				name = request.getParameter("pname");
				desc = request.getParameter("pdesc");
				category = request.getParameter("pcatg");
				product.setPid(id);
				product.setPname(name);
				product.setPdesc(desc);
				product.setPcatagory(category);
				service.productServiceList();
				break;
				
			case "/update":
				String pid = request.getParameter("id");
				String pname = request.getParameter("pname");
				String pdesc = request.getParameter("pdesc");
				String pcatg = request.getParameter("pcatg");
				product.setPid(Integer.parseInt(pid));
				product.setPname(pname);
				product.setPdesc(pdesc);
				product.setPcatagory(pcatg);
				service.updateServiceProduct(product);
				
			default:
				response.sendRedirect(request.getContextPath() + "/ProductController");
			}
			
//			String name = request.getParameter("product");
//			product = service.getByName(name);
//			request.setAttribute("search", product);
//			RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
//			rd.include(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
