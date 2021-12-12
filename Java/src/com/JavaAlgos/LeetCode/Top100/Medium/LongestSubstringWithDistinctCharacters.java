package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistinctCharacters {
    /**
     * Given a string, find the length of the longest substring, which has all distinct characters.
     * <p>
     * Example 1:
     * <p>
     * Input: String="aabccbb"
     * Output: 3
     * Explanation: The longest substring with distinct characters is "abc".
     * Example 2:
     * <p>
     * Input: String="abbbb"
     * Output: 2
     * Explanation: The longest substring with distinct characters is "ab".
     * Example 3:
     * <p>
     * Input: String="abccde"
     * Output: 3
     * Explanation: Longest substrings with distinct characters are "abc" & "cde".
     * <p>
     * afabccbb
     * <p>
     * Time Complexity: O(N)
     * Space Complexity: O(K) where K is the number of distinct Chars
     * but then worst case everything is unqiue
     * So I am just going to say O(N)
     * OOOORRRR
     * We can say that really this is  Space Complexity: O(1) since we just use letters and nothing else
     * So there are only ever going to be 24 letter
     * So we can just per allocate 24 key hashmap
     **/

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb"));
        System.out.println(findLength("abbbb"));
        System.out.println(findLength("abccde"));
        System.out.println(findLength("afabccbb"));
    }

    public static int findLengthAva(String str) {
        if (str == null || str.isEmpty()) return -1;
        int maxLen = 0;
        int start = 0;
        HashMap<Character, Integer> bag = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character curVal = str.charAt(i);
            if (bag.containsKey(curVal)) {
                bag.put(curVal, bag.get(curVal) + 1);
            } else {
                bag.put(curVal, 1);
            }

            while (bag.containsKey(curVal) && bag.get(curVal) > 1) {
                Character curValToRemove = str.charAt(start);
                if (bag.get(curValToRemove) == 1) {
                    bag.remove(curValToRemove);
                } else {
                    bag.put(curValToRemove, bag.get(curValToRemove) - 1);
                }
                start++;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if (charIndexMap.containsKey(rightChar)) { // at this point we found a double
                /**
                 * We just found a double, So where should we put the start ??
                 * We can skip over everything and just put it 1 plus where the last double was
                 * But then what if we are already passed where the last double was ???
                 * Okay then just use our current value.
                 *
                 * Cause we don't have any double and add one logic to what we do with our hash map
                 * Happens when
                 * abcgdefdg
                 * when your at d you move to d, but then you see g
                 * but g index is behind where we are so you just set your self to the same
                 *  **/
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            // we just put in where the new index is
            charIndexMap.put(rightChar, windowEnd);
            // and then we just try to find the new length.
            // the only thing that effects the length is where the windowStart is
            // windowStart only moves if we found a double and the doubles index is bigger
            // than the last windowStart value
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
