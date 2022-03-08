package com.javaBasic.javaSE.genericT.demo9;

/**
 * @author: long
 * @create: 2021-12-28 15:30
 * @Description
 **/

public class Erasure<T extends Number> {

    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public <T extends Number> T getValue(T value){
        return value;
    }


}
