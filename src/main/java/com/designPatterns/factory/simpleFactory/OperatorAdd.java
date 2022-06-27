package com.designPatterns.factory.simpleFactory;

/**
 * @author: long
 * @create: 2022-06-27 09:35
 * @Description
 **/

public class OperatorAdd extends Operation {

    @Override
    public void setA(Double a) {
        super.setA(a);
    }

    @Override
    public void setB(Double b) {
        super.setB(b);
    }

    @Override
    public Double operator() {
        Double result = super.getA()+super.getB();
        return result;
    }
}
