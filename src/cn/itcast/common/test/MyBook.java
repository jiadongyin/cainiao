package cn.itcast.common.test;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {

	@Before(value = "execution(* cn.itcast.common.test.Book.*(..))")
	public void stronger(){
		System.out.println("我是增强类。。。。。。stonger。。。。。。。");
	}
	
}
