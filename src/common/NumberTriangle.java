package common;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class NumberTriangle {
    List<int[]> rows = new ArrayList<>();

    public NumberTriangle addRow(int... values) {
        rows.add(values);
        return this;
    }

    public int coalesceMax() {
        if (rows.size() > 1) {
            int[] target = rows.get(rows.size() - 2);
            int[] source = rows.get(rows.size() - 1);
            for (int i = 0; i < target.length; i++) {
                target[i] = target[i] + max(source[i], source[i + 1]);
            }
            rows.remove(rows.size() - 1);
        }
        return rows.size();
    }

    public int top() {
        return rows.get(0)[0];
    }
}
