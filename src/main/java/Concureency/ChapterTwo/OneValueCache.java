package Concureency.ChapterTwo;

import java.math.BigInteger;
import java.util.Arrays;

public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactor;

    public OneValueCache(BigInteger i,BigInteger[] factors) {
        lastNumber = i;
        lastFactor = Arrays.copyOf(factors,factors.length);
    }

    public BigInteger[] getLastFactor(BigInteger i) {
        if (lastNumber == null || lastNumber.equals(i)){
            return null;
        }else {
            return Arrays.copyOf(lastFactor,lastFactor.length);
        }
    }
}
