package com.shenge.study.week01;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/10/19
 * @time : 下午8:33
 * @desc : Hello.class 类加载器
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            String name = "Hello";
            String path = HelloClassLoader.class.getResource("").getPath() + "Hello.xlass";
            System.out.println("path");
            Object helloObject = new HelloClassLoader().findClass(name, path).newInstance();
            Method method = helloObject.getClass().getMethod("hello");
            method.invoke(helloObject);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected Class<?> findClass(String name, String path) throws ClassNotFoundException {
        byte[] helloBytes = getHelloBytes(path);
        return defineClass(name, helloBytes, 0, helloBytes.length);
    }

    private byte[] getHelloBytes(String path) {
        File file = new File(path);
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            int code;
            while ((code = fis.read()) != -1) {
                baos.write(255 - code);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
