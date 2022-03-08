package com.javaBasic.javaSE.genericT;

/**
 * @author: long
 * @create: 2021-12-12 17:57
 * @Description
 **/

    //泛型类派生子类，子类也是泛型类，子类泛型标识要和父类一致
    //其实是父类要和子类一致，方便扩展
public class ChildFirst<T> extends Parent<T> {

    @Override
    public T getValue() {
        return super.getValue();
    }
}
