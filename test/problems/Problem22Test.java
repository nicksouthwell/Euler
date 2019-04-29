package problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem22Test {
    Problem22 unit = new Problem22();

    @Test
    void exampleNameScore() {
        assertEquals(49714, unit.nameScore("COLIN", 938));
    }

}