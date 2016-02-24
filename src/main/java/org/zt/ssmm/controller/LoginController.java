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
	public String showUser(String id, HttpServletRequest req,HttpSession httpSession)
	{
		User u = us.getUserById(Integer.valueOf(id));
		req.setAttribute("user", u);
		  httpSession.setAttribute("username", u.getName());  
		return "showUser";
	}
	
	@RequestMapping("/login")
	public String login(String name,String password, HttpServletRequest req,HttpSession httpSession)
	{
		User po=new User();
		po.setName(name);
		po.setPassword(password);
		
		
		User u = us.selectByNamePWD(po);
		if(u==null){

			  return "error";
		}
		else{
			req.setAttribute("user", u);
			  httpSession.setAttribute("id", u.getId()); 
		  httpSession.setAttribute("username", u.getName());  
		  return "showUser";
		}
	}
	
	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}
}
