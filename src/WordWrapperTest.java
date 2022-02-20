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
    private final String twentyCharsExpected = "This paragraph\ncontains several\nsentences. The aim\nis to provide\nnumerous amounts of\nlarge words. Also to\ntest the\nfunctionality with\npunctuation.\n";
    private final String incorrectToBeWrapped = "This text will be wrapped incorrectly. The test should pass if they are not equal.";
    private final String incorrectToBeWrappedExpected = "This text will\nbe wrapped incorrectly.\nThe test should\npass if they\nare not equal.\n";
    private final String shouldSplitOneBigWordToBeWrapped = "oneenormousandridiculouslylargewordthatisfake";
    private final String shouldSplitOneBigWordExpected = "oneen\normou\nsandr\nidicu\nlousl\nylarg\neword\nthati\nsfake\n";
    private final String shouldSplitBigWordsToBeWrappd = "Fortuitously, this paragraph accommodates some large letter designations, and small words. The aim is to corroborate the functionality of the wrap function when filled with many words, large and small.";
    private final String shouldSplitBigWordsExpected = "Fortuitous\nly, this\nparagraph\naccommodat\nes some\nlarge\nletter\ndesignatio\nns, and\nsmall\nwords. The\naim is to\ncorroborat\ne the\nfunctional\nity of the\nwrap\nfunction\nwhen\nfilled\nwith many\nwords,\nlarge and\nsmall.\n";


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
    public void shouldSplitOneBigWordEveryFiveChars() {
        String actual = WordWrapper.wrap(shouldSplitOneBigWordToBeWrapped, 5);
        assertEquals(shouldSplitOneBigWordExpected, actual);
    }

    @Test
    public void shouldSplitManyBigWordsEveryFiveChars() {
        String actual = WordWrapper.wrap(shouldSplitBigWordsToBeWrappd, 10);
        assertEquals(shouldSplitBigWordsExpected, actual);
    }
}