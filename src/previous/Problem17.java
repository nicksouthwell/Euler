package previous;

public class Problem17 {
    public static long numberLetterCounts(int max) {
        long sumLetterCounts = 0;
        for (int number = 1; number <= max; number++)
            sumLetterCounts += letterCount(number);
        return sumLetterCounts;
    }

    private static String[] units = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static String[] teens = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static String hundred = "hundred";
    private static String and = "and";
    private static String thousand = "thousand";

    static long letterCount(int number) {
        return thousandsLetterCount(number)
                + hundredsLetterCount(number)
                + andLetterCount(number)
                + tensLetterCount(number)
                + unitsLetterCount(number);
    }

    private static long unitsLetterCount(int number) {
        if (number > 10)
            return teens[number - 11].length();
        return units[number - 1].length();
    }

    private static long tensLetterCount(int number) {
        return 0;
    }

    private static long andLetterCount(int number) {
        return 0;
    }

    private static long hundredsLetterCount(int number) {
        return 0;
    }

    private static long thousandsLetterCount(int number) {
        return 0;
    }
}
