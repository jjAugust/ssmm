package org.zt.ssmm.service;

import java.util.List;

import org.zt.ssmm.core.Ip;
import org.zt.ssmm.core.User;
import org.zt.ssmm.core.Userdata;

public interface UserService 
{
	User getUserById(Integer id);
	List<User> getAllUsers();
	List<User> getAllUsersWithRole();

	Userdata getInfoById(String id);
	int updateUserdata(Userdata userData);
	int deleteUserAndPassword(int record);

	int insertUserAndPassword(User role);
	int selectUser(String name);
	int insertIpinfo(Ip info);
	User selectByNamePWD(User role);
	int selectIpOneSecond(Ip info);
	int selectPhoneToday(String phone);
	int insertPhoneToday(String phone);
	int insertBlackIp(Ip info);
	int selectBlackIp(Ip info);
//	Integer deleteUserAndPassword(Integer valueOf);
}
