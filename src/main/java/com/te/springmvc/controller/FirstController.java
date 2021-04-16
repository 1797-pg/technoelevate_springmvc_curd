package com.te.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.te.springmvc.UserBean;

@Controller
public class FirstController {

	@RequestMapping(path="/date", method=RequestMethod.GET)
	public ModelAndView getMethod() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("Date");
		return modelAndView;
	}
	@RequestMapping(path="/search", method=RequestMethod.GET)
	public ModelAndView getData(ModelAndView modelAndView,HttpServletRequest request) {
		String name=request.getParameter("name");
		modelAndView.addObject("username",name);
		modelAndView.setViewName("newHome");
		return modelAndView;
	}
	@GetMapping("/login")
	public String getForm() {
		return "loginform";
	}
	@PostMapping("/login")
	public String getDetails(HttpServletRequest request,ModelMap modelMap ) {
		String name=request.getParameter("user");
		String password=request.getParameter("pass");
		
		modelMap.addAttribute("name",name);
		modelMap.addAttribute("pass",password);
		return "userDetails";
	}
	@PostMapping("/login1")
	public String name(ModelMap modelMap,String pass,String user) {
		modelMap.addAttribute("name",user);
		modelMap.addAttribute("pass",pass);
		return "userDetails";
	}
	@PostMapping("/login2")
	public String nameValue(ModelMap modelMap,UserBean userBean) {
		modelMap.addAttribute("name",userBean.getUser());
		modelMap.addAttribute("pass",userBean.getPass());
		return "userDetails";
	}
	
	@PostMapping("/login3")
	public String getFormRequestParam(ModelMap modelMap,@RequestParam(name="")String user,
			@RequestParam(name="pass")String password) {
		modelMap.addAttribute("name",user);
		modelMap.addAttribute("pass",password);
		return "userDetails";
	}
	
	
	
}
