import org.junit.Test;

import static org.junit.Assert.*;

public class WordWrapperTest {
    private final String toBeWrapped = "this text is wrapped";
    private final String expected = "this text\nis\nwrapped\n";

    @Test
    public void wrapEightChars() {
        String actual = WordWrapper.wrap(toBeWrapped, 8);
        assertEquals(expected, actual);
    }
}