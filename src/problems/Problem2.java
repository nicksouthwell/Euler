package problems;

import common.FibonacciSequence;

public class Problem2 implements Problem {

    public String getDescription() {
        return "Problem 2\n" +
                "---------\n" +
                "Each new term in the Fibonacci sequence is generated by adding the previous two terms.\n" +
                "By starting with 1 and 2, the first 10 terms will be:.\n" +
                "\n" +
                "\t\t1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...\n" +
                "\n" +
                "By considering the terms in the Fibonacci sequence whose values do not exceed four million,\n" +
                "find the sum of the even-valued terms.";
    }

    public Integer solution() {
        Integer sum = 0;
        for (Integer value : new FibonacciSequence(4000000)) {
            if (value % 2 == 0) {
                sum += value;
            }
        }
        return sum;
    }
}
