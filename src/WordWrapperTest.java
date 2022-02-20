import org.junit.Test;

import static org.junit.Assert.*;

public class WordWrapperTest {
    // one passing
    // one failing
    // one edge case?
    private final String eightCharsToBeWrapped = "this text is wrapped";
    private final String eightCharsExpected = "this\ntext\nis\nwrapped\n";
    private final String twentyCharsToBeWrapped = "This paragraph contains several sentences. The aim is to provide numerous amounts of large words. Also to test the functionality with punctuation.";
    private final String twentyCharsExpected = "This paragraph\ncontains several\nsentences. The aim\nis to provide\nnumerous amounts of\nlarge words. Also to\ntest the\nfunctionality with\npunctuation.\n";

    @Test
    public void wrapEightChars() {
        String actual = WordWrapper.wrap(eightCharsToBeWrapped, 8);
        assertEquals(eightCharsExpected, actual);
    }

    @Test
    public void wrapTwentyCharsWithManyLargeWords() {
        String actual = WordWrapper.wrap(twentyCharsToBeWrapped, 20);
        assertEquals(twentyCharsExpected, actual);
    }
}