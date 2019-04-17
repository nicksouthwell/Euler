package common;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class PrimeFactors implements Iterable<Integer> {
    public Map<Integer, Integer> _factors = new TreeMap<>();

    public static PrimeFactors of(int i) {
        return of(BigInteger.valueOf(i));
    }

    public static PrimeFactors of(BigInteger i) {
        PrimeFactors factors = new PrimeFactors();
        for (BigInteger unfactored = i; !unfactored.equals(BigInteger.ONE); ) {
            for (BigInteger prime : new PrimeNumbers()) {
                //
            }
        }
        return factors;
    }
    public void merge(PrimeFactors other) {

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
    }
}
