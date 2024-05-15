package com.javaBasic.javaSE.genericT.demo11;

/**
 * @author: long
 * @create: 2022-10-29 11:57
 * @Description
 **/

public class Holder <T> {

    public Holder(T t){

    }


    private Integer age;
    private Integer sex;
    private Integer high;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }
}
