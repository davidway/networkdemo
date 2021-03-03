package com.myjunit.demo.redis.spring;

import com.myjunit.demo.domain.Users;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringdataRedisApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 添加一个字符串
     */
    @Test
    public void testSet() {
        this.redisTemplate.opsForValue().set("key", "我想要学好springboot");
    }

    /**
     * 获取一个字符串
     */
    @Test
    public void testGet() {
        String value = (String) this.redisTemplate.opsForValue().get("key");
        System.out.println(value);
    }

    /**
     * 添加 Users 对象
     */
    @Test
    public void testSetUsers() {
        // 该实体类要实现序列号接口的
        Users users = new Users(1, "张飒飒", 24);
        // 实体类重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        // 将实体类序列话后存储到redis中
        this.redisTemplate.opsForValue().set("users", users);
    }

    /**
     * 获取 Users 对象
     */
    @Test
    public void testGetUsers() {
        // 重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Users users = (Users) this.redisTemplate.opsForValue().get("users");
        System.out.println("users: " + users);
    }

    /**
     * 基于 JSON 格式存 Users 对象
     */
    @Test
    public void testSetUsersUseJSON() {
        // 创建实体类对象
        Users users = new Users(1, "张飒飒", 24);
        // 将指定的实体类转换为json格式
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        // 将转换为json格式的实体类存储到redis中
        this.redisTemplate.opsForValue().set("users_json", users);
    }

    /**
     * 基于 JSON 格式取 Users 对象
     */
    @Test
    public void testGetUseJSON() {
        // 反序列化，将指定的实体类以json格式进行反序列化
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        Users users = (Users) this.redisTemplate.opsForValue().get("users_json");
        System.out.println("users_json: " + users);
    }

}