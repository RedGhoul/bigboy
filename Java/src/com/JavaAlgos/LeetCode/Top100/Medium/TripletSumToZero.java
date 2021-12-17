package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    /**
     * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
     * <p>
     * Example 1:
     * <p>
     * Input: [-3, 0, 1, 2, -1, 1, -2]
     * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
     * Explanation: There are four unique triplets whose sum is equal to zero.
     * Example 2:
     * <p>
     * Input: [-5, 2, -1, -2, 3]
     * Output: [[-5, 2, 3], [-2, -1, 3]]
     * Explanation: There are two unique triplets whose sum is equal to zero.
     * <p>
     * Re Cap:
     * So I was able to come up a O(N^2) complexity, but didn't implement it
     * because I thought there would be a solution with better time complexity.
     * I was right, you would have to sort the array first
     * <p>
     * <p>
     * The key idea for this question is MATH :(
     * But just straight algebra
     * So if you know that:
     * X + Y + Z = 0
     * and you are trying to find X, all you have to do is more the X to the other side
     * Y + Z = -X
     * <p>
     * So if you know your new target is "-X" than all you need to do is use the two sum method
     * to find Y and Z
     * <p>
     * Also avoid duplicates
     * Also remember to reduce your problem space every time you use a "X" candidate, since doing
     * stop you from getting duplicates
     * cause your going left to right to get candidates
     * <p>
     * Time: O(n^2) which is bigger than the O(n*log(n)) used in sort
     * Space: O(n) - Because we are storing a list of lists
     * array sort best case is O(n) space complexity
     **/

    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] != arr[i]) {
                // the reason we are doing i+1 as the start is because
                // we are already giving it arr[i] as target
                findTriplet(arr, i + 1, -arr[i], triplets);
            }
        }

        return triplets;
    }

    public static void findTriplet(int[] arr, int start, int target, List<List<Integer>> answer) {
        int end = arr.length - 1;
        while (start < end) { // this thing can run multiple times - A
            int curTarget = arr[start] + arr[end];
            if (curTarget == target) {
                answer.add(Arrays.asList(-target, start, end));
                // have to do this here
                // since it will move it onto a new part of the array that we can clear for dups
                // also case of A
                start++;
                end--;
                while (start < end && arr[start - 1] == arr[start]) {
                    start++;
                }
                while (start < end && arr[end + 1] == arr[end]) {
                    end--;
                }
            } else if (curTarget > target) {
                end--;
            } else {
                start++;
            }
        }
    }
}
