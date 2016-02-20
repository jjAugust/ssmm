package org.zt.ssmm_demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zt.ssmm.core.User;
import org.zt.ssmm.service.UserService;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-test.xml","classpath:spring-mybatis-test.xml"})
public class UserServiceImplTest 
{
	private static final Logger logger = Logger.getLogger(UserServiceImplTest.class);
	@Autowired
	private UserService us;

	@Test
	public void testGetUserById()
	{
		User user = us.getUserById(1);
		logger.info(JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd hh:mm:ss"));
	}
	
	@Test
	public void testGetAllUsers()
	{
		List<User> l = us.getAllUsers();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd hh:mm:ss"));
	}
	
	@Test
	public void testGetAllUsersWithRole()
	{
		List<User> l = us.getAllUsersWithRole();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd hh:mm:ss"));
	}
	
	public UserService getUs() {
		return us;
	}
	public void setUs(UserService us) {
		this.us = us;
	}

}
