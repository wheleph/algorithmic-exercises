package wheleph.algorithmic_exercises.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsTest {

    @Test
    public void testEmptyString() {
        String reversed = ReverseWords.reverseWords("");
        assertEquals("", reversed);
    }

    @Test
    public void testNullString() {
        String reversed = ReverseWords.reverseWords(null);
        assertNull(reversed);
    }

    @Test
    public void testSingleWordEven() {
        String reversed = ReverseWords.reverseWords("abcd");
        assertEquals("dcba", reversed);
    }

    @Test
    public void testSingleWordOdd() {
        String reversed = ReverseWords.reverseWords("abcde");
        assertEquals("edcba", reversed);
    }

    @Test
    public void testMultipleWords() {
        String reversed = ReverseWords.reverseWords("Do or do not, there is no try.");
        assertEquals("try. no is there not, do or Do", reversed);
    }
}