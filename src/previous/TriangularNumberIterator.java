package previous;

public class TriangularNumberIterator {
    long value = 1;
    long next = 2;

    public long value() {
        return value;
    }

    public void next() {
        value += next++;
    }
}
