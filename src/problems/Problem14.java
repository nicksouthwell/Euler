package problems;

import java.util.Map;
import java.util.TreeMap;

public class Problem14 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 14 - Longest Collatz sequence\n" +
                "-------------------------------------\n" +
                "The following iterative sequence is defined for the set of positive integers:\n" +
                "\tn -> n/2 (n is even)\n" +
                "\tn -> 3n + 1 (n is odd)\n" +
                "\n" +
                "Using the rule above and starting with 13, we generate the following sequence:\n" +
                "\t\t\t13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1\n" +
                "It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.\n" +
                "Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.\n" +
                "\n" +
                "Which starting number, under one million, produces the longest chain?";
    }

    @Override
    public Integer solution() {
        Integer solution = 0;
        int longestChainLength = 0;
        for (int n = 1; n < 1_000_000; n++) {
            int chainLength = collatzChainLength(n);
            if (chainLength > longestChainLength) {
                solution = n;
                longestChainLength = chainLength;
            }
        }
        return solution;
    }

    private Map<Integer, Integer> collatzChains = new TreeMap<>();

    {
        collatzChains.put(1, 1);
    }

    int collatzChainLength(int n) {
        Integer length = collatzChains.get(n);
        if (length != null) {
            return length;
        }

        length = 1 + collatzChainLength(nextCollatzTerm(n));
        collatzChains.put(n, length);
        return length;
    }

    private int nextCollatzTerm(int n) {
        if (n == 1)
            return 0;

        if (n % 2 == 0)
            return n / 2;

        return (3 * n) + 1;
    }
}
