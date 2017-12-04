package cn.itcast.core.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.utils.MD5Utils;
import cn.itcast.common.utils.StringUtils;
import cn.itcast.core.bean.User;
import cn.itcast.core.service.UserService;

/**
 * 登陆控制
 * @author 尹佳栋
 *
 */
@Controller
@RequestMapping("/user")
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	// 依赖注入
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request){
		//获取用户输入的验证码
		String valicode = request.getParameter("valicode");
	    //从session获取验证码
	    String verCode = (String) request.getSession().getAttribute("verCode");
	    //清空session里面的验证码
	    request.getSession().removeAttribute("verCode");
	    
	    if(StringUtils.isBlank(valicode) || !valicode.equalsIgnoreCase(verCode)){
			request.setAttribute("msg", "验证码输入错误!");
			logger.debug("验证码错误，登陆失败！");
			return "login";
		}else{
			//使用shiro提供的方式进行权限认证
			//获得当前用户对象，现在状态为“未认证”
			Subject subject = SecurityUtils.getSubject();
			String username = user.getUser_name();
			String password = user.getPassword();
			password = MD5Utils.md5(password);
			AuthenticationToken token = new UsernamePasswordToken(username,password);
			try{
				subject.login(token);//调用安全管理器，安全管理器调用Realm
				User loginUser = (User) subject.getPrincipal();
				subject.getSession().setAttribute("currentUser",loginUser.getUser_name());
			}catch (UnknownAccountException e) {
				e.printStackTrace();
				//用户名不存在，跳转到登录页面
				request.setAttribute("msg", "用户名不存在!");
				return "login";
			}catch (IncorrectCredentialsException e) {
				// 密码错误，跳转到登录页面
				e.printStackTrace();
				request.setAttribute("msg", "密码错误!");
				return "login";
			}
			return "redirect:/index.html";
		}

	}
	
//	@RequestMapping("/logout")
//	public String logout(HttpServletRequest request){
//		Subject currentUser = SecurityUtils.getSubject();
//		currentUser.logout();
//		request.getSession().removeAttribute("loginUser");// 将session失效
//		return "login";
//	}
	
	@RequestMapping("/modifyPass")
	public String modifyPass(HttpServletRequest request,String oldPass,String newPass,String confirmPass){
		 User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
		 oldPass = MD5Utils.md5(oldPass);
		 newPass = MD5Utils.md5(newPass);
		 confirmPass = MD5Utils.md5(confirmPass);
		if(!oldPass.equals(currentUser.getPassword())){
			request.setAttribute("msg", "原始密码错误!");
			return "modifyPass";
		}
		if(!newPass.equals(confirmPass)){
			request.setAttribute("msg", "确认密码错误!");
			return "modifyPass";
		}
		currentUser.setPassword(newPass);
		userService.modifyPass(currentUser);
		return "success";
	}
	
}
