package org.zt.ssmm.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;  
import org.zt.ssmm.core.Ip;
import org.zt.ssmm.service.UserService;


public class Authentication  extends HandlerInterceptorAdapter{  
	@Autowired
	private UserService us;


	@Override    
	public boolean preHandle(HttpServletRequest request,    
			HttpServletResponse response, Object handler) throws Exception {    
		//		request.getParameter("access_token");
		System.out.println(request.getParameter("access_token"));
		if(request.getParameter("access_token")==null){
			response.getWriter().write("authentication wrong" );
			return false;
		}
		else
		{
			if(request.getParameter("access_token").equals("asdfg")){
				return true;    
			}
			else{
				response.getWriter().write("authentication wrong" );
				//	 request.getRequestDispatcher("/blackIp.jsp").forward(request, response);  
				return false;
			}
		}

	}    


	@Override    
	public void postHandle(HttpServletRequest request,    
			HttpServletResponse response, Object handler,    
			ModelAndView modelAndView) throws Exception {     
	}    

	@Override    
	public void afterCompletion(HttpServletRequest request,    
			HttpServletResponse response, Object handler, Exception ex)    
					throws Exception {    
	}    

}  