package common;

import java.util.Iterator;

public class FibonacciSequence implements Iterable<Integer> {
    final int max;

    public FibonacciSequence(int max) {
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int a = 0, b = 1;

            @Override
            public boolean hasNext() {
                return a + b <= max;
            }

            @Override
            public Integer next() {
                int next = a + b;
                a = b;
                return b = next;
            }
        };
    }
}
