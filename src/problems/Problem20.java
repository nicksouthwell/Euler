package problems;

import common.BigIntegerUtils;

public class Problem20 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 20 - Factorial digit sum\n" +
                "--------------------------------\n" +
                "n! means n × (n − 1) × ... × 3 × 2 × 1\n" +
                "\n" +
                "For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,\n" +
                "and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.\n" +
                "\n" +
                "Find the sum of the digits in the number 100!";
    }

    @Override
    public Integer solution() {
        String digits = BigIntegerUtils.factorial(100).toString();
        Integer sum = 0;
        for (char digit : digits.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }
}
