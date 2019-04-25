package common;

import org.junit.jupiter.api.Test;

import static java.lang.Math.max;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberTriangleTest {
    NumberTriangle unit = new NumberTriangle();

    @Test
    void empty() {
        assertEquals(0, unit.rows.size());
    }

    @Test
    void oneRow() {
        unit.addRow(42);
        assertEquals(1, unit.rows.size());
        assertArrayEquals(new int[]{42}, unit.rows.get(0));
    }

    @Test
    void threeRows() {
        unit.addRow(42).addRow(1, 2).addRow(30, 20, 10);
        assertEquals(3, unit.rows.size());
        assertArrayEquals(new int[]{42}, unit.rows.get(0));
        assertArrayEquals(new int[]{1, 2}, unit.rows.get(1));
        assertArrayEquals(new int[]{30, 20, 10}, unit.rows.get(2));
    }

    @Test
    void example() {
        unit.addRow(3).addRow(7, 4).addRow(2, 4, 6).addRow(8, 5, 9, 3);
        assertEquals(4, unit.rows.size());

        assertEquals(3, unit.coalesceMax());
        assertEquals(3, unit.rows.size());
        assertArrayEquals(new int[]{3}, unit.rows.get(0));
        assertArrayEquals(new int[]{7, 4}, unit.rows.get(1));
        assertArrayEquals(new int[]{2 + max(8, 5), 4 + max(5, 9), 6 + max(9, 3)}, unit.rows.get(2));

        while (unit.coalesceMax() > 1) ;

        assertEquals(23, unit.top());
    }
}