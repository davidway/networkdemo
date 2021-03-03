package com.myjunit.demo.rabbitmq;

/**
 * @author weiqiang.zhu
 * @date 2021/03/03 10:42
 **/

public class Config {
    public static String UserName="guest";
    public static String VHost="/";
    public static String Host="127.0.0.1";
    public static int Port=5672;

    public static String Password="guest" ;
    public  static String QueueName="testQueue";

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public static String getVHost() {
        return VHost;
    }

    public static void setVHost(String VHost) {
        Config.VHost = VHost;
    }

    public static String getHost() {
        return Host;
    }

    public static void setHost(String host) {
        Host = host;
    }

    public static int getPort() {
        return Port;
    }

    public static void setPort(int port) {
        Port = port;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String password) {
        Password = password;
    }

    public String getQueueName() {
        return QueueName;
    }

    public void setQueueName(String queueName) {
        QueueName = queueName;
    }
}
