package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    /**
     * Given an array of unsorted numbers and a target number, find a triplet in the array whose
     * sum is as close to the target number as possible, return the sum of the triplet. If there are
     * more than one such triplet, return the sum of the triplet with the smallest sum.
     * <p>
     * Example 1:
     * <p>
     * Input: [-2, 0, 1, 2], target=2
     * Output: 1
     * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
     * Example 2:
     * <p>
     * Input: [-3, -1, 1, 2], target=1
     * Output: 0
     * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
     * Example 3:
     * <p>
     * Input: [1, 0, 1, 1], target=100
     * Output: 3
     * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
     * <p>
     * Time: O(N^2)
     * Space: O(1)
     **/
    public static void main(String[] args) {
        //System.out.println(searchTriplet(new int[]{-2, 0, 1, 2},2));
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }


    /**
     * Its kind of like the last problem,
     * expect you are looking for the over all diff to be as small as possible
     **/
    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 3)
            throw new IllegalArgumentException();

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) { // -2 since we are coming in from two diff sides
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                // comparing the sum of three numbers to the 'targetSum' can cause overflow
                // so, we will try to find a target difference
                // (   S1   )  (   S2  )
                // X + Y + Z = targetSum
                // now you are subtracting from one side and the other
                //                    S1                     S2
                int targetDiff = (targetSum) - (arr[i] - arr[left] - arr[right]);
                if (targetDiff == 0) //  we've found a triplet with an exact sum
                    return targetSum - targetDiff; // return sum of all the numbers

                // the second part of the above 'if' is to handle the smallest sum when we have more than one solution
                // now we are trying to find the smallest diff
                if (Math.abs(targetDiff) < Math.abs(smallestDifference)
                        // doing the second case for when smallest diff is neg but still equal to abs target diff
                        || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference))
                    smallestDifference = targetDiff; // save the closest and the biggest difference

                /**
                 * If the target diff is too big (ideally you want it to be close to zero as possible)
                 * then you have to increate the S2 Side and the only way you can do that is by
                 * increasing the left
                 * **/
                if (targetDiff > 0)
                    left++; // we need a triplet with a bigger sum
                else
                    right--; // we need a triplet with a smaller sum
                // now target diff is too small you have to reduce S2 by removing the biggest thing there
            }
        }
        // finally, we return the SUM which is just the target minus the smallest diff we could find
        // smallestDiff = target - x - y - z
        // so to return the sum all you need to do is: smallestDiff - target = the actual sum of X, Y Z
        return targetSum - smallestDifference;
    }


    public static int searchTriplet2(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] != arr[i - 1]) {

                int curSum2 = searchTripletHelper(arr, i + 1, targetSum - arr[i]);
                int curSum = curSum2 + arr[i];
                if (curSum < closestSum) {
                    closestSum = curSum;
                }
            }
        }
        return closestSum;
    }

    public static int searchTripletHelper(int[] arr, int start, int target) {
        int end = arr.length - 1;
        int curSum = 0;
        while (start < end) {
            curSum = arr[start] + arr[end];
            if (curSum == target) return curSum;
            if (curSum > target) {
                end--;
            } else {
                start++;
            }
        }
        return curSum;
    }


}
