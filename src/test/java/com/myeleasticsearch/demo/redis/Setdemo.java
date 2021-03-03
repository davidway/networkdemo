package com.myeleasticsearch.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 集合set的操作演示
 * @author shenzhanwang
 *
 */
public class Setdemo {
	public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(30);
        //最大空闲连接数
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config, "localhost", 6379,5000,"Dashuju.redis");
        Jedis conn = jedisPool.getResource();
        conn.select(15);

        conn.select(15);
        // 创建一个集合
        conn.sadd("xiaomi", "leijun","liuqi","xiaobai");
        // 移除集合元素
        conn.srem("xiaomi", "leijun");
        // 遍历集合元素
        System.out.println(conn.smembers("xiaomi"));
        
        conn.sadd("baidu", "liyanhong","zhangge","liuqi");
        // 返回差集
        System.out.println(conn.sdiff("xiaomi", "baidu"));
        // 返回交集
        System.out.println(conn.sinter("xiaomi", "baidu"));
        // 返回并集
        System.out.println(conn.sunion("xiaomi", "baidu"));
        conn.close();
	}
}
