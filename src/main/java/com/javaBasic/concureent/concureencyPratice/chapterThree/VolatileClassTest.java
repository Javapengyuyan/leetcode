package com.javaBasic.concureent.concureencyPratice.chapterThree;

import java.math.BigInteger;

public class VolatileClassTest {

    private final BigInteger lastNumber;

    public VolatileClassTest(BigInteger lastNumber) {
        this.lastNumber = lastNumber;
    }
}
