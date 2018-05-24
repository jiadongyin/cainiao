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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.common.utils.MD5Utils;
import cn.itcast.common.utils.StringUtils;
import cn.itcast.core.bean.entity.SysUser;
import cn.itcast.core.service.UserService;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import nl.bitwalker.useragentutils.Version;

/**
 * 登陆控制
 * @author 尹佳栋
 *
 */
@Controller
@RequestMapping("/user")
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * 依赖注入
	 */
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(SysUser user,HttpServletRequest request){
		
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));  
        //浏览器  
        Browser browser = userAgent.getBrowser();  
        System.out.println("类型："+browser.getBrowserType()+"\n名称："+browser.getName()+"\n厂商："+browser.getManufacturer()+  
                "\n产品系列："+browser.getGroup()+"\n引擎："+browser.getRenderingEngine());  
        //浏览器版本  
        Version version = userAgent.getBrowserVersion();  
        System.out.println("========================");  
        System.out.println("主版本："+version.getMajorVersion()+ "\n小版本："+version.getMinorVersion()+  "\n完整版本："+version.getVersion());  
        //操作系统  
        System.out.println("========================");  
        OperatingSystem os = userAgent.getOperatingSystem();  
        System.out.println("名称："+os.getName()+"\n设备类型："+os.getDeviceType()+  "\n产品系列："+os.getGroup()+  "\n生成厂商："+os.getManufacturer());  
		
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
			String username = user.getLoginName();
			String password = user.getPassword();
			password = MD5Utils.md5(password);
			AuthenticationToken token = new UsernamePasswordToken(username,password);
			try{
				//调用安全管理器，安全管理器调用Realm
				subject.login(token);
				SysUser loginUser = (SysUser) subject.getPrincipal();
				subject.getSession().setAttribute("currentUser",loginUser.getLoginName());
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
	
	
	@RequestMapping(value="userInfo")
	public String userInfo(Model model){
		SysUser currentUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
		SysUser user = userService.selectByLoginName(currentUser.getLoginName());
		model.addAttribute("currentUser", user);
		return "info";
		
	}
	
	@RequestMapping("/modifyPass")
	public String modifyPass(HttpServletRequest request,String oldPass,String newPass,String confirmPass){
		 SysUser currentUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
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
