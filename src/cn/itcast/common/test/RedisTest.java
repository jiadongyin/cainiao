package cn.itcast.common.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest {

	@Test
	public void connect(){
		//连接到本地redis服务
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis.ping());
		
	}
	
	@Test
	public void StringTest(){
		Jedis jedis = new Jedis("localhost");
		
		//设置redis字符串数据
		jedis.set("kakaxi", "旗木卡卡西");
		System.out.println("redis储存的字符串为："+jedis.get("kakaxi"));
	}
	
	@Test
	public void ListTest(){
		Jedis jedis = new Jedis("localhost");
		
		//设置list数据
		jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (String string : list) {
			System.out.println(string);
		}
	}
	
	@Test
	public void RedisKeyTest(){
		Jedis jedis = new Jedis("localhost");
		
		Set<String> keys = jedis.keys("*"); 
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){   
            String k = it.next();   
            System.out.println(k);   
        }
	}
}
