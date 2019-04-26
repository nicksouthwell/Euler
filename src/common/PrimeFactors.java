package common;

import java.math.BigInteger;
import java.util.*;

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

    public List<Integer> properDivisors() {
        ArrayList<Integer> divisors = new ArrayList<>();
        divisors.add(1);

        for (Map.Entry<Integer, Integer> factor : _factors.entrySet()) {
            divisors.addAll(factorMultiples(factor, divisors));
        }

        return divisors;
    }

    private List<Integer> factorMultiples(Map.Entry<Integer, Integer> factor, ArrayList<Integer> values) {
        ArrayList<Integer> multiples = new ArrayList<>();
        int multiplier = 1;
        for (int i = 1; i <= factor.getValue(); i++) {
            multiplier *= factor.getKey();
            multiples.addAll(multiplyList(values, multiplier));
        }
        return multiples;
    }

    private List<Integer> multiplyList(List<Integer> values, int multiplier) {
        ArrayList<Integer> multiples = new ArrayList<>();
        for (Integer value : values) {
            multiples.add(value * multiplier);
        }
        return multiples;
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
