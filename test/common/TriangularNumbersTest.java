package common;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangularNumbersTest {
    @Test
    void iterate() {
        TriangularNumbers triangularNumbers = new TriangularNumbers();
        Iterator<BigInteger> iter = triangularNumbers.iterator();

        assertEquals(iter.hasNext(), true);
        assertEquals(iter.next(), new BigInteger("1"));
        assertEquals(iter.next(), new BigInteger("3"));
        assertEquals(iter.next(), new BigInteger("6"));
        assertEquals(iter.next(), new BigInteger("10"));
        assertEquals(iter.next(), new BigInteger("15"));
        assertEquals(iter.next(), new BigInteger("21"));
        assertEquals(iter.next(), new BigInteger("28"));
        assertEquals(iter.next(), new BigInteger("36"));
        assertEquals(iter.next(), new BigInteger("45"));
    }
}