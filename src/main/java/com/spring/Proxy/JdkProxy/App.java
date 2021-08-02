package com.spring.Proxy.JdkProxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class App {

    public static void main(String[] args) {
        /*AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        System.out.println("userService instanceof UserServiceImpl ?"+
                (userService instanceof UserServiceImpl) );

        userService.find();*/

        Class<?>[] interfaces = new Class[]{UserService.class};
        byte[] bytes = ProxyGenerator.generateProxyClass("UserService", interfaces);
        File file = new File("/<path>/UserService.class");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
