package cn.itcast.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.core.bean.User;
import cn.itcast.core.dao.UserDao;
import cn.itcast.core.service.UserService;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	// 定义dao属性
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findByName(String username) {
		
		return userDao.findByName(username);
	}

	@Override
	public void modifyPass(User currentUser) {
		userDao.modifyPass(currentUser);
	}

}
