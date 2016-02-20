package org.zt.ssmm.service;

import java.util.List;

import org.zt.ssmm.core.User;

public interface UserService 
{
	User getUserById(Integer id);
	List<User> getAllUsers();
	List<User> getAllUsersWithRole();
}
