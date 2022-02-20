import org.junit.Test;

import static org.junit.Assert.*;

public class WordWrapperTest {
    // one passing
    // one failing
    // one edge case?
    // test if words are broken up properly, one enormous word broken up into several small pieces
    private final String eightCharsToBeWrapped = "this text is wrapped";
    private final String eightCharsExpected = "this\ntext is\nwrapped\n";
    private final String twentyCharsToBeWrapped = "This paragraph contains several sentences. The aim is to provide numerous amounts of large words. Also to test the functionality with punctuation.";
    private final String twentyCharsExpected = "This paragraph\ncontains several\nsentences. The aim\nis to provide\nnumerous amounts of\nlarge words. Also\nto test the\nfunctionality with\npunctuation.\n";
    private final String incorrectToBeWrapped = "This text will be wrapped incorrectly. The test should pass if they are not equal.";
    private final String incorrectToBeWrappedExpected = "This text will\nbe wrapped incorrectly.\nThe test should\npass if they\nare not equal.\n";
    private final String shouldSplitBigWordsToBeWrapped = "oneenormousandridiculouslylargewordthatisfake";
    private final String shouldSplitBigWordsExpected = "oneen\normou\nsandr\nidicu\nlousl\nylarg\neword\nthati\nsfake\n";

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

    @Test
    public void shouldNotMatchIncorrectlyWrappedText() {
        String actual = WordWrapper.wrap(incorrectToBeWrapped, 8);
        assertNotEquals(incorrectToBeWrappedExpected, actual);
    }

    @Test
    public void shouldSplitBigWordsEveryFiveChars() {
        String actual = WordWrapper.wrap(shouldSplitBigWordsToBeWrapped, 5);
        assertEquals(shouldSplitBigWordsExpected, actual);
    }
}