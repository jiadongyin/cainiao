package cn.itcast.common.log;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.itcast.common.log.annotation.ControllerLog;
import cn.itcast.common.log.annotation.ServiceLog;
import cn.itcast.common.utils.DateUtils;
import cn.itcast.core.bean.SystemLog;
import cn.itcast.core.bean.User;
import cn.itcast.core.service.SystemLogService;

/**
  * @author 小尹 
  * @E-mail: email
  * @version 创建时间：2017-110-9 下午
  * @desc 切点类 
  */
 
@Aspect
@Component
public class SystemLogAspect {
		
	//注入Service用于把日志保存数据库  
      @Resource 
      private SystemLogService systemLogService; 
      
      private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocal StartTime");
      
      private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);  
    
      //Controller层切点  
      @Pointcut("@annotation(cn.itcast.common.log.annotation.ControllerLog)")  
      public  void controllerAspect() {  
      }  
      
      //Service层切点  
      @Pointcut("@annotation(cn.itcast.common.log.annotation.ServiceLog)")   
       public  void serviceAspect() {  
      }  
      
      /** 
        * 前置通知 用于拦截Controller层记录用户的操作 
        * @param joinPoint 切点 
        */ 
       @Before("controllerAspect()")
       public void doBefore(JoinPoint joinPoint){
      	 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
	      	if (logger.isDebugEnabled()){
	      		//System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<执行controller前置通知<<<<<<<<<<<<<<<<<<<<<<<<");
				long beginTime = System.currentTimeMillis();//1、开始时间  
		        startTimeThreadLocal.set(beginTime);		//线程绑定变量（该数据只有当前请求的线程可见）  
		        logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS")
		        	.format(beginTime), request.getRequestURI());
			}
      }
       /** 
        * 后置通知 用于拦截Controller层记录用户的操作 
        * @param joinPoint 切点 
        */  
       @After("controllerAspect()")  
        public  void doAfter(JoinPoint joinPoint) {  
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
            // 打印JVM信息。
	   		if (logger.isDebugEnabled()){
	   			//System.out.println(">>>>>>>>>>>>>>>>>>>>controller后置通知开始>>>>>>>>>>>>>>>>>>>>"); 
	   			long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）  
	   			long endTime = System.currentTimeMillis(); 	//2、结束时间  
	   	        logger.debug("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
	   	        		new SimpleDateFormat("hh:mm:ss.SSS").format(endTime), DateUtils.formatDateTime(endTime - beginTime),
	   					request.getRequestURI(), Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024, 
	   					(Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024); 
	   		 }
	   		
	        //请求的IP 
	        String ip = getIpAddress(request);  
	        // 获取当前用户
	        	User user = (User) SecurityUtils.getSubject().getPrincipal();
	        String user_name = user.getUser_name();
	         try {
	             //*========控制台输出=========*//  
	        	 System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName()+"()"));  
	             System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));  
	             System.out.println("请求IP:" + ip);  
	             //*========数据库日志=========*//  
	             SystemLog log = new SystemLog(); 
	             log.setId(UUID.randomUUID().toString());
	             log.setDescription(getControllerMethodDescription(joinPoint));  
	             log.setMethod((joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName()+"()"));  
	             log.setLogType("1");  
	             log.setRequestIp(ip);  
	             log.setExceptioncode( null);  
	             log.setExceptionDetail( null);  
	             log.setParams(request.getParameterMap());  
	             log.setCreateBy(user_name); 
	             SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	 			 String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
	             log.setCreateDate(date);  
	             //保存数据库  
                 systemLogService.insert(log);  
                 //System.out.println("=====controller后置通知结束>>>>>>>>>>>>>>>>>>>");   
	        }  catch (Exception e) {  
	             //记录本地异常日志  
	        	// logger.error("==后置通知异常==");  
	             logger.error("异常信息:{}", e.getMessage());  
	        }  
        }
       
       /** 
        * 前置通知 用于拦截service层记录用户的操作 
        * @param joinPoint 切点 
        */ 
       @Before("serviceAspect()")  
       public void doServiceBefore(JoinPoint joinPoint){
       	 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
	       	if (logger.isDebugEnabled()){
	       		//System.out.println("***************************执行service前置通知***************************");
	   			long beginTime = System.currentTimeMillis();//1、开始时间  
	   	        startTimeThreadLocal.set(beginTime);		//线程绑定变量（该数据只有当前请求的线程可见）  
	   	        logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS")
	   	        	.format(beginTime), request.getRequestURI());
	   		}
       }
       /** 
        * 后置通知 用于拦截Service层记录用户的操作 
        * @param joinPoint 切点 
        */  
       @After("serviceAspect()")  
       public  void doServiceAfter(JoinPoint joinPoint) {  
       	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
       	// 打印JVM信息。
	   		if (logger.isDebugEnabled()){
	   		//	System.out.println("***************************service后置通知开始***************************"); 
	   			long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）  
	   			long endTime = System.currentTimeMillis(); 	//2、结束时间  
	   	        logger.debug("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
	   	        		new SimpleDateFormat("hh:mm:ss.SSS").format(endTime), DateUtils.formatDateTime(endTime - beginTime),
	   					request.getRequestURI(), Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024, 
	   					(Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024); 
	   		}
	         try {
	             //*========控制台输出=========*//  
	        	 System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName()+"()"));  
	             System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));   
	        }  catch (Exception e) {  
	             //记录本地异常日志  
	        	// logger.error("==后置通知异常==");  
	             logger.error("异常信息:{}", e.getMessage());  
	        }  
       }  
       
       
       
       /** 
        * 获取注解中对方法的描述信息 用于Controller层注解 
        * @param joinPoint 切点 
        * @return 方法描述 
        * @throws Exception 
        */  
        public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {  
           String targetName = joinPoint.getTarget().getClass().getName();  
           String methodName = joinPoint.getSignature().getName();  
           Object[] arguments = joinPoint.getArgs();  
           Class targetClass = Class.forName(targetName);  
           Method[] methods = targetClass.getMethods();  
           String description = "";  
            for (Method method : methods) {  
                if (method.getName().equals(methodName)) {  
                   Class[] clazzs = method.getParameterTypes();  
                    if (clazzs.length == arguments.length) {  
                   	 if(method.getAnnotation(ControllerLog.class).operationType() != null && !method.getAnnotation(ControllerLog.class).operationType().equals("")){
                   		 description = method.getAnnotation(ControllerLog.class).operationType()+":"+method.getAnnotation(ControllerLog.class).operationName();   
                   	 }else{
                   		 description = method.getAnnotation(ControllerLog.class).description();
                   	 }
                        break;  
                   } 
               }  
           }  
            return description;  
       }  
        
        /** 
         * 获取注解中对方法的描述信息 用于service层注解 
         * @param joinPoint 切点 
         * @return 方法描述 
         * @throws Exception 
         */  
         public  static String getServiceMthodDescription(JoinPoint joinPoint)  
                 throws Exception {  
        	 String targetName = joinPoint.getTarget().getClass().getName();  
             String methodName = joinPoint.getSignature().getName();  
             Object[] arguments = joinPoint.getArgs();  
             Class targetClass = Class.forName(targetName);  
             Method[] methods = targetClass.getMethods();  
             String description = "";  
              for (Method method : methods) {  
                  if (method.getName().equals(methodName)) {  
                     Class[] clazzs = method.getParameterTypes();  
                      if (clazzs.length == arguments.length) {  
                     	 if(method.getAnnotation(ServiceLog.class).operationType() != null && !method.getAnnotation(ServiceLog.class).operationType().equals("")){
                     		 description = method.getAnnotation(ServiceLog.class).operationType()+":"+method.getAnnotation(ServiceLog.class).operationName();   
                     	 }else{
                     		 description = method.getAnnotation(ServiceLog.class).description();
                     	 }
                          break;  
                     } 
                 }  
             }  
              return description;  
        }  
       
        /*
         * 
         */
       public String getIpAddress(HttpServletRequest request){
    	   String ip = request.getHeader("x-forwarded-for");
           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
               ip = request.getHeader("Proxy-Client-IP");
           }
           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
               ip = request.getHeader("WL-Proxy-Client-IP");
           }
           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
               ip = request.getRemoteAddr();
           }
           if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	       	 ip = request.getHeader("http_client_ip");  
	       }  
	       if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	       	 ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	       }  
	       if (ip != null && ip.indexOf(",") != -1) {  
	   		 ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();  
	   	   } 
           if("0:0:0:0:0:0:0:1".equals(ip)){
           	 ip="127.0.0.1";
           }
           return ip;
       }

}
