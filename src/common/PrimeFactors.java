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
        for (Map.Entry<Integer, Integer> countedPrime : other._factors.entrySet()) {
            Integer prime = countedPrime.getKey();
            Integer count = countedPrime.getValue();
            Integer existingCount = _factors.get(prime);
            Integer newCount = (existingCount != null ? Math.max(existingCount, count) : count);
            _factors.put(prime, newCount);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Iterator<Map.Entry<Integer, Integer>> primes = _factors.entrySet().iterator();
            private Integer prime = null;
            private Integer count = 0;

            @Override
            public boolean hasNext() {
                return (count != 0 || primes.hasNext());
            }

            @Override
            public Integer next() {
                if (count == 0) {
                    Map.Entry<Integer, Integer> primeEntry = primes.next();
                    prime = primeEntry.getKey();
                    count = primeEntry.getValue();
                }
                --count;
                return prime;
            }
        };
    }

    private void add(BigInteger prime) {
        Integer intValue = prime.intValue();
        Integer count = _factors.get(intValue);
        if (count != null)
            _factors.put(intValue, count + 1);
        else
            _factors.put(intValue, 1);
    }
}
