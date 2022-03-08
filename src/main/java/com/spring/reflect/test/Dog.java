package com.spring.reflect.test;

import lombok.Data;
import com.spring.reflect.My;

@Data
@My
public class Dog extends Animal {

    private String color;

    public String name;

    @My
    private int age;

    public Dog(String color){
        this.color = color;
    }

    @My
    public void eat(String foot){
        System.out.println("I am eating "+foot);
    }

    @My
    public void eat(){
        System.out.println("I am eating");
    }
}
