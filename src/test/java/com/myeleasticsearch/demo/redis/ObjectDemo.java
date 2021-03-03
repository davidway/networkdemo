package com.myeleasticsearch.demo.redis;


import com.myeleasticsearch.demo.domain.Actor;
import com.myeleasticsearch.demo.util.SerializationUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class ObjectDemo {
	public static void main(String[] args) throws Exception {
		JedisPoolConfig config = new JedisPoolConfig();
		//最大连接数
		config.setMaxTotal(30);
		//最大空闲连接数
		config.setMaxIdle(10);

		JedisPool jedisPool = new JedisPool(config, "localhost", 6379,5000,"Dashuju.redis");
		Jedis conn = jedisPool.getResource();
		conn.select(15);

		Actor a = new Actor();
    	a.setAge(22);
    	a.setName("aaa");
    	
        byte[] bytes = SerializationUtils.serialize(a);
	    conn.set("actor".getBytes(), bytes);
	    
	    byte[] actor = conn.get("actor".getBytes());
	    
	    Actor r = SerializationUtils.deserialize(actor, Actor.class);
	    
	    System.out.println(r);
	    
	    conn.close();
	}
	
}
