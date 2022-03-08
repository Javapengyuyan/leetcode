package com.javaBasic.javaSE.genericT.demo9;

/**
 * @author: long
 * @create: 2021-12-28 17:09
 * @Description
 **/

public class InfoImpl implements Info<Integer> {

    @Override
    public Integer info(Integer var) {
        return var;
    }
}
