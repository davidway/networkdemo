package com.myjunit.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class SortedSetDemo {
	public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(30);
        //最大空闲连接数
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config, "localhost", 6379,5000,"Dashuju.redis");
        Jedis conn = jedisPool.getResource();
        conn.select(15);

        // 创建一个有序集合
        conn.zadd("sets",3 , "a");
        conn.zadd("sets",4 , "b");
        conn.zadd("sets",5 , "c");
        // 统计个数
        System.out.println(conn.zcard("sets"));
        // 给某个元素加分
        System.out.println(conn.zincrby("sets", 10, "a"));
        // 读取分值
        System.out.println(conn.zscore("sets", "a"));
        // 读取元素排名,最小的排名从0开始
        System.out.println(conn.zrank("sets", "a"));
        // 统计给定区间的分值数目
        System.out.println(conn.zcount("sets", 5, 13));
        // 移除某个元素
        conn.zrem("sets", "a");
        // 遍历有序集合
        System.out.println(conn.zrange("sets", 0, -1));
        conn.close();
	}
}
