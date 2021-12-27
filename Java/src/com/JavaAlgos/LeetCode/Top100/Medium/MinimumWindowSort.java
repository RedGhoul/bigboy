package com.JavaAlgos.LeetCode.Top100.Medium;

public class MinimumWindowSort {
    /**
     * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
     *Example 1:
     *
     * Input: [1, 2, 5, 3, 7, 10, 9, 12]
     * Output: 5
     * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
     * Example 2:
     *
     * Input: [1, 3, 2, 0, -1, 7, 10]
     * Output: 5
     * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
     * Example 3:
     *
     * Input: [1, 2, 3]
     * Output: 0
     * Explanation: The array is already sorted
     * Example 4:
     *
     * Input: [3, 2, 1]
     * Output: 3
     * Explanation: The whole array needs to be sorted.
     *
     * Initial Thoughts:
     * There is only one section we need to sort, to make the whole thing sorted
     * I am thinking use a for loop to place a pointer for the start and end of the sub array
     * then return the diff between the two pointers to get the length
     * but how do find the start and the end of what needs to be sorted ?
     *
     * After looking at the solution:
     * I think I got to 25% of the solution
     *
     * Actual Solution:
     *
     * Find the two ends
     * low going from front to back,
     * high going from back to front
     *
     * find max and min in between low & high
     *
     * use that max and min to adjust where the low & high are pointing to
     * as in if there is something bigger than the min of the subarray on the left include it
     * if there is something smaller than the max of the subarray on the right include it
     * we do these two things above since we need to give a length such that if everything between it
     * is SORTED then the WHOLE array is SORTED
     *
     * If we didn't do that, then we would end up with unsorted values beyond the low & high pointers
     * when everything between the low and high pointers was sorted.
     *
     * Thus the whole array won't be sorted therefore it would be the wrong answer
     *
     * Time complexity is O(N)
     * Space complexity is O(1)
     * **/
}
