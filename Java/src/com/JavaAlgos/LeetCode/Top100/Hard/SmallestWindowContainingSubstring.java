package com.JavaAlgos.LeetCode.Top100.Hard;

import java.util.HashMap;

public class SmallestWindowContainingSubstring {
    /**
     * n = length of str
     * m = length of pattern
     * Time O(n + m) cause one loop after the other of diff sizes
     * Space O(m)
     * because we create a brand-new hash map of size m in the beginning
     **/
    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec", "abc"));
        System.out.println(findSubstring("abdbca", "abc"));
        System.out.println(findSubstring("adcad", "abc"));
    }

    /**
     * The key here is that its !!NOT!! ASKING FOR A PERMUTATION !!!
     * Its just asking for a sub string that contains the pattern
     * non contiguously as seen in the examples given
     **/
    public static String findSubstring(String str, String pattern) {
        int start = 0;
        int matched = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        String finalAnswer = "";
        HashMap<Character, Integer> bag = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character curVal = pattern.charAt(i);
            bag.put(curVal, bag.getOrDefault(curVal, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            Character curVal = str.charAt(i);
            if (bag.containsKey(curVal)) {
                bag.put(curVal, bag.get(curVal) - 1);
                // Point A
                if (bag.get(curVal) >= 0) { // count everything that isn't a neg
                    // cause technically we saw this and its already in the bag
                    matched++;
                }
            }
            /**
             * Doing this for two reasons
             *
             * 1) cause of what we do at point A, we count every thing in the bag we re see as a match
             *
             * 2) cause of 1) we count any doubles in the pattern so we have to be the same length as the pattern
             *
             * 3) we found all our matches and are moving the start to the left to shrink our window
             * **/
            while (matched == pattern.length()) {
                /**
                 * Here is where the magic happens
                 * We record the minLength
                 * We record the current start
                 * **/
                int curLength = i - start + 1;
                if (minLength > curLength) {
                    minLength = curLength;
                    minStart = start;
                }

                Character thingToRemove = str.charAt(start);
                if (bag.containsKey(thingToRemove)) {
                    /**
                     * We are doing this here to alert us when we have gone too far into
                     * the sub array that has the chars we are looking for
                     *
                     * We do this by reducing the match when we get to something that has a match of zero
                     * which means it was already counted
                     *
                     * And reducing the matched will bring us out of the loop
                     * **/
                    if (bag.get(thingToRemove) == 0) {
                        matched--;
                    }
                    bag.put(thingToRemove, bag.get(thingToRemove) + 1);
                }
                start++;
            }
        }
        // here is the other magic we just use the substring func to generate the return string
        return minLength > str.length() ? "" : str.substring(minStart, minStart + minLength);
    }
}
