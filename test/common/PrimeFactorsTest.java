package common;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeFactorsTest {
    @Test
    void newObjectIsEmpty() {
        PrimeFactors factors = new PrimeFactors();

        assertEquals(0, factors._factors.size());
        assertEquals(false, factors.iterator().hasNext());
    }

    @Test
    void factorsOf2() {
        PrimeFactors factors = PrimeFactors.of(2);

        assertEquals(Map.of(2, 1), factors._factors);
    }

    @Test
    void factorsOf3() {
        PrimeFactors factors = PrimeFactors.of(3);

        assertEquals(Map.of(3, 1), factors._factors);
    }

    @Test
    void factorsOf125() {
        PrimeFactors factors = PrimeFactors.of(125);

        assertEquals(Map.of(5, 3), factors._factors);
    }

    @Test
    void factorsOf126() {
        // 2, 3, 3, 7
        PrimeFactors factors = PrimeFactors.of(126);

        assertEquals(Map.of(2, 1, 3, 2, 7, 1), factors._factors);
    }
}