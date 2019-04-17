package common;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeNumbersTest {
    @Test
    void iterate() {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        Iterator<BigInteger> iter = primeNumbers.iterator();

        assertEquals(iter.hasNext(), true);
        assertEquals(iter.next(), new BigInteger("2"));
        assertEquals(iter.next(), new BigInteger("3"));
        assertEquals(iter.next(), new BigInteger("5"));
        assertEquals(iter.next(), new BigInteger("7"));
        assertEquals(iter.next(), new BigInteger("11"));
        assertEquals(iter.next(), new BigInteger("13"));
        assertEquals(iter.next(), new BigInteger("17"));
        assertEquals(iter.next(), new BigInteger("19"));
        assertEquals(iter.next(), new BigInteger("23"));
    }
}