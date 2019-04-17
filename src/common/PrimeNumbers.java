package common;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimeNumbers implements Iterable<BigInteger> {
    public static List<BigInteger> primes = new ArrayList<>();

    @Override
    public Iterator<BigInteger> iterator() {
        return new Iterator<BigInteger>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public BigInteger next() {
                if (index >= primes.size()) {
                    BigInteger lastPrime = (primes.size() > 0) ? primes.get(primes.size() - 1) : BigInteger.ONE;
                    primes.add(findNextPrimeAfter(lastPrime));
                }
                return primes.get(index++);
            }

            private BigInteger findNextPrimeAfter(BigInteger lastPrime) {
                BigInteger candidate = lastPrime;
                do {
                    candidate = candidate.add(BigInteger.ONE);
                } while (!isPrime(candidate));
                return candidate;
            }

            private boolean isPrime(BigInteger candidate) {
                for (BigInteger prime : primes) {
                    if (prime.multiply(prime).compareTo(candidate) > 0) {
                        break;
                    }
                    if (candidate.remainder(prime).equals(BigInteger.ZERO)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }
}
