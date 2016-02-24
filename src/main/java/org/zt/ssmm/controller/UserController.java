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
@RequestMapping("/userController")
public class UserController 
{
	@Autowired
	private UserService us;
	
	@RequestMapping("/showUser")
	public String showUser(String id, HttpServletRequest req,HttpSession httpSession)
	{
		User u = us.getUserById( (Integer)req.getSession().getAttribute("id"));
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
	
    /** 
     * 测试返回JSON数据 
     * @param session 
     * @return 
     */  
    @RequestMapping(value="/test" )  
    @ResponseBody  
    public Object test(HttpServletRequest req){  
          
        System.out.println("test....................");  
        Returntype text=new Returntype();
        text.setCode("error01");
        text.setMessage("测试");
        return text;  
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
