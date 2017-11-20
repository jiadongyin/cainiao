package cn.itcast.core.service;

import cn.itcast.core.bean.User;

public interface UserService {

	User findByName(String username);

}
