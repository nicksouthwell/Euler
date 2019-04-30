package problems;

import common.BigFibonacciSequence;

import java.math.BigInteger;

public class Problem25 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 25 - 1000-digit Fibonacci number\n" +
                "----------------------------------------\n" +
                "Hence the first 12 terms will be:\n" +
                "\tF1 = 1\n" +
                "\tF2 = 1\n" +
                "\tF3 = 2\n" +
                "\tF4 = 3\n" +
                "\tF5 = 5\n" +
                "\tF6 = 8\n" +
                "\tF7 = 13\n" +
                "\tF8 = 21\n" +
                "\tF9 = 34\n" +
                "\tF10 = 55\n" +
                "\tF11 = 89\n" +
                "\tF12 = 144\n" +
                "\n" +
                "The 12th term, F12, is the first term to contain three digits.\n" +
                "\n" +
                "What is the index of the first term in the Fibonacci sequence to contain 1000 digits?";
    }

    @Override
    public Integer solution() {
        int index = 1;
        for (BigInteger value : new BigFibonacciSequence()) {
//            System.out.println("F" + index + " = " + value);
            if (value.toString().length() >= 1000)
                break;
            index++;
        }
        return index + 1;
    }
}
