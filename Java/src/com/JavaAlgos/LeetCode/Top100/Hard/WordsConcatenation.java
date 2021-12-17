package com.JavaAlgos.LeetCode.Top100.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsConcatenation {
    /**
     * Given a string and a list of words, find all the starting indices of substrings in the given string that
     * are a concatenation of all the given words exactly once without any overlapping of words.
     * It is given that all words are of the same length.
     * <p>
     * Example 1:
     * <p>
     * Input: String="catfoxcat", Words=["cat", "fox"]
     * Output: [0, 3]
     * Explanation: The two substring containing both the words are "catfox" & "foxcat".
     * Example 2:
     * <p>
     * Input: String="catcatfoxfox", Words=["cat", "fox"]
     * Output: [3]
     * Explanation: The only substring containing both the words is "catfox".
     **/
    public static void main(String[] args) {
        System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));
    }

    public static List<Integer> findWordConcatenationv2(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int start = 0;
        int wordSize = words[0].length();
        int matched = 0;
        HashMap<String, Integer> bag = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            bag.put(words[i], bag.getOrDefault(words[i], 0) + 1);
        }

        for (int i = 0; i < str.length(); i += 3) {
            String curVal = str.substring(i, wordSize);
            if (bag.containsKey(curVal)) {
                bag.put(curVal, bag.get(curVal) - 1);
                if (bag.get(curVal) == 0) {
                    matched++;
                }
            }

            if (matched == bag.size()) {
                resultIndices.add(start);
            }

            if (i > bag.size()) {
                String curValToRemove = str.substring(start, wordSize);
                if (bag.containsKey(curValToRemove)) {
                    if (bag.get(curValToRemove) == 0) {
                        matched--;
                    }
                    bag.put(curValToRemove, bag.get(curValToRemove) + 1);
                }
            }
        }

        return resultIndices;
    }

    /**
     * Its pretty deep
     * <p>
     * but here we go index by index, and we try to find the words for it
     * use two hashmaps
     * one for recording what we need
     * second for using as a temp for how many times we have seen it for this index
     * <p>
     * double for loop
     * n = number of chars in str
     * m = number of words
     * len = size of each word
     * Time Complexity: O(n * m * len)
     * Space Complexity: O(n+m) Cause of the two hashmaps
     **/
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words)
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);

        List<Integer> resultIndices = new ArrayList<Integer>();
        int wordsCount = words.length, wordLength = words[0].length();

        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                // get the next word from the string
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!wordFrequencyMap.containsKey(word)) // break if we don't need this word
                    break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1); // add the word to the 'wordsSeen' map

                // no need to process further if the word has higher frequency than required
                // this for the case when you have doubles of a word in succession
                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0))
                    break;

                /**
                 * This works since every time you increment J you are moving on to a brand-new word
                 * And if you can move to a brand new word, that means you found the word
                 * so you can add the index of the start of the word
                 *
                 * we use J since J increments every time over the word count
                 * now if reached the worked
                 * that means we matched all the words from the start index
                 * and then we store the start index
                 * the start index is "i"
                 * **/
                if (j + 1 == wordsCount) // store index if we have found all the words
                    resultIndices.add(i);
            }
        }

        return resultIndices;
    }
}
