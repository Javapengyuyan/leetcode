package com.javaBasic.javaSE.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectFreemworkTest {

    public static void main(String[] args) throws Exception {

        /*Person person = new Person();
        person.eat();
        通过创建实现的
        Student student = new Student();
        student.sleep();*/

        /**
         * 前提：不改变该类的任何代码，可以创建任意类的对象，可以执行该方法
         * 步骤：
         * 1、将需要创建对象的全类名和需要执行的方法定义在配置文件。
         * 2、在程序中加载读取配置文件
         * 3、使用反射技术来加载类进内存
         * 4、创建对象
         * 5、调用方法
         */
        Properties properties = new Properties();
        //todo 理解
        //1.2 获取class目录下配置文件
        ClassLoader classLoader = ReflectFreemworkTest.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");
        properties.load(inputStream);

        //2、获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        //3、加载该类进内存
        Class cls = Class.forName(className);
        //4、创建对象
        Object obj = cls.newInstance();
        //5、获取方法对象
        Method method = cls.getMethod(methodName);
        //执行方法
        method.invoke(obj);


    }

}
