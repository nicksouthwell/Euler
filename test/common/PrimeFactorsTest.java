package common;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeFactorsTest {
    @Test
    void newObjectIsEmpty() {
        PrimeFactors factors = new PrimeFactors();

        assertEquals(0, factors._factors.size());
        assertEquals(List.of(), iterateThrough(factors));
    }

    @Test
    void factorsOf2() {
        PrimeFactors factors = PrimeFactors.of(2);

        assertEquals(Map.of(2, 1), factors._factors);
        assertEquals(List.of(2), iterateThrough(factors));
    }

    @Test
    void factorsOf3() {
        PrimeFactors factors = PrimeFactors.of(3);

        assertEquals(Map.of(3, 1), factors._factors);
        assertEquals(List.of(3), iterateThrough(factors));
    }

    @Test
    void factorsOf125() {
        PrimeFactors factors = PrimeFactors.of(125);

        assertEquals(Map.of(5, 3), factors._factors);
        assertEquals(List.of(5, 5, 5), iterateThrough(factors));
    }

    @Test
    void factorsOf126() {
        PrimeFactors factors = PrimeFactors.of(126);

        assertEquals(Map.of(2, 1, 3, 2, 7, 1), factors._factors);
        assertEquals(List.of(2, 3, 3, 7), iterateThrough(factors));
    }

    @Test
    void mergeWhenNoConflicts() {
        PrimeFactors factors = PrimeFactors.of(15);   // 3 * 5
        PrimeFactors append = PrimeFactors.of(14);  // 2 * 7

        factors.merge(append);

        assertEquals(List.of(2, 3, 5, 7), iterateThrough(factors));
    }

    @Test
    void mergeWhenDuplicate() {
        PrimeFactors factors = PrimeFactors.of(15);   // 3 * 5
        PrimeFactors append = PrimeFactors.of(35);  // 5 * 7

        factors.merge(append);

        assertEquals(List.of(3, 5, 7), iterateThrough(factors));
    }

    @Test
    void mergeWhenIncrementNeeded() {
        PrimeFactors factors = PrimeFactors.of(15);   // 3 * 5
        PrimeFactors append = PrimeFactors.of(25);  // 5 * 5

        factors.merge(append);

        assertEquals(List.of(3, 5, 5), iterateThrough(factors));
    }

    @Test
    void mergeWithIgnoredDecrement() {
        PrimeFactors factors = PrimeFactors.of(25);   // 5 * 5
        PrimeFactors append = PrimeFactors.of(10);  // 2 * 5

        factors.merge(append);

        assertEquals(List.of(2, 5, 5), iterateThrough(factors));
    }

    @Test
    void properDivisors() {
        PrimeFactors factors = PrimeFactors.of(6);
        List<Integer> divisors = factors.properDivisors();

        assertEquals(List.of(1, 2, 3), divisors);
    }

    private List<Integer> iterateThrough(PrimeFactors factors) {
        List<Integer> result = new ArrayList<>();
        for (java.lang.Integer factor : factors) {
            result.add(factor);
        }
        return result;
    }
}