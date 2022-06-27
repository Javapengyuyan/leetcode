package com.designPatterns.factory.simpleFactory;

/**
 * @author: long
 * @create: 2022-06-27 10:01
 * @Description
 **/

public class SimpleFactoryDemo {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Operation operator = simpleFactory.createOperator("+");
        operator.setA(5.0);
        operator.setB(6.0);
        Double aDouble = operator.operator();
        System.out.println(aDouble);
    }

}
