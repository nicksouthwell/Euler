package problems;

import common.PrimeFactors;

import java.math.BigInteger;

public class Problem5 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 5 - Smallest Multiple\n" +
                "-----------------------------\n" +
                "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.\n" +
                "\n" +
                "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?";
    }

    @Override
    public BigInteger solution() {
        PrimeFactors factors = new PrimeFactors();
        for (int i = 2; i <= 20; i++) {
            factors.merge(PrimeFactors.of(i));
        }
        BigInteger solution = BigInteger.ONE;
        for (int i : factors) {
            solution = solution.multiply(BigInteger.valueOf(i));
        }
        return solution;
    }
}
