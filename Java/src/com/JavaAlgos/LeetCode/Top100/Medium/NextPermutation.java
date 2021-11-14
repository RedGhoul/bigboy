package com.JavaAlgos.LeetCode.Top100.Medium;

public class NextPermutation {

    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     *
     * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
     *
     * The replacement must be in place and use only constant extra memory.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     * Example 2:
     *
     * Input: nums = [3,2,1]
     * Output: [1,2,3]
     * Example 3:
     *
     * Input: nums = [1,1,5]
     * Output: [1,5,1]
     * Example 4:
     *
     * Input: nums = [1]
     * Output: [1]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     * Accepted
     * 629,739
     * Submissions
     * 1,810,282
     * **/

    /**
     * So what we know:
     *
     * This is a permutations question - Do back tracking question
     *
     * " lexicographically next greater "
     * "lexicographically" means in terms of the order of their english representation
     *
     *  they are asking for the next greater permutation
     *
     *  And if you can't find that, then you need to sort the list back to sorted ascending order
     *
     *
     *  This is going to use some sort of two pointer technique since they want this done in place
     *
     *
     *  Not sure what's happening here. Still don't get "lexicographically order" for numbers.
     *  Their examples don't seem to make a lot of sense
     *
     *  what does "greater" lexicographically order even mean ?
     *
     *  I guess you should get the letters of the numbers on the fly ??
     *
     *
     *
     *  I guess ignore it the lexi stuff
     *
     *
     *  the default start order is always going to be decreasing
     *  if something is increasing decrease it
     *  if something is decreasing increase it
     *  https://www.youtube.com/watch?v=quAS1iydq7U&ab_channel=BackToBackSWE
     * state space increasing order
     *  you want to get to the point in the input where things are strictly decreasing
     *  then that number will be your start point
     *  then you have to figure out the state space leading up to that number, then swap it with the
     *  next following number from the state space where
     *  then order from lowest to highest everything after the number
     *
     *  Could I solve this ? Wasn't able to solve this at all, this was VERY WTF
     * */

    public void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
