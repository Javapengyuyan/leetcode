package com.designPatterns.factory.simpleFactory;

/**
 * @author: long
 * @create: 2022-06-27 09:28
 * @Description 简单工厂--增加类型要改代码
 **/

public class SimpleFactory {

    public Operation createOperator(String type) {
        switch (type){
            case "+":
                return new OperatorAdd();
            case "-":
                return new OperatorSubtraction();
            case "*":

                return null;
        }
        return null;
    }
}
