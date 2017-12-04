package cn.itcast.core.dao;

import java.util.List;

import cn.itcast.core.bean.Permission;
import cn.itcast.core.bean.Role;
import cn.itcast.core.bean.User;

public interface UserDao {

	User findByName(String username);

	Role fingRole(int user_id);

	List<Permission> findPermission(Role role);

	void modifyPass(User currentUser);

}
