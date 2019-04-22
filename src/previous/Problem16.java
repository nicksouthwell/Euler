package previous;

public class Problem16 {
    public static long powerDigitSum(int power) {
        HugeNumber x = new HugeNumber("1");
        for (int i = 0; i < power; i++)
            x = x.add(x);
        System.out.println(x.toString());

        long sum = 0;
        for (Integer digit : x.getDigits())
            sum += digit;
        return sum;
    }
}
