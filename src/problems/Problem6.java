package problems;

import java.math.BigInteger;

public class Problem6 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 6 - Sum square difference\n" +
                "---------------------------------\n" +
                "The sum of the squares of the first ten natural numbers is,\n" +
                "\t\t1^2 + 2^2 + ... + 10^2 = 385\n" +
                "The square of the sum of the first ten natural numbers is,\n" +
                "\t\t(1 + 2 + ... + 10)^2 = 55^2 = 3025\n" +
                "Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.\n" +
                "\n" +
                "Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.";
    }

    @Override
    public BigInteger solution() {
        int count = 100;
        BigInteger squareOfSum = squareOfSum(count);
        BigInteger sumOfSquares = sumOfSquares(count);
        return squareOfSum.subtract(sumOfSquares);
    }

    private BigInteger sumOfSquares(int count) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= count; i++) {
            sum = sum.add(BigInteger.valueOf(i * i));
        }
        return sum;
    }

    private BigInteger squareOfSum(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i;
        }
        BigInteger bigSum = BigInteger.valueOf(sum);
        return bigSum.multiply(bigSum);
    }
}
