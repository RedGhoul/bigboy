package com.JavaAlgos.EPI.Easy;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    /**
     * Given a string, determine if a permutation of the string could form a palindrome.
     * <p>
     * Example 1:
     * <p>
     * Input: "code"
     * Output: false
     * Example 2:
     * <p>
     * Input: "aab"
     * Output: true
     * Example 3:
     * <p>
     * Input: "carerac"
     * Output: true
     * <p>
     * there should be chars that have an even count
     * if the length is odd
     * there should be only one char that has an odd count
     * <p>
     * loop to count all the number of chars in the string put in hash map
     * number of not evens
     * loop to through hash map
     * if the count is not even
     * number of not evens inc by 1
     * <p>
     * if s.length % 2 == 0 and number of not evens > 0:
     * return false
     * <p>
     * else evens == 1
     * return true
     * <p>
     * return true;
     **/

    public static boolean isPermutationPalindromic(String s) {
        if (s == null || s.isBlank()) return false;

        Set<Character> bag = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curVal = s.charAt(i);
            if (!bag.contains(curVal)) {
                bag.add(curVal);
            } else {
                bag.remove(curVal);
            }
        }

        return bag.size() <= 1;
    }


}
