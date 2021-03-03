package com.myjunit.demo.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author weiqiang.zhu
 * @date 2021/03/03 10:42
 **/
public class ConnectionFactoryUtil {
    public static Connection GetRabbitConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(Config.UserName);
        factory.setPassword(Config.Password);
        factory.setVirtualHost(Config.VHost);
        factory.setHost(Config.Host);
        factory.setPort(Config.Port);
        Connection conn = null;
        try {
            conn = factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
