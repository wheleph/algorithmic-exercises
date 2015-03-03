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

        // reverse entire string (each word is going to be reversed)
        char[] reversedCharArray = reverse(input.toCharArray(), 0, input.length() - 1);

        // reverse each word again to make it correct
        int beginWordIndex = 0;
        for (int i = 0; i < reversedCharArray.length; i++) {
            if (reversedCharArray[i] == ' ') {
                reverse(reversedCharArray, beginWordIndex, i - 1);
                beginWordIndex = i + 1;
            }

            if (beginWordIndex > 0 && i == reversedCharArray.length - 1) {
                reverse(reversedCharArray, beginWordIndex, i);
            }
        }

        return new String(reversedCharArray);
    }

    private static char[] reverse(char[] input, int beginIndex, int endIndex) {
        int len = endIndex - beginIndex + 1;

        for (int i = beginIndex; i < beginIndex + len / 2; i++) {
            int j = endIndex - (i - beginIndex);
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }

        return input;
    }
}
