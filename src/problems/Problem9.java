package problems;

import common.Squares;

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
    public Integer solution() {
        Squares squares = Squares.to(500);
        for (int c = 500; c >= 1; c--) {        // c < a + b  and  a + b + c = 1000
            int cSquared = squares.of(c);
            int aMax = (1000 - c) / 2;          // only consider cases where a < b
            for (int a = 1; a <= aMax; a++) {
                int b = squares.rootOf(cSquared - squares.of(a));
                if (b != 0 && a + b + c == 1000) {
                    System.out.println("a=" + a + ",b=" + b + ",c=" + c);
                    return a * b * c;
                }
            }
        }
        return 0;
    }
}
