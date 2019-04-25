package common;

public class TextBuilder {
    private StringBuilder sb = new StringBuilder();

    public TextBuilder appendWord(String word) {
        if (word.length() != 0) {
            if (sb.length() != 0)
                sb.append(' ');
            sb.append(word);
        }
        return this;
    }

    public TextBuilder appendWithConjunction(String conjunction, String word) {
        if (word.length() != 0) {
            if (sb.length() != 0)
                sb.append(' ').append(conjunction).append(' ');
            sb.append(word);
        }
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
