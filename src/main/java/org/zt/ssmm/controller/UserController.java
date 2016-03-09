package org.zt.ssmm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import	java.io.IOException;

import	org.apache.http.HttpEntity;
import	org.apache.http.HttpResponse;
import	org.apache.http.client.ResponseHandler;
import	org.apache.http.client.methods.HttpUriRequest;
import	org.apache.http.client.methods.RequestBuilder;
import	org.apache.http.impl.client.CloseableHttpClient;
import	org.apache.http.impl.client.HttpClients;
import	org.apache.http.util.EntityUtils;

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
	public Object addUser(String name,String password,String birthdate,String occupation, String code, String phone, HttpServletRequest req,HttpSession session,String telcode) throws ParseException
	{

		SimpleDateFormat f=new SimpleDateFormat("yyyy-mm-dd"); 
		Returntype text=new Returntype();
		User role = new User();
		role.setName(name);
		role.setPassword(password);
		role.setBirthdate(f.parse(birthdate));
		role.setOccupation(occupation);
		role.setPhone(phone);

		//先查询是否已用了该登录名 否则需提示
		Integer j=0;
		j=us.selectUser(name);
		if(j>=1){
			ReturnUtil.fix(text,"_KEYS_f02");
			return text;  
		}

		else{
		        if (!(code.equalsIgnoreCase(session.getAttribute("code").toString()))) {  //忽略验证码大小写
		        	ReturnUtil.fix(text,"_KEYS_f05");
					return text;  
		        }
		        else if(!(telcode.equalsIgnoreCase(session.getAttribute("telcode").toString()))){
		        	ReturnUtil.fix(text,"_KEYS_f06");
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
	
	@RequestMapping("/checkphone")
	@ResponseBody  
	public Object checkPhone(String telcode, HttpServletRequest req)
	{
		int u = us.selectPhoneToday(telcode);
		Returntype text=new Returntype();
		ReturnUtil.fix(text,"_KEYS_s04");
		text.setData(u);
		return text;  
	}


	@RequestMapping("/sendSms")
	@ResponseBody  
	public		void	main(String	args[],String telcode,HttpServletRequest req)	{
		CloseableHttpClient	httpClient	=	HttpClients.createDefault();
		Integer i=(int) Math.round(Math.random()*9000+1000);
		String str="{'code':'"+i.toString()+"','product':'乖乖博客'}";
		
		HttpSession session = req.getSession();
        session.setAttribute("telcode", i.toString());
        System.out.println(i.toString());
        
		try	{
			//	请求地址
			HttpUriRequest	httpGet	=	RequestBuilder
					.get("https://ca.aliyuncs.com/gw/alidayu/sendSms")
					.addHeader("X-Ca-Key",	"23319457")
					.addHeader("X-Ca-Secret",	"7842efe3a550fe024dc56dbf59b40f3b")
					.addParameter("rec_num",telcode)
					.addParameter("sms_template_code",	"SMS_5420454")
					.addParameter("sms_free_sign_name",	"注册验证")
					.addParameter("sms_type",	"normal")
					.addParameter("extend",	"1234")
					.addParameter("sms_param",	str)
					.build();
			//	TODO	设置请求超时时间
			//	处理请求结果
			ResponseHandler<String>	responseHandler	=	new	ResponseHandler<String>()	{
				@Override
				public	String	handleResponse(final	HttpResponse	response)	throws	IOException	{
					int	status	=	response.getStatusLine().getStatusCode();
					System.out.println(status);
					HttpEntity	entity	=	response.getEntity();
					return	entity	!=	null	?	EntityUtils.toString(entity)	:	null;
				}
			};
			//	发起 API 调用
			String	responseBody	=	httpClient.execute(httpGet,	responseHandler);
			us.insertPhoneToday(telcode);
			System.out.println(responseBody);
		}	catch	(Exception	e)	{
			e.printStackTrace();
		}	finally	{
			try	{
				httpClient.close();
			}	catch	(IOException	e)	{
				e.printStackTrace();
			}
		}
	}



	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}
}
