package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {
    /**
     * Given a string and a pattern, find out if the string contains any permutation of the pattern.
     * <p>
     * Permutation is defined as the re-arranging of the characters of the string.
     * For example, “abc” has the following six permutations:
     * <p>
     * abc
     * acb
     * bac
     * bca
     * cab
     * cba
     * If a string has ‘n’ distinct characters, it will have n!n! permutations.
     * <p>
     * Example 1:
     * <p>
     * Input: String="oidbcaf", Pattern="abc"
     * Output: true
     * Explanation: The string contains "bca" which is a permutation of the given pattern.
     * Example 2:
     * <p>
     * Input: String="odicf", Pattern="dc"
     * Output: false
     * Explanation: No permutation of the pattern is present in the given string as a substring.
     * Example 3:
     * <p>
     * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
     * Output: true
     * Explanation: Both the string and the pattern are a permutation of each other.
     * Example 4:
     * <p>
     * Input: String="aaacb", Pattern="abc"
     * Output: true
     * Explanation: The string contains "acb" which is a permutation of the given pattern.
     **/
    public static void main(String[] args) {
        System.out.println(findPermutation("oidbcaf", "abc"));
        System.out.println(findPermutation("odicf", "dc"));
        System.out.println(findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println(findPermutationV2("aaacb", "abc"));
    }

    /**
     * You are adding to a bag then checking it against another bag
     * <p>
     * But really if you filled up one bag, and go through the input
     * and removed when ever you saw a same val, then if the pattern was in
     * the bag, the bag would be zero which would mean the pattern exists in the input
     **/
    public static boolean findPermutation(String str, String pattern) {
        int start = 0;
        HashMap<Character, Integer> bag = new HashMap<>();
        HashMap<Character, Integer> bagTest = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            bagTest.put(pattern.charAt(i), bagTest.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            Character curVal = str.charAt(i);
            bag.put(curVal, bag.getOrDefault(curVal, 0) + 1);
            int curLength = i - start + 1;
            if (curLength > pattern.length()) {
                Character valToRemove = str.charAt(start);
                if (bag.get(valToRemove) == 1) {
                    bag.remove(valToRemove);
                } else {
                    bag.put(valToRemove, bag.get(valToRemove) - 1);
                }

                start++;
            }

            if (bag.size() == bagTest.size()) {
                boolean flag = true;
                for (Map.Entry<Character, Integer> entry : bagTest.entrySet()) {
                    if (!bag.containsKey(entry.getKey()) ||
                            (bag.containsKey(entry.getKey()) && bag.get(entry.getKey()) != entry.getValue())) {
                        flag = false;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }

    /**
     * Time complexity is O(N + M)
     * N cause your going through the input
     * M cause your going through the pattern
     * <p>
     * Space complexity is O(M): We have to put the pattern in a hashmap
     **/
    public static boolean findPermutationV2(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // we put nothing in the charFrequencyMap in this loop, we just inc or dec
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
                    matched++;
            }

            if (matched == charFrequencyMap.size())
                return true;

            if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    // this is the part that handles matches that happened a while ago
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    /**
                     * At the same time, if the character going out was part of the pattern,
                     * put it back in the frequency HashMap.
                     *
                     * because we are already fully taking it out
                     * **/
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return false;
    }
}
