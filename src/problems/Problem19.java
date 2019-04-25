package problems;

import java.time.DayOfWeek;
import java.time.Month;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.Month.JANUARY;

public class Problem19 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 19 - Counting Sundays\n" +
                "-----------------------------\n" +
                "You are given the following information, but you may prefer to do some research for yourself.\n" +
                "\t* 1 Jan 1900 was a Monday.\n" +
                "\t* Thirty days has September,\n" +
                "\t  April, June and November.\n" +
                "\t  All the rest have thirty-one,\n" +
                "\t  Saving February alone,\n" +
                "\t  Which has twenty-eight, rain or shine.\n" +
                "\t  And on leap years, twenty-nine.\n" +
                "\t* A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.\n" +
                "\n" +
                "How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?";
    }

    @Override
    public Integer solution() {
        int sundayCount = 0;
        for (MyDate date = new MyDate(MONDAY, JANUARY, 1, 1900); date.getYear() <= 2000; date.addMonth()) {
            if (date.getYear() > 1900 && date.getDayOfWeek() == SUNDAY) {
                sundayCount++;
            }
        }
        return sundayCount;
    }
}

class MyDate {
    private int dayOfWeek;  // monday = 0...
    private int month;      // january = 0...
    private int dayOfMonth; // always 1
    private int year;

    public MyDate(DayOfWeek dayOfWeek, Month month, int dayOfMonth, int year) {
        this.dayOfWeek = dayOfWeek.ordinal();
        this.month = month.ordinal();
        this.dayOfMonth = dayOfMonth;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(dayOfWeek + 1);
    }

    public void addMonth() {
        dayOfWeek = (dayOfWeek + getMonthLength()) % 7;
        month++;
        if (month / 12 == 1) {
            year++;
            month = 0;
        }
    }

    private static int[] monthLengths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int getMonthLength() {
        return monthLengths[month] + (month == 1 && isLeapYear() ? 1 : 0);
    }

    private boolean isLeapYear() {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public String toString() {
        return Month.of(month + 1).toString() + " " + year;
    }
}