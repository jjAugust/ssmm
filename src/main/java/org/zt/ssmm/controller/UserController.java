package org.zt.ssmm.controller;

import java.util.ArrayList;

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
import org.zt.ssmm.util.ReturnUtil;

@Controller
@RequestMapping("/userController")
public class UserController 
{
	@Autowired
	private UserService us;

	
	@ResponseBody
	@RequestMapping("/showUser")
	public Object showUser(String id, HttpServletRequest req,HttpSession httpSession)
	{
		User u = us.getUserById( (Integer)req.getSession().getAttribute("id"));
		req.setAttribute("user", u);
		Returntype text=new Returntype();
		ReturnUtil.fix(text,"_KEYS_s01");
	        text.setData(u);
	        return text;  
	}
	
	@RequestMapping("/deleteUser")
    @ResponseBody  
	public Object deleteUser(String id, HttpServletRequest req)
	{
	    Returntype text=new Returntype();
		Integer i=0;
		i=us.deleteUserAndPassword(Integer.valueOf(id));
		if(i==1){

	        ReturnUtil.fix(text,"_KEYS_s03");
	        return text;  
		}
		else{

			  ReturnUtil.fix(text,"_KEYS_f04");
		        return text;  
	}
	}
	
    /** 
     * 测试返回JSON数据 
     * @param session 
     * @return 
     */  
    @RequestMapping(value="/test" )  
    @ResponseBody  
    public Object test(HttpServletRequest req){  
          
        Returntype text=new Returntype();
        ReturnUtil.fix(text,"_KEYS_f01");
        return text;  
    }  
	
	
	@RequestMapping("/addUser")
    @ResponseBody  
	public Object addUser(String name,String password, HttpServletRequest req)
	{


		 Returntype text=new Returntype();
		User role = new User();
		role.setName(name);
		role.setPassword(password);
		//先查询是否已用了该登录名 否则需提示
		Integer j=0;
		j=us.selectUser(name);
		if(j>=1){
		        ReturnUtil.fix(text,"_KEYS_f02");
		        return text;  
		}
		
		else{
			Integer i=0;
		i=us.insertUserAndPassword(role);
		if(i==1){
			 ReturnUtil.fix(text,"_KEYS_s02");
		        return text;  
		}
		else{
			
			 ReturnUtil.fix(text,"_KEYS_f03");
		        return text;  
		}
		}
	}
	
	
	@RequestMapping("/{id}/showUser1")
    @ResponseBody  
	public Object showUser1(@PathVariable String id, HttpServletRequest req)
	{
		User u = us.getUserById(Integer.valueOf(id));
		req.setAttribute("user", u);
		Returntype text=new Returntype();
		ReturnUtil.fix(text,"_KEYS_s01");
	        text.setData(u);
	        return text;  
	}
	
	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}
}
