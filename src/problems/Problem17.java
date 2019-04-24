package problems;

public class Problem17 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 17 - Number letter counts\n" +
                "---------------------------------\n" +
                "If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.\n" +
                "\n" +
                "If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?\n" +
                "\n" +
                "NOTE: Do not count spaces or hyphens. The use of \"and\" when writing out numbers is in compliance with British usage.";
    }

    @Override
    public Integer solution() {
        Integer sum = 0;
        for (int i = 1; i <= 1000; i++)
            sum += numberLetterCount(i);
        return sum;
    }

    static int[] unitsLength = {
            "".length(), "one".length(), "two".length(), "three".length(), "four".length(),
            "five".length(), "six".length(), "seven".length(), "eight".length(), "nine".length()
    };
    static int[] teensLength = {
            "ten".length(), "eleven".length(), "twelve".length(), "thirteen".length(), "fourteen".length(),
            "fifteen".length(), "sixteen".length(), "seventeen".length(), "eighteen".length(), "nineteen".length()};
    static int[] tensLength = {
            "twenty".length(), "thirty".length(), "forty".length(),
            "fifty".length(), "sixty".length(), "seventy".length(), "eighty".length(), "ninety".length()
    };

    Integer numberLetterCount(int i) {
        if (i < 10) {
            return unitsLength[i];
        } else if (i < 20) {
            return teensLength[i - 10];
        }
        return tensLength(i);
    }

    private Integer tensLength(int i) {
        int tens = i / 10;
        return tensLength[tens - 2];
    }
}
