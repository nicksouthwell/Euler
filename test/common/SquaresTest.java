package common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SquaresTest {
    @Test
    void simpleSquares() {
        Squares squares = Squares.to(5);
        assertArrayEquals(new int[]{1, 4, 9, 16, 25}, squares._squares);

        assertEquals(9, squares.of(3));
        assertEquals(25, squares.of(5));
        assertEquals(3, squares.rootOf(9));
        assertEquals(0, squares.rootOf(10));
        assertEquals(0, squares.rootOf(30));
    }
}