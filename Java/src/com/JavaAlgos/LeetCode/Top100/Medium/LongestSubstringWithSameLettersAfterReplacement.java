package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.HashMap;

public class LongestSubstringWithSameLettersAfterReplacement {
    /**
     * Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any
     * letter, find the length of the longest substring having the same letters after replacement.
     **/

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
        System.out.println(findLength("abbcb", 1));
        System.out.println(findLength("abccde", 1));
    }

    public static int findLength(String str, int k) {
        int maxLength = 0;
        int start = 0;
        int maxRepeatLetterCount = 0;
        HashMap<Character, Integer> bag = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character curVal = str.charAt(i);
            if (bag.containsKey(curVal)) {
                bag.put(curVal, bag.get(curVal) + 1);

            } else {
                bag.put(curVal, 1);
            }
            // for this current window there are this many sames
            // based on the i index
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, bag.get(curVal));
            /**
             * Here is the trick part.
             * the question said that we can replace no more than K letters to make k letters the same as
             * the rest of the stuff in the window
             * That means that if we keep track of the number of same things we saw then
             * length of window - curSames > K
             * (number of different things) > (number of things you can replace to make the same)
             * you have to move your start pointer
             * **/
            int windowLen = i - start + 1;
            int numberOfDiffThings = windowLen - maxRepeatLetterCount;
            if (numberOfDiffThings > k) {
                Character curValToRemove = str.charAt(start);
                bag.put(curValToRemove, bag.get(curValToRemove) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
