package problems;

import java.math.BigInteger;

public class Problem16 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 16 - Power digit sum\n" +
                "----------------------------\n" +
                "2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.\n" +
                "\n" +
                "What is the sum of the digits of the number 2^1000?";
    }

    @Override
    public Integer solution() {
        String digits = BigInteger.valueOf(2).pow(1000).toString();
        Integer sum = 0;
        for (char digit : digits.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }
}
