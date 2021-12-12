package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    /**
     * Given a string, find the length of the longest substring in it with no more than K distinct characters.
     * <p>
     * Example 1:
     * <p>
     * Input: String="araaci", K=2
     * Output: 4
     * Explanation: The longest substring with no more than '2' distinct characters is "araa".
     * Example 2:
     * <p>
     * Input: String="araaci", K=1
     * Output: 2
     * Explanation: The longest substring with no more than '1' distinct characters is "aa".
     * Example 3:
     * <p>
     * Input: String="cbbebi", K=3
     * Output: 5
     * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
     * Example 4:
     * <p>
     * Input: String="cbbebi", K=10
     * Output: 6
     * Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".
     * <p>
     * SO YOU GOT THIS ON YOUR FIRST TRY YAY
     * <p>
     * Time complexity O(n) look at "MinimumSizeSubarraySum" for more info
     * Space Complexity O(K+1) where at max we can hold K + 1 since there con only be a max of K
     * unique Chars in the candidate string before we can try to remove them.
     * So really its O(K)
     **/
    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
        System.out.println(findLength("araaci", 1));
        System.out.println(findLength("cbbebi", 3));
        System.out.println(findLength("cbbebi", 10));
    }

    public static int findLength(String str, int k) {
        if (str == null || str.isEmpty()) return 0;
        if (k == 1 && str.length() == 1) return 1;

        HashMap<String, Integer> bag = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            String curVal = String.valueOf(str.charAt(i));
            if (bag.containsKey(curVal)) {
                bag.put(curVal, bag.get(curVal) + 1);
            } else {
                bag.put(curVal, 1);
            }

            while (bag.size() > k) {

                String curValStart = String.valueOf(str.charAt(start));
                if (bag.get(curValStart) == 1) {
                    bag.remove(curValStart);
                } else {
                    bag.put(curValStart, bag.get(curValStart) - 1);
                }
                start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
