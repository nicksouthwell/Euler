package common;

import java.math.BigInteger;

public final class BigIntegerUtils {
    public static BigInteger factorial(int n) {
        BigInteger factorial = BigInteger.ONE;
        while (n > 1) {
            factorial = factorial.multiply(BigInteger.valueOf(n));
            n--;
        }
        return factorial;
    }
}
