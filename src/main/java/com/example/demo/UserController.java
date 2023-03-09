package com.example.demo;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	UserDao dao;
	@Autowired
	FooditemsDAO fooddao;

	
	@RequestMapping("/insertuser")
	public ModelAndView insertControl(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		User u=new User();
		u.setUserid(Integer.parseInt(request.getParameter("userid")));
		u.setFname(request.getParameter("Fname"));
		u.setLname(request.getParameter("Lname"));
	     u.setUsername(request.getParameter("username"));
	     u.setPassword(request.getParameter("password"));
		User u1=dao.insertuser(u);
		if(u1!=null) {
//		mv.setViewName("user_reg_succ.jsp");
			mv.setViewName("successuser.jsp");
		}
		return mv;
	}
	
			@RequestMapping("/user_login")
			public String user_login(HttpServletRequest req, HttpServletResponse res)
			{
				ModelAndView mv = new ModelAndView();
				
				User uu=new User();
				uu.setFname(req.getParameter("Fname"));
				String Fname = uu.getFname();
				
				uu.setPassword(req.getParameter("password"));
				String password = uu.getPassword();
				
				User us = dao.findByFNamePassword(Fname, password);
				if(us!=null)
				{
					mv.addObject("us",us);
					return "Welcome Back"+" "+ Fname;
//					mv.setViewName("successuser.jsp");
					
				
				}
				else {
					return "Check Credentisl's or Register" + " ";
//					mv.setViewName("userloginfail.jsp");
//					
				}		
//			
			}

	@RequestMapping("/getalll")
	public ModelAndView displayAll(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv=new ModelAndView();
		List<Fooditems> list= fooddao.getall();
		mv.setViewName("extra.jsp");
		mv.addObject("list",list);
		return mv;
		
	}
}