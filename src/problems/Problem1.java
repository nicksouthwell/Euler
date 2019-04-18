package problems;

public class Problem1 implements Problem {

    public String getDescription() {
        return "Problem 1 - Multiples of 3 and 5\n" +
                "--------------------------------\n" +
                "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.\n" +
                "The sum of these multiples is 23.\n" +
                "\n" +
                "Find the sum of all multiples of 3 or 5 below 1000.";
    }

    public Integer solution() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0) {
                sum += i;
            } else if (i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
