package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    public static void main(String[] args){
        System.out.println(Arrays.toString(letterCombinations("23").toArray()));
    }

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
     *
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     *
     *
     *
     *
     * Example 1:
     *
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * Example 2:
     *
     * Input: digits = ""
     * Output: []
     * Example 3:
     *
     * Input: digits = "2"
     * Output: ["a","b","c"]
     *
     *
     * Constraints:
     *
     * 0 <= digits.length <= 4
     * digits[i] is a digit in the range ['2', '9'].
     *
     *
     * What we know:
     * this is some sort of combination problem
     * this is more than likely some type of back tracking problem
     *
     * You just need to comb everything from one list with everything else
     *
     * a combo d
     * a combo e
     * a combo f
     * you are just going from one value in one array to another value in another array
     * in a very methodical way
     *
     * So you got to think about this is as sort of tree like what you saw in those DP videos
     *
     * So you should draw out a tree. It doesn't need to encompass the whole problem at once.
     * Rather it should just to go through a specific case. Like what happens if you get "23"
     * and you start with "2" ?
     *
     *                                   start(2)
     *
     *                               a      b     c
     * where the 3 would come in (d  e  f)
     *
     * then it would go further down if we add another value to the input
     *
     * So just from looking at this we can see that:
     * - Each number in the input becomes a layer of the tree
     * - so the depth of the tree aka the space complexity becomes O(n)
     *
     * - the time compelexity of the tree is determined by home much works is done aka how many nodes
     * the tree ends up having.
     * - If you look at the question carefully you end up seeing that the worst case is for "9" which has 4 chars
     * So WORST case if we started with 9 we would end up having spans of 4
     * - so the time complexity would end up being O(4^n)
     *
     *
     * WHY WOULD YOU EVEN CALL THIS BACK TRACKING ???????????????????????
     *
     * Well you are finding all the combinations by going down a path
     * THEN going back (aka BACKTRACKING) then repeating the same thing
     * down another path. TO do an exhaustive search
     *
     * Could I solve this ? no way had to look at youtube video
     * **/

    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if(digits == null || digits.length() == 0) return results;
        letterCombHelper(results,0,"",digits);
        return results;
    }

    public static void letterCombHelper(List<String> results, int currentIndexOfDigits,String currentString, String inputDigits){
        if(currentIndexOfDigits == inputDigits.length()){ // we do this to check if we have gotten to the end of one
            // of the nodes, as described in the huge write-up above.
            results.add(currentString);
            return;
        }

        // we are starting our descent into the tree
        // get the first node of the first span get to the first layer
        int indexOfLetters = inputDigits.charAt(currentIndexOfDigits)-'0'; // the way to convert a char to an int;
        char[] spanOfChars = KEYS[indexOfLetters].toCharArray();
        for(int i = 0; i < spanOfChars.length; i++){
            String temp = currentString + String.valueOf(spanOfChars[i]); // you don't want to directly set anything
            // because it will alter the value for the other recursive calls
            // we are going to another layer further down
            letterCombHelper(results,currentIndexOfDigits + 1,temp,inputDigits);
        }
    }

}

