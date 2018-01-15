package cn.itcast.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.core.bean.entity.SysUser;
import cn.itcast.core.dao.SysUserMapper;
import cn.itcast.core.service.UserService;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public void modifyPass(SysUser currentUser) {
		sysUserMapper.update(currentUser);
	}

	@Override
	public SysUser selectByLoginName(String loginName) {
		return sysUserMapper.selectUserByLoginName(loginName);
	}

	

}
