package problems;

import static common.NumberUtils.properDivisors;
import static common.NumberUtils.sum;

public class Problem21 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 21 - Amicable numbers\n" +
                "-----------------------------\n" +
                "Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).\n" +
                "If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.\n" +
                "\n" +
                "For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.\n" +
                "The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.\n" +
                "\n" +
                "Evaluate the sum of all the amicable numbers under 10000.";
    }

    @Override
    public Integer solution() {
        int sum = 0;
        int[] known_ds = new int[10_000];

        System.out.println();
        for (int a = 2; a < 10_000; a++) {
            int b = sumProperDivisors(a);
            known_ds[a] = b;
            if (b < a && known_ds[b] == a) {
                System.out.println("Found amicable pair: " + b + "," + a);
                sum += (a + b);
            }
        }
        return sum;
    }

    private int sumProperDivisors(int a) {
        return sum(properDivisors(a));
    }
}
