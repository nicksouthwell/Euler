package problems;

import common.PrimeNumbers;

import java.math.BigInteger;

public class Problem7 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 5 - 10,001st prime\n" +
                "--------------------------\n" +
                "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.\n" +
                "\n" +
                "What is the 10,001st prime number?";
    }

    @Override
    public BigInteger solution() {
        int count = 10001;
        for (BigInteger prime : new PrimeNumbers()) {
            if (--count == 0)
                return prime;
        }
        return null;
    }
}
