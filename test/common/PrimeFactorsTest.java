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
        // 2, 3, 3, 7
        PrimeFactors factors = PrimeFactors.of(2);

        assertEquals(Map.of(2, 1), factors._factors);
    }
}