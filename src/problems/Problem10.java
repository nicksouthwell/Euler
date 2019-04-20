package problems;

import common.PrimeNumbers;

import java.math.BigInteger;

public class Problem10 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 10 - Summation of primes\n" +
                "--------------------------------\n" +
                "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.\n" +
                "\n" +
                "Find the sum of all the primes below two million.";
    }

    @Override
    public BigInteger solution() {
        BigInteger sumOfPrimes = BigInteger.ZERO;
        BigInteger maxPrime = BigInteger.valueOf(2000000);
        for (BigInteger prime : new PrimeNumbers()) {
            if (prime.compareTo(maxPrime) > 0)
                break;
            sumOfPrimes = sumOfPrimes.add(prime);
        }
        return sumOfPrimes;
    }
}
