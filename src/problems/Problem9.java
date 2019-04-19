package problems;

import java.math.BigInteger;

public class Problem9 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 9 - Special Pythagorean triplet\n" +
                "---------------------------------------\n" +
                "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,\n" +
                "\t\t\ta^2 + b^2 = c^2\n" +
                "For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.\n" +
                "\n" +
                "There exists exactly one Pythagorean triplet for which a + b + c = 1000.\n" +
                "Find the product abc.";
    }

    @Override
    public BigInteger solution() {
        /*
        restricting the search set
        a + b is always > c
        c is always > a
        c is always > b
        Build a list of squares
        for c = 500^2 down to 1
            for each find sum candidates a, b where a + b = 1000 - c
                if (a + b + c = 1000)
                    return a * b * cWa
         */
        BigInteger solution = BigInteger.ONE;
        return solution;
    }
}
