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

import com.mysql.jdbc.StringUtils;
  

  
  
public class IpInterceptor extends HandlerInterceptorAdapter{  
	@Autowired
    private UserService us;
	
	public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if ( !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if ( !"unknown".equalsIgnoreCase(ip)) {
        // 多次反向代理后会有多个IP值，第一个为真实IP。
        int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
             return request.getRemoteAddr();
        }
    }
  
    @Override    
    public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {    
   

        String requestUri = request.getRequestURI();  
        String contextPath = request.getContextPath();  
        String url = requestUri.substring(contextPath.length());  
        String ip=getIpAddr(request);
//        System.out.println(ip);  
//        System.out.println(url);  
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        
        Ip info=new Ip();
        info.setIp(ip);
        info.setUrl(url);
        info.setTime(df.format(new Date()));
        
        if (us.selectBlackIp(info)>=1) {  
        	 request.getRequestDispatcher("/blackIp.jsp").forward(request, response);  
         	return false;
        }  
        
        
        
		us.insertIpinfo(info);
//        System.out.println(us.selectIpOneSecond(info));
        if(us.selectIpOneSecond(info)>=5){
        	us.insertBlackIp(info);
        	 request.getRequestDispatcher("/blackIp.jsp").forward(request, response);  
        	return false;
        }
            return true;     
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