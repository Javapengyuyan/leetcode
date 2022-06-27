package com.designPatterns.factory.simpleFactory;

import lombok.Data;

/**
 * @author: long
 * @create: 2022-06-27 09:41
 * @Description
 **/
@Data
public class Operation {

    private Double a;

    private Double b;

    public Double operator(){
        return 0.0;
    }
}
