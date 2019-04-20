package common;

import java.util.Arrays;

public class Squares {
    int[] _squares;

    private Squares(int max) {
        _squares = new int[max];
        for (int i = 0; i < max; i++) {
            _squares[i] = (i + 1) * (i + 1);
        }
    }

    public static Squares to(int max) {
        return new Squares(max);
    }

    public int of(int value) {
        return _squares[value - 1];
    }

    public int rootOf(int square) {
        int result = Arrays.binarySearch(_squares, square);
        if (result >= 0)
            return result + 1;
        else
            return 0;
    }
}
