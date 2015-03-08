package wheleph.algorithmic_exercises.strings;

public class ReverseWords {

    /**
     * PROBLEM  Write a function that reverses the order of the words in a string. For
     * example, your function should transform the string "Do or do not, there is no
     * try." to "try. no is there not, do or Do". Assume that all words are space
     * delimited and treat punctuation the same as letters.
     */
    public static String reverseWords(String input) {
        if (input == null) {
            return null;
        }

        char[] charArray = input.toCharArray();

        // reverse entire string (each word is going to be reversed)
        reverse(charArray, 0, input.length() - 1);

        // reverse each word again to make it correct
        int beginWordIndex = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                reverse(charArray, beginWordIndex, i - 1);
                beginWordIndex = i + 1;
            }

            if (beginWordIndex > 0 && i == charArray.length - 1) {
                reverse(charArray, beginWordIndex, i);
            }
        }

        return new String(charArray);
    }

    private static void reverse(char[] charArray, int beginIndex, int endIndex) {
        int len = endIndex - beginIndex + 1;

        for (int i = beginIndex; i < beginIndex + len / 2; i++) {
            int j = endIndex - (i - beginIndex);
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
    }
}
