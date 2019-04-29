package problems;

import static common.NumberUtils.properDivisors;
import static common.NumberUtils.sum;

public class Problem23 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 23 - Non-abundant sums\n" +
                "------------------------------\n" +
                "A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For\n" +
                "example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a\n" +
                "perfect number.\n" +
                "\n" +
                "A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if\n" +
                "this sum exceeds n.\n" +
                "\n" +
                "As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the\n" +
                "sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than\n" +
                "28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any\n" +
                "further by analysis even though it is known that the greatest number that cannot be expressed as the sum of\n" +
                "two abundant numbers is less than this limit.\n" +
                "\n" +
                "Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.";
    }

    @Override
    public Integer solution() {
        Integer sum = 1;
        for (int n = 2; n <= 28123; n++) {
            evaluateForAbundance(n);
            if (!isSumOfTwoAbundantNumbers(n)) {
                sum += n;
            }
        }
        return sum;
    }

    private boolean[] isAbundant = new boolean[28124];

    private void evaluateForAbundance(int n) {
        int sumOfProperDivisors = sum(properDivisors(n));
        isAbundant[n] = (sumOfProperDivisors > n);
    }

    private boolean isSumOfTwoAbundantNumbers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (isAbundant[i] && isAbundant[n - i])
                return true;
        }
        return false;
    }
}
