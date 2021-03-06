package problems;

import common.PrimeFactors;
import common.TriangularNumbers;

import java.math.BigInteger;
import java.util.Map;

public class Problem12 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 12 - Highly divisible triangular number\n" +
                "-----------------------------------------------\n" +
                "The sequence of triangle numbers is generated by adding the natural numbers.\n" +
                "So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:\n" +
                "\t\t\t1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...\n" +
                "\n" +
                "Let us list the factors of the first seven triangle numbers:\n" +
                "\t 1: 1\n" +
                "\t 3: 1,3\n" +
                "\t 6: 1,2,3,6\n" +
                "\t10: 1,2,5,10\n" +
                "\t15: 1,3,5,15\n" +
                "\t21: 1,3,7,21\n" +
                "\t28: 1,2,4,7,14,28\n" +
                "\n" +
                "We can see that 28 is the first triangle number to have over five divisors.\n" +
                "\n" +
                "What is the value of the first triangle number to have over five hundred divisors?";
    }

    @Override
    public BigInteger solution() {
        BigInteger solution = BigInteger.ONE;
        for (BigInteger tri : new TriangularNumbers()) {
            if (numberOfDivisors(tri) > 500)
                return tri;
        }
        return solution;
    }

    int numberOfDivisors(BigInteger tri) {
        PrimeFactors factors = PrimeFactors.of(tri);
        int divisors = 1;
        for (Map.Entry<Integer, Integer> factor : factors._factors.entrySet()) {
            divisors += divisors * factor.getValue();
        }
//        System.out.println("Prime factors of " + tri + " are " + factors._factors + " divisor count: " + divisors);

        return divisors;
    }
}
