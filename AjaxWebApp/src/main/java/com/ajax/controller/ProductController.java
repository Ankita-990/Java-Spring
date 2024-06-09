package com.ajax.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.model.Product;
import com.ajax.service.ServiceProduct;
import com.ajax.service.serviceImpl.ServiceProductImpl;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProduct service = new ServiceProductImpl();
//		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		
//		String url = request.getRequestURI();
		
		System.out.println(request.getContextPath());
		
		try {
			int id = Integer.parseInt(request.getParameter("pid"));
			String name = request.getParameter("pname");
			String desc = request.getParameter("pdesc");
			String category = request.getParameter("pcatg");
			product.setPid(id);
			product.setPname(name);
			product.setPdesc(desc);
			product.setPcatagory(category);
			service.productServiceList();
			request.setAttribute("service", service);
			RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
			rd.include(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
