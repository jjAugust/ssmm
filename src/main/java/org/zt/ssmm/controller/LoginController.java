package org.zt.ssmm.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zt.ssmm.core.Returntype;
import org.zt.ssmm.core.User;
import org.zt.ssmm.service.UserService;

@Controller
@RequestMapping("/loginController")
public class LoginController {
	@Autowired
	private UserService us;
	
	@RequestMapping("/login2")
	public String login2(String name,String password, HttpServletRequest req,HttpSession httpSession)
	{
		User po=new User();
		po.setName(name);
		po.setPassword(password);
		
		
		User u = us.selectByNamePWD(po);
		if(u==null){

			  return "jsp/error";
		}
		else{
			req.setAttribute("user", u);
			  httpSession.setAttribute("id", u.getId()); 
		  httpSession.setAttribute("username", u.getName());  
		  return "zyq";
		}
	}
	
	@RequestMapping("/login")
	public String login(String name,String password, HttpServletRequest req,HttpSession httpSession)
	{
		User po=new User();
		po.setName(name);
		po.setPassword(password);
		
		
		User u = us.selectByNamePWD(po);
		if(u==null){

			  return "jsp/error";
		}
		else{
			req.setAttribute("user", u);
			  httpSession.setAttribute("id", u.getId()); 
		  httpSession.setAttribute("username", u.getName());  
		  return "jsp/showUser";
		}
	}
	
	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}
}
