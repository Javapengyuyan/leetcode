package com.javaBasic.javaSE.copy;

import common.Age;
import lombok.Data;

/**
 * @author: long
 * @create: 2021-12-30 23:24
 * @Description
 **/
@Data
public class Student implements Cloneable{

    private String name;

    private Age age;

    private int length;



    @Override
    public Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.age = (Age) student.getAge().clone();
        return student;
    }
}
