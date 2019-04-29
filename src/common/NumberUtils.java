package common;

import java.util.List;

public final class NumberUtils {
    public static List<Integer> properDivisors(int n) {
        PrimeFactors factors = PrimeFactors.of(n);
        return factors.properDivisors();
    }

    public static Integer sum(Iterable<Integer> values) {
        Integer sum = 0;
        for (Integer value : values)
            sum += value;
        return sum;
    }
}
