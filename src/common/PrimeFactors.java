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
        Iterator<BigInteger> primes = new PrimeNumbers().iterator();
        for (BigInteger unfactored = i; !unfactored.equals(BigInteger.ONE); ) {
            BigInteger prime = primes.next();
            while (unfactored.remainder(prime).equals(BigInteger.ZERO)) {
                unfactored = unfactored.divide(prime);
                factors.add(prime);
            }
        }
        return factors;
    }

    public void merge(PrimeFactors other) {

    }

    private void add(BigInteger prime) {
        Integer intValue = prime.intValue();
        Integer count = _factors.get(intValue);
        if (count != null)
            _factors.put(intValue, count + 1);
        else
            _factors.put(intValue, 1);
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
