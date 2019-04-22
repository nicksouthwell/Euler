package problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem14Test {
    @Test
    void collatzExample() {
        Problem14 problem = new Problem14();
        assertEquals(10, problem.collatzChainLength(13));
    }
}