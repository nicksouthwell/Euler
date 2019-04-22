package previous;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Problem14 {
    private static Deque<Long> history = new ArrayDeque<Long>();
    private static Map<Long, Long> collatzMap = new HashMap<Long, Long>();

    static {
        collatzMap.put(1L, 1L);
    }

    public static long longestCollatzSequence(long max) {
        long longest = 0;
        long startingNumberForLongest = 0;
        for (long startingNumber = 1; startingNumber <= max; startingNumber++) {
            long length = collatzSequenceLength(startingNumber);
            if (length > longest) {
                System.out.printf("%d: has chain of %d terms\n", startingNumber, length);
                startingNumberForLongest = startingNumber;
                longest = length;
            }
        }
        return startingNumberForLongest;
    }

    private static long collatzSequenceLength(long n) {
        while (collatzMap.containsKey(n) == false) {
            history.addFirst(n);
            n = collatzNext(n);
        }

        Long length = collatzMap.get(n);

        while (history.isEmpty() == false) {
            n = history.removeFirst();
            collatzMap.put(n, ++length);
        }

        return length;
    }

    private static long collatzNext(long n) {
        if (n % 2 == 0)
            return n / 2;
        if (n > Long.MAX_VALUE / 3)
            throw new ArithmeticException("Collatz sequence overflows long");
        return (n * 3) + 1;
    }
}
