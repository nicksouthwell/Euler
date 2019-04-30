package problems;

import java.math.BigInteger;

public class Problem26 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 26 - Reciprocal cycles\n" +
                "------------------------------\n" +
                "A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:\n" +
                "\t1/2\t= \t0.5\n" +
                "\t1/3\t= \t0.(3)\n" +
                "\t1/4\t= \t0.25\n" +
                "\t1/5\t= \t0.2\n" +
                "\t1/6\t= \t0.1(6)\n" +
                "\t1/7\t= \t0.(142857)\n" +
                "\t1/8\t= \t0.125\n" +
                "\t1/9\t= \t0.(1)\n" +
                "\t1/10\t= \t0.1" +
                "\n" +
                "Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.\n" +
                "\n" +
                "Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.";
    }

    @Override
    public Integer solution() {
        /*
        How does 1/7 come to have a 6-digit recurring cycle?
        10 % 7 gives 1,3
        30 % 7 gives 4,2
        20 % 7 gives 2,6
        60 % 7 gives 8,4
        40 % 7 gives 5,5
        50 % 7 gives 7,1
        Cycle ends when remainder is 1, max numbers in cycle is 7-1 = 6
        Let's try 19:
        100 % 19 gives 5,5
        50  % 19 gives 2,12
        120 % 19 gives 6,6
        60  % 19 gives 3,3
        30  % 19 gives 1,11
        110 % 19 gives 5,15 <- 5 has repeated here, but the remainder is different
        150 % 19 gives 7,17
        170 % 19 gives 8,18
        180 % 19 gives 9,9
         */
        String digits = BigInteger.valueOf(2).pow(1000).toString();
        Integer sum = 0;
        for (char digit : digits.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }
}
