package common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextBuilderTest {
    private TextBuilder unit = new TextBuilder();

    @Test
    void empty() {
        assertEquals("", unit.toString());
    }

    @Test
    void appendWord() {
        unit.appendWord("test");
        assertEquals("test", unit.toString());
    }

    @Test
    void appendEmptyWord() {
        unit.appendWord("test").appendWord("");
        assertEquals("test", unit.toString());
    }

    @Test
    void appendManyWords() {
        unit.appendWord("one").appendWord("two").appendWord("three");
        assertEquals("one two three", unit.toString());
    }

    @Test
    void appendWithConjunction() {
        unit.appendWord("tom").appendWithConjunction("and", "jerry");
        assertEquals("tom and jerry", unit.toString());
    }

    @Test
    void appendToEmptyWithConjunction() {
        unit.appendWithConjunction("and", "jerry");
        assertEquals("jerry", unit.toString());
    }

    @Test
    void appendEmptyWithConjunction() {
        unit.appendWord("tom").appendWithConjunction("and", "");
        assertEquals("tom", unit.toString());
    }

}