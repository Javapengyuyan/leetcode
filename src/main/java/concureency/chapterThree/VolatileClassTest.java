package Concureency.ChapterThree;

import java.math.BigInteger;

public class VolatileClassTest {

    private final BigInteger lastNumber;

    public VolatileClassTest(BigInteger lastNumber) {
        this.lastNumber = lastNumber;
    }
}
