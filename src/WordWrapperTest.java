import org.junit.Test;

import static org.junit.Assert.*;

public class WordWrapperTest {
    private final String toBeWrapped = "this text is wrapped";
    private final String expected = "this\ntext\nis\nwrapped\n";

    @Test
    public void wrap() {
        String actual = WordWrapper.wrap("wrap", 1);
        assertEquals(actual, expected);
    }
}