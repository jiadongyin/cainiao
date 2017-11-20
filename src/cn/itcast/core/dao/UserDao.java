package cn.itcast.core.dao;

import cn.itcast.core.bean.User;

public interface UserDao {

	User findByName(String username);

	String fingRole(int user_id);

	String findPermission(int user_id);

}
