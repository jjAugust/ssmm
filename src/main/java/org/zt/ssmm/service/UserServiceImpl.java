package org.zt.ssmm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zt.ssmm.core.Ip;
import org.zt.ssmm.core.User;
import org.zt.ssmm.dao.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(Integer id) 
	{
		return userMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<User> getAllUsers() 
	{
		return userMapper.getAllUsers();
	}
	
	@Override
	public List<User> getAllUsersWithRole() 
	{
		return userMapper.getAllUsersWithRole();
	}

	@Override
	public int deleteUserAndPassword(int record) 
	{
		return userMapper.deleteByPrimaryKey(record);
	}
	
	@Override
	public int insertUserAndPassword(User role) 
	{
		return userMapper.insert2(role);
	}
	
	@Override
	public int selectUser(String role) 
	{
		return userMapper.selectUser(role);
	}
	
	@Override
	public int insertIpinfo(Ip info) 
	{
		return userMapper.insertIpinfo(info);
	}
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}
