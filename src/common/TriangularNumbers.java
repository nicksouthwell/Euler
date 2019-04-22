package common;

import java.math.BigInteger;
import java.util.Iterator;

public class TriangularNumbers implements Iterable<BigInteger> {
    @Override
    public Iterator<BigInteger> iterator() {
        return new Iterator<BigInteger>() {
            BigInteger value = BigInteger.ZERO;
            BigInteger next = BigInteger.ONE;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public BigInteger next() {
                value = value.add(next);
                next = next.add(BigInteger.ONE);
                return value;
            }
        };
    }
}
