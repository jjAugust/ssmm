package org.zt.ssmm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zt.ssmm.core.Uploadpic;
import org.zt.ssmm.dao.UserMapper;

@Service("picService")
public class PicServiceImpl implements PicService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public int insertUploadPic(Uploadpic info)
	{
		return userMapper.insertUploadPic(info);
	}

	@Override
	public Uploadpic SelectUploadPi2c(String info) {
		// TODO Auto-generated method stub
		return null;
	}
}
