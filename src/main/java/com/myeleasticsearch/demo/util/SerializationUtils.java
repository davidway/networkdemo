package com.myeleasticsearch.demo.util;


import com.myeleasticsearch.demo.domain.Actor;

import java.io.*;


/**
 * 序列化工具类
 * 
 */
public class SerializationUtils {

    /**
     * 序列化对象
     * 
     * @param obj 对象
     * @return 序列化后的字节数组
     * @throws IOException
     */
    public static byte[] serialize(Object obj) throws IOException {
        if (null == obj) {
            return null;
		}

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
		out.writeObject(obj);
		return byteArrayOutputStream.toByteArray();

    }

    /**
     * 反序列化
     * 
     * @param bytes 对象序列化后的字节数组
     * @return 反序列化后的对象
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        if (null == bytes) {
            return null;
        }

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		ObjectInputStream in = new ObjectInputStream(byteArrayInputStream);
		return in.readObject();
    }

    /**
     * 反序列化成指定类型的对象
     * 
     * @param bytes 对象序列化后的字节数组
     * @param c 反序列化后的对象类型
     * @return 指定类型的对象
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> T deserialize(byte[] bytes, Class<T> c) throws ClassNotFoundException, IOException {
        return c.cast(deserialize(bytes));
    }

    public static void main(String[] args) {
        try {
        	Actor a = new Actor();
        	a.setAge(10);
        	a.setName("aaa");
            byte[] bytes = serialize(a);
            
            Actor a2 = deserialize(bytes, Actor.class);
            System.out.println(a2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}