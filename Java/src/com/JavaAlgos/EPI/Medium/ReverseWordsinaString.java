package com.JavaAlgos.EPI.Medium;

public class ReverseWordsinaString {
    /**
     * Given an input string s, reverse the order of the words.
     * <p>
     * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
     * <p>
     * Return a string of the words in reverse order concatenated by a single space.
     * <p>
     * Note that s may contain leading or trailing spaces or multiple spaces between two words.
     * The returned string should only have a single space separating the words. Do not include any extra spaces.
     * <p>
     * Example 1:
     * <p>
     * Input: s = "the sky is blue"
     * Output: "blue is sky the"
     * Example 2:
     * <p>
     * Input: s = "  hello world  "
     * Output: "world hello"
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     * Example 3:
     * <p>
     * Input: s = "a good   example"
     * Output: "example good a"
     * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     * Example 4:
     * <p>
     * Input: s = "  Bob    Loves  Alice   "
     * Output: "Alice Loves Bob"
     * Example 5:
     * <p>
     * Input: s = "Alice does not even like bob"
     * Output: "bob like even not does Alice"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 104
     * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
     * There is at least one word in s.
     * <p>
     * <p>
     * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
     * <p>
     * the dog 1 the gold
     * gold the 1 dog the
     * <p>
     * WTF THIS IS TWO POINTER PROBLEM
     * <p>
     * Long and short of this is:
     * <p>
     * Reverse the whole string
     * Reverse each of the words in the string
     * Get rid of the spaces
     **/

    public String reverseWords(String s) {
        String[] sWords = s.split(" ");
        String outPutString = "";

        for (int i = sWords.length - 1; i >= 0; i--) {
            String curVal = sWords[i];
            if (curVal == " ") continue;
            curVal = curVal.trim();
            outPutString = outPutString + curVal + " ";
        }

        return outPutString.trim();
    }
}
