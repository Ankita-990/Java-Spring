package com.app.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController 
{
//	@RequestMapping("homepage")
//	public String home(HttpServletRequest req, HttpServletResponse res) {
//		String name = req.getParameter("name");
//		System.out.println("hii " + name);
//		req.setAttribute("name", name);
//		return "home";
//	}
	
	@RequestMapping("first")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
}
