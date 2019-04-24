package problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem17Test {
    Problem17 problem = new Problem17();

    @Test
    void units() {
        assertNumberLetterCount("one", 1);
        assertEquals("one".length(), problem.numberLetterCount(1));
        assertEquals("two".length(), problem.numberLetterCount(2));
        assertEquals(5, problem.numberLetterCount(3));
        assertEquals(4, problem.numberLetterCount(4));
        assertEquals(4, problem.numberLetterCount(5));
        assertEquals(3, problem.numberLetterCount(6));
        assertEquals(5, problem.numberLetterCount(7));
        assertEquals(5, problem.numberLetterCount(8));
        assertEquals(4, problem.numberLetterCount(9));
    }

    @Test
    void teens() {
        assertEquals(3, problem.numberLetterCount(10));
        assertEquals(6, problem.numberLetterCount(11));
        assertEquals(6, problem.numberLetterCount(12));
        assertEquals(8, problem.numberLetterCount(13));
        assertEquals(8, problem.numberLetterCount(14));
        assertEquals(7, problem.numberLetterCount(15));
        assertEquals(7, problem.numberLetterCount(16));
        assertEquals(9, problem.numberLetterCount(17));
        assertEquals(8, problem.numberLetterCount(18));
        assertEquals(8, problem.numberLetterCount(19));
    }

    @Test
    void twentyToNinetyNoUnits() {
        assertEquals(6, problem.numberLetterCount(20));
        assertEquals(6, problem.numberLetterCount(30));
        assertEquals(5, problem.numberLetterCount(40));
        assertEquals(5, problem.numberLetterCount(50));
        assertEquals(5, problem.numberLetterCount(60));
        assertEquals(7, problem.numberLetterCount(70));
        assertEquals(6, problem.numberLetterCount(80));
        assertEquals(6, problem.numberLetterCount(90));
    }

    @Test
    void twentyToNinetyWithUnits() {
        assertEquals(9, problem.numberLetterCount(21));
        assertEquals(9, problem.numberLetterCount(32));
        assertEquals(8, problem.numberLetterCount(43));
        assertEquals(8, problem.numberLetterCount(54));
        assertEquals(8, problem.numberLetterCount(65));
        assertEquals(8, problem.numberLetterCount(76));
        assertEquals(8, problem.numberLetterCount(87));
        assertEquals(8, problem.numberLetterCount(98));
    }
}