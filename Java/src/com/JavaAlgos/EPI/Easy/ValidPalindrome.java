package com.JavaAlgos.EPI.Easy;

public class ValidPalindrome {
    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
     * non-alphanumeric characters, it reads the same forward and backward.
     * Alphanumeric characters include letters and numbers.
     * <p>
     * Given a string s, return true if it is a palindrome, or false otherwise.
     * <p>
     * Example 1:
     * <p>
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * Example 2:
     * <p>
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     * Example 3:
     * <p>
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 2 * 105
     * s consists only of printable ASCII characters.
     * <p>
     * First of all don't rush
     * Second of all the hardest thing about easy questions, is that they have some weird
     * edge cases that you have to ask about or make sure are explained
     **/

    public boolean isPalindrome(String s) {
        // basic checks
        if (s == null) return false;
        if (s.length() == 0) return true;
        if (s.length() == 1 && !Character.isLetterOrDigit(s.charAt(0))) return true;
        // do cleaning of the string
        char[] inputArray = s.toLowerCase().toCharArray();

        int p1 = 0;
        int p2 = inputArray.length - 1;
        while (p1 < p2) {
            char leftChar = inputArray[p1];
            char rightChar = inputArray[p2];

            if (!Character.isLetterOrDigit(leftChar)) {
                p1++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                p2--;
            } else {
                if (leftChar != rightChar) return false;
                p1++;
                p2--;
            }
        }

        return true;
    }

}
