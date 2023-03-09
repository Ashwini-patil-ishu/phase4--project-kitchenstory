package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@Autowired
	AdminRepo repo;
	@Autowired
	AdminDao adao;
	
	
	@RequestMapping("/apply_admin")
	public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Admin A = new Admin();
////		A.setId(Integer.parseInt(request.getParameter("id")));
		A.setUsername(request.getParameter("username"));
		A.setPassword(request.getParameter("password"));
		A.setEmail(request.getParameter("Email"));
		A.setPhono(request.getParameter("phono"));
		Admin aa = adao.insert(A);
		if(aa!=null) {
			mv.setViewName("reg_succ.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView displayadminpage(Model m) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminlogin.jsp");
		return mv;
	}
	
	
	@RequestMapping( "/verifyAdmin")
	public ModelAndView checklogin(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();

		Admin aa=new Admin();
		aa.setUsername(req.getParameter("username"));
		String username=aa.getUsername();
		
		aa.setPassword(req.getParameter("password"));
		String password=aa.getPassword();
	
		Admin ad =adao.usernamepassword(username, password);
		if(ad!=null){		
			mv.addObject("ad", ad);
			mv.setViewName("adminlogin1.jsp");
			}
		else 
		{
			mv.setViewName("AdminLogFailed.jsp");
		}
		return mv;
	}

	@RequestMapping("forget_ad_pass")
	public ModelAndView forget_pass(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		String phono = req.getParameter("phono");
		List<Admin> pass_list = adao.forget_pass(phono);
		mv.setViewName("get_admin_pass.jsp");
		mv.addObject("pass_list",pass_list);
		return mv;
	}
}
