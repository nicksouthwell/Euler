package problems;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem12Test {
    @Test
    void numberOfDivisors() {
        Problem12 problem12 = new Problem12();
        assertEquals(2, problem12.numberOfDivisors(BigInteger.valueOf(2))); // 1, 2
        assertEquals(3, problem12.numberOfDivisors(BigInteger.valueOf(4))); // 1, 2, 4
        assertEquals(6, problem12.numberOfDivisors(BigInteger.valueOf(12))); // 1, 2, 3, 4, 6, 12
        // 360: [1,2,4,8,3,6,12,24,9,18,36,72,5,10,20,40,15,30,60,120,45,90,180,360]
        assertEquals(24, problem12.numberOfDivisors(BigInteger.valueOf(2 * 2 * 2 * 3 * 3 * 5)));// 360

        /*
            number of factors for prime factors: f1n1, f2n2, f3n3, ...
            for factor: f count n given m from other factors
            add: m * n
        */
    }
}