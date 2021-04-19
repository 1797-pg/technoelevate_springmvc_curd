package com.te.springmvc.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.EmployeeBean;
import com.te.springmvc.dao.EmployeeDao;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;
	@GetMapping("/emplogin")
	public String getLoginForm() {
		return "emplogin";
	}
	@PostMapping("/emplogin")
	public String authenticate(int id,String pwd,HttpServletRequest request,ModelMap map) {
		EmployeeBean employeeBean=dao.authenticate(id,pwd);
		if(employeeBean!=null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("emp", employeeBean);
			return "HomePage";
		}else {
			map.addAttribute("errmsg","invalid Credentials");
			return "display";
		}
	}
	@GetMapping("/search")
	public String getSearchForm(ModelMap map,HttpSession session) {
		if(session.getAttribute("emp")!=null) {
			return "searchForm";
		}
		else {
			map.addAttribute("errmsg","please login first");
			return "emplogin";
		}
	}
	@GetMapping("/search2")
	public String searchEmp(int id,ModelMap map,@SessionAttribute(name="emp" ,required=false)EmployeeBean employeeBean){
		if(employeeBean!=null) {
			EmployeeBean bean2=dao.getEmployee(id);
			if(bean2!=null) {
				map.addAttribute("data",bean2);
			}else {
				map.addAttribute("msg","data not found for id:"+id);
			}
			return "searchForm";
		}else {
			map.addAttribute("errmsg","please login first");
			return "emplogin";
		}
	}
	@GetMapping("/delete")
	public String deleteEmpData(ModelMap map,HttpSession session) {
		if(session.getAttribute("emp")!=null) {
			return "DeleteForm";
		}
		else {
			map.addAttribute("errmsg","please login first");
			return "emplogin";
		}
	}
	@GetMapping("/delete2")
	public String deleteData(int id,@SessionAttribute(name="emp" ,required=false)EmployeeBean employeeBean,ModelMap map) {
		if(employeeBean!=null) {
			boolean isDeleted=dao.deleteEmpData(id);
			if(isDeleted) {
				map.addAttribute("msg","deleted successfully");
			    
			}
			else {
				map.addAttribute("errmsg","put right details");
				
			}
			return "DeleteForm";
		}
		return "emplogin";
		
	}
	
}

