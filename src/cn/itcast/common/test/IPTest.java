package cn.itcast.common.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class IPTest {

	@Test
	public void Demo(){
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
			System.out.println(date);
           InetAddress address = InetAddress.getLocalHost();//获取的是本地主机名和IP地址
           String hostAddress = address.getHostAddress();//IP地址
           System.out.println("address:"+address);
           System.out.println("ip:"+hostAddress);
           
           //获取的是该网站的ip地址，比如我们所有的请求都通过nginx的，所以这里获取到的其实是nginx服务器的IP地 
           InetAddress address1 = InetAddress.getByName("www.baidu.com");
           String hostAddress1 = address1.getHostAddress();//124.237.121.122 
           System.out.println("address:"+address1);
           System.out.println("ip:"+hostAddress1);
           
           //根据主机名返回其可能的所有InetAddress对象
           InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com"); 
           for(InetAddress addr:addresses){ 
	           System.out.println(addr);//www.baidu.com/14.215.177.38 
           } 
         } catch (UnknownHostException e) { 
              e.printStackTrace();
       } 
	}
}
