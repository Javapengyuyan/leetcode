package com.designPatterns.factory.simpleFactory;

/**
 * @author: long
 * @create: 2022-06-27 10:51
 * @Description
 **/

public class OperatorSubtraction extends Operation{

    @Override
    public void setB(Double b) {
        super.setB(b);
    }

    @Override
    public void setA(Double a) {
        super.setA(a);
    }

    @Override
    public Double operator() {
        return super.getA()-super.getB();
    }
}
