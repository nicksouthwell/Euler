package previous;

public class Problem12 {
    public static long highlyDivisibleTriangularNumber(int divisors) {
        for (TriangularNumberIterator it = new TriangularNumberIterator(); true; it.next())
            if (countFactors(it.value()) > divisors)
                return it.value();
    }

    private static int countFactors(long value) {
        int count = 0;
        System.out.printf("factors for %d: ", value);
        for (long factor = 1; factor <= value; factor++)
            if (value % factor == 0) {
                System.out.printf("%d,", factor);
                count++;
            }
        System.out.println("");
        return count;
    }
}
