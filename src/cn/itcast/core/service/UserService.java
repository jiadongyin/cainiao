package cn.itcast.core.service;

import cn.itcast.core.bean.entity.SysUser;

public interface UserService {

	void modifyPass(SysUser currentUser);

	SysUser selectByLoginName(String loginName);

	

}
