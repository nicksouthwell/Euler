package problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem24Test {
    @Test
    void example() {
        PermutationIterator<Integer> permutationIterator = new PermutationIterator<>(15, List.of(0, 1, 2, 3));

        final StringBuilder sb = new StringBuilder();
        while (permutationIterator.hasNext()) {
            sb.append(permutationIterator.next());
        }
        assertEquals("2103", sb.toString());
    }

}