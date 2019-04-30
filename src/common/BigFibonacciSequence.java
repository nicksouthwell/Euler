package common;

import java.math.BigInteger;
import java.util.Iterator;

public class BigFibonacciSequence implements Iterable<BigInteger> {

    @Override
    public Iterator<BigInteger> iterator() {
        return new Iterator<BigInteger>() {
            BigInteger a = BigInteger.ZERO;
            BigInteger b = BigInteger.ONE;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public BigInteger next() {
                BigInteger next = a.add(b);
                a = b;
                return b = next;
            }
        };
    }
}
