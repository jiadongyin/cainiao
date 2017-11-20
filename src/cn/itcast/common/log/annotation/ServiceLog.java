package cn.itcast.common.log.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;
/**
 * 日志注解类 拦截service 
 * @title Log.java
 * @descreption TODO 
 * @author DK
 * @date 2017年3月23日 下午3:22:38
 * @since jdk1.8.0_102
 * @version V2.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Component
public @interface ServiceLog {

	/** 要执行的操作类型比如：add操作 **/  
     public String operationType() default "";  
      
     /** 要执行的具体操作比如：添加用户 **/  
     public String operationName() default "";
     
     String description() default "";//描述
}
