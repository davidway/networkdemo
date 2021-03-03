package com.myjunit.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class MapDemo {
	public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(30);
        //最大空闲连接数
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config, "localhost", 6379,5000,"Dashuju.redis");
        Jedis conn = jedisPool.getResource();
        conn.select(15);

        // 创建一个hashmap
        conn.hset("hehe", "ww", "asd");
        conn.hset("hehe", "tencent", "liangbo");
        conn.hset("hehe", "baidu", "liyan");
        conn.hset("hehe", "ali", "mayun");
        // 读取hashmap
        System.out.println(conn.hget("hehe", "ww"));
        // 读取map的长度
        System.out.println(conn.hlen("hehe"));
        // 删除map
        conn.hdel("hehe", "tencent");
        // 遍历key
        System.out.println(conn.hkeys("hehe"));
        // 遍历value
        System.out.println(conn.hvals("hehe"));
        // 遍历map
        System.out.println(conn.hgetAll("hehe"));
        
        conn.close();
	}
}
