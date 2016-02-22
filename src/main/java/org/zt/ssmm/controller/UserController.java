package org.zt.ssmm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zt.ssmm.core.User;
import org.zt.ssmm.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController 
{
	@Autowired
	private UserService us;
	
	@RequestMapping("/showUser")
	public String showUser(String id, HttpServletRequest req)
	{
		User u = us.getUserById(Integer.valueOf(id));
		req.setAttribute("user", u);
		return "showUser";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(String id, HttpServletRequest req)
	{

		Integer i=0;
		i=us.deleteUserAndPassword(Integer.valueOf(id));
		if(i==1){

			req.setAttribute("message", "delete success");
			return "index";
		}
		else{

			req.setAttribute("message", "delete fail");
			return "index";
	}
	}
	
	@RequestMapping("/addUser")
	public String addUser(String name,String password, HttpServletRequest req)
	{


		User role = new User();
		role.setName(name);
		role.setPassword(password);
		//先查询是否已用了该登录名 否则需提示
		Integer j=0;
		j=us.selectUser(name);
		if(j>=1){
			req.setAttribute("message", "name already exist");
			return "index";
		}
		
		else{
			Integer i=0;
		i=us.insertUserAndPassword(role);
		if(i==1){
			req.setAttribute("message", "add success");
			return "index";
		}
		else{
			
			req.setAttribute("message", "add fail");
		return "index";
		}
		}
	}
	
	
	@RequestMapping("/{id}/showUser1")
	public String showUser1(@PathVariable String id, HttpServletRequest req)
	{
		User u = us.getUserById(Integer.valueOf(id));
		req.setAttribute("user", u);
		return "showUser";
	}
	
	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}
}
