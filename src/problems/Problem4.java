package problems;

public class Problem4 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 4 - Largest palindrome product\n" +
                "--------------------------------------\n" +
                "A palindromic number reads the same both ways. The largest palindrome made from the product\n" +
                "of two 2-digit numbers is 9009 = 91 × 99.\n" +
                "\n" +
                "Find the largest palindrome made from the product of two 3-digit numbers.";
    }

    @Override
    public Integer solution() {
        for (int i = 999; i >= 100; i--) {
            int palindrome = makePalindrome(i);
            if (hasTwoThreeDigitFactors(palindrome)) {
                return palindrome;
            }
        }
        return null;
    }

    private int makePalindrome(int i) {
        String firstHalf = new Integer(i).toString();
        String palindrome = firstHalf + new StringBuilder(firstHalf).reverse().toString();
        return Integer.parseInt(palindrome);
    }

    private boolean hasTwoThreeDigitFactors(int palindrome) {
        for (int factor = 999; factor >= 100; factor--) {
            if (factor * factor < palindrome)
                return false;
            if (palindrome % factor == 0) {
                System.out.println("Found factors: " + factor + "," + (palindrome / factor));
                return true;
            }
        }
        return false;
    }
}
