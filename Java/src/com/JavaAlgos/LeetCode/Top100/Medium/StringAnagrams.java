package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringAnagrams {
    /**
     * Given a string and a pattern, find all anagrams of the pattern in the given string.
     * <p>
     * Every anagram is a permutation of a string. As we know, when we are not allowed to repeat characters
     * while finding permutations of a string, we get N!N! permutations (or anagrams) of a string having NN characters.
     * For example, here are the six anagrams of the string “abc”:
     * <p>
     * abc
     * acb
     * bac
     * bca
     * cab
     * cba
     * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
     * <p>
     * Example 1:
     * <p>
     * Input: String="ppqp", Pattern="pq"
     * Output: [1, 2]
     * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
     * Example 2:
     * <p>
     * Input: String="abbcabc", Pattern="abc"
     * Output: [2, 3, 4]
     * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
     * <p>
     * m = length of pattern
     * n = length of input
     * Time complexity: O(n+m)
     * Space is: O(m)
     **/
    public static void main(String[] args) {
        //System.out.println(findStringAnagrams("ppqp","pq"));
        System.out.println(findStringAnagrams("abbcabc", "abc"));
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int start = 0;
        int match = 0;
        HashMap<Character, Integer> bag = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            bag.put(pattern.charAt(i), bag.getOrDefault(pattern.charAt(i), 0) + 1);
        }
// String="ppqp", Pattern="pq"
        for (int i = 0; i < str.length(); i++) {
            Character curVal = str.charAt(i);
            if (bag.containsKey(curVal)) {
                bag.put(curVal, bag.get(curVal) - 1);
                if (bag.get(curVal) == 0) {
                    match++;
                }
            }

            if (match == bag.size()) {
                resultIndices.add(start);
            }

            if (i >= pattern.length() - 1) {
                Character thingToRemove = str.charAt(start);
                /**
                 * So if it is equal to zero we are just removing from the matched
                 * since we want to forget about ever finding it. Since we are moving out window up
                 * Then further below we are re setting it to 1
                 * **/
                if (bag.get(thingToRemove) == 0) {
                    match--;
                }
                /**
                 * So we add back the one we took out
                 * If we had a double than in the first pattern length this would just
                 * take it out and put back a zero. Which would tell us that oh we
                 * already have found since its a double, but not back it negative
                 * **/

                bag.put(thingToRemove, bag.get(thingToRemove) + 1);
                start++;
            }

        }
        return resultIndices;
    }
}
