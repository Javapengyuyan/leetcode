package com.javaBasic.javaSE.genericT.demo11;

import java.lang.reflect.Constructor;

/**
 * @author: long
 * @create: 2021-12-28 20:21
 * @Description
 **/

public class Test11 {

    public static void main(String[] args) throws Exception {
        //泛型和反射
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor();
        Person person = constructor.newInstance();


    }

}
