package com.javaBasic.javaSE.copy;

import common.Age;
import common.Person;

/**
 * @author: long
 * @create: 2021-12-30 22:35
 * @Description 深拷贝和浅拷贝理解
 **/

public class CopyConstructor {

    /**
     * 数据类型分为：基本数据类型、引用数据类型（如：数组、类的对象等）
     * 浅拷贝：拷贝了基本数据类型和引用数据类型地址，因此改变原来对象后，拷贝对象的
     *         基本数据类型不变，引用数据类型会变
     * 深拷贝：改变源数据，拷贝数据不会改变。
     *       在浅拷贝的基础上重写clone方法，并在引用数据类型没层都重写clone方法，就能实现深拷贝。
     *
     * @param args
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        //浅拷贝
        Age age = new Age(30);
        Person person = new Person(age,"主体",1);
        Person person2 = new Person(person);
        System.out.println("p1的age:"+person);
        //System.out.println("p1的name:"+person.getName());
        System.out.println("p2的age:"+person2);
        //System.out.println("p2的name:"+person2.getName());
        person.setName("修改主体名字");
        person.setNum(2);
        age.setAge(10);
        System.out.println("p1的age:"+person);

        System.out.println("p2的age:"+person2);

        System.out.println("-------------------------------------------");
        //深拷贝
        Student student = new Student();
        student.setAge(age);
        student.setName("原来name");
        student.setLength(1);
        Student student2 = (Student) student.clone();
        System.out.println(student);
        System.out.println(student2);
        age.setAge(2);
        student.setName("修改后name");
        student.setLength(2);
        System.out.println(student);
        System.out.println(student2);


    }

}
