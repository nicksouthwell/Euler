package problems;

import common.TextBuilder;

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

    private static String[] unitNames = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static String[] teenNames = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] tenNames = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private Integer numberLetterCount(int i) {
        String numberAsText = numberAsText(i);
        return numberAsText.replaceAll("\\s", "").length();
    }

    String numberAsText(int i) {
        if (i == 1000) {
            return "one thousand";
        }

        int hundreds = i / 100;
        int hundreths = i % 100;

        TextBuilder tb = new TextBuilder();
        tb.appendWord(hundredsAsText(hundreds));
        tb.appendWithConjunction("and", hundredthsAsText(hundreths));
        return tb.toString();
    }

    private String hundredsAsText(int hundreds) {
        if (hundreds == 0)
            return "";

        TextBuilder tb = new TextBuilder();
        tb.appendWord(unitNames[hundreds]).appendWord("hundred");
        return tb.toString();
    }

    private String hundredthsAsText(int hundredths) {
        int tens = hundredths / 10;
        int units = hundredths % 10;

        TextBuilder tb = new TextBuilder();
        if (tens == 1) {
            tb.appendWord(teenNames[units]);
        } else {
            tb.appendWord(tenNames[tens]).appendWord(unitNames[units]);
        }
        return tb.toString();
    }
}
