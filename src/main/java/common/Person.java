package common;

import lombok.Data;

/**
 * @author: long
 * @create: 2021-12-30 22:38
 * @Description
 **/

@Data
public class Person {

    private Age age;

    private String name;

    private int num;

    public Person(Age age,String name,int num){
        this.age = age;
        this.name = name;
        this.num = num;
    }

    public Person(Person person){
        this.name = person.name;
        this.age = person.age;
        this.num = person.num;
    }
}
