package com.javaBasic.javaSE.genericT;

/**
 * @author: long
 * @create: 2021-12-12 14:57
 * @Description
 **/

public class Parent<E> {

    private E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
