package com.JavaAlgos.AlgoMonster;

import java.util.HashMap;

public class IsomorphicStrings {
    /**
     * Given two strings s and t, determine if they are isomorphic.
     * <p>
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     * <p>
     * All occurrences of a character must be replaced with another character while preserving
     * the order of characters. No two characters may map to the same character, but a character may map to itself.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "egg", t = "add"
     * Output: true
     * Example 2:
     * <p>
     * Input: s = "foo", t = "bar"
     * Output: false
     * Example 3:
     * <p>
     * Input: s = "paper", t = "title"
     * Output: true
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 5 * 104
     * t.length == s.length
     * s and t consist of any valid ascii character.
     * <p>
     * The main idea is test if these two things are different:
     * - in their char count - HashMap - You can actually use "Equals here"
     * Your building two indepent strings that count the number of times something appears
     * OR
     * - in what the chars are pointing to - use arrays as ordered hashmaps - and use chars are the keys
     **/

    public static String genUKString(String s) {
        HashMap<String, Integer> bag = new HashMap<>();
        String newStringToCompare = "";
        for (int i = 0; i < s.length(); i++) {
            String curVal = String.valueOf(s.charAt(i));
            if (!bag.containsKey(curVal)) {
                bag.put(curVal, i);
            }
            newStringToCompare = newStringToCompare + bag.get(curVal) + " ";
        }
        return newStringToCompare;
    }

    public boolean isIsomorphic(String s, String t) {
        return genUKString(s).equals(genUKString(t));
    }
}
