package problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem17Test {
    Problem17 problem = new Problem17();

    @Test
    void units() {
        assertEquals("one", problem.numberAsText(1));
        assertEquals("two", problem.numberAsText(2));
        assertEquals("three", problem.numberAsText(3));
        assertEquals("four", problem.numberAsText(4));
        assertEquals("five", problem.numberAsText(5));
        assertEquals("six", problem.numberAsText(6));
        assertEquals("seven", problem.numberAsText(7));
        assertEquals("eight", problem.numberAsText(8));
        assertEquals("nine", problem.numberAsText(9));
    }

    @Test
    void teens() {
        assertEquals("ten", problem.numberAsText(10));
        assertEquals("eleven", problem.numberAsText(11));
        assertEquals("twelve", problem.numberAsText(12));
        assertEquals("thirteen", problem.numberAsText(13));
        assertEquals("fourteen", problem.numberAsText(14));
        assertEquals("fifteen", problem.numberAsText(15));
        assertEquals("sixteen", problem.numberAsText(16));
        assertEquals("seventeen", problem.numberAsText(17));
        assertEquals("eighteen", problem.numberAsText(18));
        assertEquals("nineteen", problem.numberAsText(19));
    }

    @Test
    void twentyToNinetyNoUnits() {
        assertEquals("twenty", problem.numberAsText(20));
        assertEquals("thirty", problem.numberAsText(30));
        assertEquals("forty", problem.numberAsText(40));
        assertEquals("fifty", problem.numberAsText(50));
        assertEquals("sixty", problem.numberAsText(60));
        assertEquals("seventy", problem.numberAsText(70));
        assertEquals("eighty", problem.numberAsText(80));
        assertEquals("ninety", problem.numberAsText(90));
    }

    @Test
    void twentyToNinetyWithUnits() {
        assertEquals("twenty one", problem.numberAsText(21));
        assertEquals("thirty two", problem.numberAsText(32));
        assertEquals("forty three", problem.numberAsText(43));
        assertEquals("fifty four", problem.numberAsText(54));
        assertEquals("sixty five", problem.numberAsText(65));
        assertEquals("seventy six", problem.numberAsText(76));
        assertEquals("eighty seven", problem.numberAsText(87));
        assertEquals("ninety eight", problem.numberAsText(98));
    }

    @Test
    void hundreds() {
        assertEquals("one hundred", problem.numberAsText(100));
        assertEquals("one hundred and seven", problem.numberAsText(107));
        assertEquals("seven hundred and fifty", problem.numberAsText(750));
        assertEquals("five hundred and forty one", problem.numberAsText(541));
    }

    @Test
    void thousands() {
        assertEquals("one thousand", problem.numberAsText(1000));
    }
}