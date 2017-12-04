/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.itcast.common.shiro;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.itcast.core.bean.Permission;
import cn.itcast.core.bean.Role;
import cn.itcast.core.bean.User;
import cn.itcast.core.dao.UserDao;

/**
 * 系统安全认证实现类
 * @author jeeplus
 * @version 2014-7-5
 */
@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {
	 
	private static Logger logger = LoggerFactory.getLogger(SystemAuthorizingRealm.class);
	// 注入dao，访问数据库
	@Autowired
	private UserDao userDao;
	@Autowired
	HttpServletRequest request;
	@Autowired
    private RedisTemplate<Object, Object> redisTemplate;
	
	/**认证方法
	 * 认证回调函数, 登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		// 禁用非POST方式请求
		if (!request.getMethod().equalsIgnoreCase("POST") ) {
			throw new AuthenticationException("msg:Not allow request by GET");
		}
		UsernamePasswordToken myToken = (UsernamePasswordToken) authcToken;
		String username = myToken.getUsername();
		char[] password = myToken.getPassword();
		// 根据用户名查询数据库中的密码，将密码交给安全管理器，由安全管理器对象负责比较数据库中的密码和页面传递的密码是否一致
		User user = userDao.findByName(username);
		if(user != null){
			// 参数一：签名对象，认证通过后，可以在程序的任意位置获取当前放入的对象
			// 参数二：数据库中查询出的密码
			// 参数三：当前realm的类名
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(), getName());
			return info;
		}
		return null;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//授权信息对象
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		//当前登录用户
		User currentUser = (User) principals.getPrimaryPrincipal();
		//按照获取的用户名，从数据中获取用户角色，添加用户角色  
		Role role = userDao.fingRole(currentUser.getUser_id());
        simpleAuthorInfo.addRole(role.getRole_name());  
        logger.debug("角色信息: {}", role.getRole_name().toString());
        //根据角色从数据库中获取权限
        List<Permission> permissions = userDao.findPermission(role);
        for (Permission permission2 : permissions) {
        	simpleAuthorInfo.addStringPermission(permission2.getPermission_name()); 
        	logger.debug("权限信息: {}", permission2.getPermission_name());
		}
       return simpleAuthorInfo;   
	}
	
	 @Override
    protected void doClearCache(PrincipalCollection principals) {
        redisTemplate.delete("shiro-cache-" + principals.getPrimaryPrincipal().toString());
    }

    @Override
    protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        logger.debug("clearCachedAuthorizationInfo");
    }
	
}
