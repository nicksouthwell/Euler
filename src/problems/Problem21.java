package problems;

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
        // see problem 12 which figures out the number of divisors ... but not their values
        // proper divisors can be derived from PrimeFactors

        Integer sum = 0;
        // for a = 2 to 9999
        //   calculate and save b = sum(proper-divisors(a))  // b = d(a)
        //   if b < a && d(b) == a
        //     sum += (a + b)
        return sum;
    }
}
