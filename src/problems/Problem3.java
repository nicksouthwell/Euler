package problems;

import common.PrimeNumbers;

import java.math.BigInteger;

public class Problem3 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 3 - Largest prime factor\n" +
                "--------------------------------\n" +
                "The prime factors of 13195 are 5, 7, 13 and 29.\n" +
                "\n" +
                "What is the largest prime factor of the number 600851475143?";
    }

    @Override
    public BigInteger solution() {
        BigInteger target = new BigInteger("600851475143");
        for (BigInteger prime : new PrimeNumbers()) {
            if (prime.multiply(prime).compareTo(target) > 0) {
                break;
            }
            if (target.remainder(prime).equals(BigInteger.ZERO)) {
                target = target.divide(prime);
            }
        }
        return target;
    }
}
