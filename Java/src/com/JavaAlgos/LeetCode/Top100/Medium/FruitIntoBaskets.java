package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.HashMap;

public class FruitIntoBaskets {
    /**
     * You are visiting a farm that has a single row of fruit trees arranged from left to right.
     * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
     * <p>
     * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
     * <p>
     * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount
     * of fruit each basket can hold.
     * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
     * while moving to the right. The picked fruits must fit in one of your baskets.
     * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
     * Given the integer array fruits, return the maximum number of fruits you can pick.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: fruits = [1,2,1]
     * Output: 3
     * Explanation: We can pick from all 3 trees.
     * Example 2:
     * <p>
     * Input: fruits = [0,1,2,2]
     * Output: 3
     * Explanation: We can pick from trees [1,2,2].
     * If we had started at the first tree, we would only pick from trees [0,1].
     * Example 3:
     * <p>
     * Input: fruits = [1,2,3,2,2]
     * Output: 4
     * Explanation: We can pick from trees [2,3,2,2].
     * If we had started at the first tree, we would only pick from trees [1,2].
     * Example 4:
     * <p>
     * Input: fruits = [3,3,3,1,2,1,1,2,3,3,4]
     * Output: 5
     * Explanation: We can pick from trees [1,2,1,1,2].
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= fruits.length <= 105
     * 0 <= fruits[i] < fruits.length
     * <p>
     * THIS IS THE GORKKING Description, get to the point a lot faster:
     * Given an array of characters where each character represents a fruit tree, you are given two baskets,
     * and your goal is to put maximum number of fruits in each basket. The only restriction is that each
     * basket can have only one type of fruit.
     * <p>
     * You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from
     * each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
     * <p>
     * Write a function to return the maximum number of fruits in both baskets.
     * <p>
     * Another way of saying it : Longest Substring with at most 2 distinct characters
     * <p>
     * Reflection:
     * You knew how to do this one, but didn't think it all the way through
     * ALWAYS RUN THROUGH AN EXAMPLE
     * <p>
     * Since "K" in this question will always be 2 since you can only every have two baskets
     * Your space complexity will always be O(1), since you always allocate 2 baskets (keys) for the hash map
     * Your time complexity would always be O(n) since you go through each element one at a time (can consider
     * the inner while loop & for loop to be separate loops in succession)
     **/
    public static void main(String[] args) {
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println(findLength(new char[]{'A', 'A', 'B', 'C', 'B', 'B', 'C'}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));


    }

    public static int findLength(char[] arr) {
        if (arr == null) return -1;
        HashMap<Character, Integer> bagOfBaskets = new HashMap<>();
        int maxNumberOfFruits = 0;
        int curNumberOfFruits = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            Character curChar = arr[i];
            curNumberOfFruits = curNumberOfFruits + 1;
            if (bagOfBaskets.containsKey(curChar)) {
                bagOfBaskets.put(curChar, bagOfBaskets.get(curChar) + 1);
            } else {
                bagOfBaskets.put(curChar, 1);
            }

            while (bagOfBaskets.size() > 2) {
                /**
                 * you keep going right thats why you don't need to take out the whole key
                 * If you take out the whole key worth of values, you will also need to properly increment
                 * your start pointer forward properly which is hard / "you don't know how to do"
                 * **/
                Character curCharToRemove = arr[start];
                if (bagOfBaskets.get(curCharToRemove) == 1) {
                    bagOfBaskets.remove(curCharToRemove);
                } else {
                    bagOfBaskets.put(curCharToRemove, bagOfBaskets.get(curCharToRemove) - 1);
                }

                start++;
            }
            maxNumberOfFruits = Math.max(maxNumberOfFruits, i - start + 1);
        }

        return maxNumberOfFruits;
    }

    // this is the solution to the leet code version of the problem
    // where instead of a char array they give you an int array
    public static int totalFruit(int[] fruits) {
        if (fruits == null) return -1;
        HashMap<Integer, Integer> bagOfBaskets = new HashMap<>();
        int maxNumberOfFruits = 0;
        int curNumberOfFruits = 0;
        int start = 0;
        for (int i = 0; i < fruits.length; i++) {
            Integer curChar = fruits[i];
            curNumberOfFruits = curNumberOfFruits + 1;
            if (bagOfBaskets.containsKey(curChar)) {
                bagOfBaskets.put(curChar, bagOfBaskets.get(curChar) + 1);
            } else {
                bagOfBaskets.put(curChar, 1);
            }

            while (bagOfBaskets.size() > 2) {
                /**
                 * you keep going right thats why you don't need to take out the whole key
                 * If you take out the whole key worth of values, you will also need to properly increment
                 * your start pointer forward properly which is hard / "you don't know how to do"
                 * **/
                Integer curCharToRemove = fruits[start];
                if (bagOfBaskets.get(curCharToRemove) == 1) {
                    bagOfBaskets.remove(curCharToRemove);
                } else {
                    bagOfBaskets.put(curCharToRemove, bagOfBaskets.get(curCharToRemove) - 1);
                }

                start++;
            }
            maxNumberOfFruits = Math.max(maxNumberOfFruits, i - start + 1);
        }

        return maxNumberOfFruits;
    }
}
