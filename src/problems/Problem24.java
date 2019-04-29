package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem24 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 24 - Lexicographic permutations\n" +
                "---------------------------------------\n" +
                "A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits\n" +
                "1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic\n" +
                "order. The lexicographic permutations of 0, 1 and 2 are:\n" +
                "\n" +
                "\t\t\t012 021 102 120 201 210\n" +
                "\n" +
                "What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?";
    }

    @Override
    public Integer solution() {
        /*
            Number of permutations of n-1 digits will tell us what the starting digit is,
            and the remainder after the starting digit can be used to determine which digit comes next.
            etc.
            eg. Find 15th lexi perm of the digits 0, 1, 2, 3
              0123 0132 0213 0231 0312 0321  1023 1032 1203 1230 1302 1320
              2013 2031 2103 2130 2301 2310  3012 3021 3102 3120 3201 3210   <- is 2103

            Basic idea:
                For each starting digit 0,1,2,3 there are (4-1)! = 6 combinations

            Note: use 0-based indexes for the arithmetic
            starting digit from {0,1,2,3} is the (14 / 3!)th digit = digit[2]... which is 2 leaving {0,1,3}
            remainder is 14 % 3! = 2

            starting digit from {0,1,3} is the (2 / 2!)th digit = digit[1]... which is 1 leaving {0,3}
            remainder is 2 % 2! = 0

            starting digit from {0,3} is the (0 / 1!)th digit = digit[0]... which is 0 leaving {3}
            remainder is 0 % 1! = 0

            solution is 2103
         */
        List<Integer> digits = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> target = new ArrayList<>();

        int permutationIndex = 999_999;
        while (digits.size() != 0) {
        }

        return 0;
    }
}
