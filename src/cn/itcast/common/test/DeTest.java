package cn.itcast.common.test;


import org.junit.Test;

import cn.itcast.common.utils.VerifyCodeUtils;


public class DeTest {

	@Test
	public void Demo() throws Exception{
		String generateVerifyCode = VerifyCodeUtils.generateVerifyCode(5);
		System.out.println(generateVerifyCode);
		
		
	}
}
