package problems;

import java.util.ArrayDeque;
import java.util.Deque;

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
    public Long solution() {
        Long solution = 0L;
        long longestChainLength = 0L;
        for (long n = 1; n < 1_000_000; n++) {
            long chainLength = collatzChainLength(n);
            if (chainLength > longestChainLength) {
                solution = n;
                longestChainLength = chainLength;
            }
        }
        return solution;
    }

    private CollatzChainCache cache = new CollatzChainCache();

    long collatzChainLength(long n) {
        Deque<Long> tempChain = new ArrayDeque<>();

        while (!cache.contains(n)) {
            tempChain.push(n);
            n = nextCollatzTerm(n);
        }

        long knownLength = cache.get(n);

        while (!tempChain.isEmpty()) {
            n = tempChain.pop();
            knownLength++;
            cache.put(n, knownLength);
        }

        return knownLength;
    }

    private long nextCollatzTerm(long n) {
        if (n == 1L)
            return 0L;

        if (n % 2L == 0L)
            return n / 2L;

        return (3L * n) + 1L;
    }

    private static class CollatzChainCache {
        private long[] collatzChainLengths = new long[1_000_000];

        public CollatzChainCache() {
            collatzChainLengths[0] = 1L;
        }

        public boolean contains(long n) {
            return get(n) != 0;
        }

        public long get(long n) {
            if (n > collatzChainLengths.length)
                return 0L;
            return collatzChainLengths[(int) n - 1];
        }

        public void put(long n, long length) {
            if (n > collatzChainLengths.length)
                return;
            collatzChainLengths[(int) n - 1] = length;
        }
    }
}
