package problems;

import java.math.BigInteger;

import static common.BigIntegerUtils.factorial;

public class Problem15 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 15 - Lattice paths\n" +
                "--------------------------\n" +
                "Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,\n" +
                "there are exactly 6 routes to the bottom right corner.\n" +
                "\n" +
                "How many such routes are there through a 20×20 grid?";
    }

    @Override
    public BigInteger solution() {
        // Have to make 40 moves (20 + 20)
        // Of these, we choose 20 in the same direction (all down or all right), the other 20 will be in the orthogonal direction.
        // So we're choosing the number of combinations of 40 moves, taken 20 at a time.  Or 40 C 20.
        //
        // = 40! / 20! * 20!
        BigInteger numerator = factorial(40);
        BigInteger denominator = factorial(20).multiply(factorial(20));
        return numerator.divide(denominator);
    }
}
