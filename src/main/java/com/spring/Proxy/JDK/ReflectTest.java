package com.spring.Proxy.JDK;

public class ReflectTest {

    public static void main(String[] args) {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles",true);
        Fruit fruit = (Fruit) DynamicAgent.agent(Fruit.class,new Apple());
        fruit.show();

    }

}
