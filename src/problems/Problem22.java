package problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem22 implements Problem {
    @Override
    public String getDescription() {
        return "Problem 22 - Names scores\n" +
                "-------------------------\n" +
                "Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand\n" +
                "first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each\n" +
                "name, multiply this value by its alphabetical position in the list to obtain a name nameScore.\n" +
                "\n" +
                "For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,\n" +
                "is the 938th name in the list. So, COLIN would obtain a nameScore of 938 × 53 = 49714.\n" +
                "\n" +
                "What is the total of all the name scores in the file?";
    }

    @Override
    public Integer solution() {
        List<String> names = readNamesFile("src/resources/p022_names.txt");
        Collections.sort(names);
        return totalScore(names);
    }

    private List<String> readNamesFile(String filename) {
        List<String> names = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String name = scanner.next().replaceAll("\"", "");
                names.add(name);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return names;
    }

    private Integer totalScore(List<String> names) {
        Integer sum = 0;
        int alphabeticPosition = 1;
        for (String name : names) {
            sum += nameScore(name, alphabeticPosition++);
        }
        return sum;
    }

    Integer nameScore(String name, int alphabeticPosition) {
        return alphabeticValue(name) * alphabeticPosition;
    }

    private Integer alphabeticValue(String name) {
        Integer value = 0;
        for (char c : name.toCharArray()) {
            value += (c - 64);
        }
        return value;
    }
}
