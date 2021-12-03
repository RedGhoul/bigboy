package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * <p>
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * Example 2:
     * <p>
     * Input: strs = [""]
     * Output: [[""]]
     * Example 3:
     * <p>
     * Input: strs = ["a"]
     * Output: [["a"]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] consists of lowercase English letters.
     **/

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> bag = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String val = strs[i];


            char[] frequencyArr = new char[26];
            for (int x = 0; x < val.length(); x++) {
                frequencyArr[val.charAt(x) - 'a']++;
            }

            String key = new String(frequencyArr);
            if (bag.containsKey(key)) {
                List<String> values = bag.get(key);
                values.add(val);
            } else {
                List<String> values = new ArrayList<>();
                values.add(val);
                bag.put(key, values);
            }
        }
        List<List<String>> finalAns = new ArrayList<>();
        for (Map.Entry<String, List<String>> vals : bag.entrySet()) {
            finalAns.add(vals.getValue());
        }
        return finalAns;
    }
}
