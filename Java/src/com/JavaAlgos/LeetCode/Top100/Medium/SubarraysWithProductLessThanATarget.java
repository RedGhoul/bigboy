package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubarraysWithProductLessThanATarget {
    /**
     * Given an array with positive numbers and a positive target number, find all of its contiguous
     * subarrays whose product is less than the target number.
     * <p>
     * Example 1:
     * <p>
     * Input: [2, 5, 3, 10], target=30
     * Output: [2], [5], [2, 5], [3], [5, 3], [10]
     * Explanation: There are six contiguous subarrays whose product is less than the target.
     * Example 2:
     * <p>
     * Input: [8, 2, 6, 5], target=50
     * Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
     * Explanation: There are seven contiguous subarrays whose product is less than the target.
     * <p>
     * They say contiguous subarrays so I guess they don't allow sorting
     * They don't give the max amount of things you can sum
     * Is a double for loop each pointing to a diff part of the array the answer ??
     * I think I was right
     * <p>
     * Time: O(N^3) cause copying over an array takes O(n) time, and we already have a double for loop
     * Space: O(N) <- this is what I thought
     * <p>
     * <p>
     * But when you are storing lists of lists it's going to be O(N^2)
     * But then worst case each list in the list of list could have O(N) space
     * Then your actual time complexity becomes O(n^3)
     **/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSubarrays(new int[]{2, 5, 3, 10}, 30).toArray()));
        System.out.println(Arrays.toString(findSubarrays(new int[]{8, 2, 6, 5}, 50).toArray()));
    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        // for loop one, first pointer
        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i]);
            subarrays.add(temp);
            temp = new ArrayList<>(temp);
            int curSum = arr[i];
            // for loop 2
            for (int j = i + 1; j < arr.length; j++) {
                curSum = curSum * arr[j];
                if (curSum < target) {
                    temp.add(arr[j]);
                    subarrays.add(temp);
                    temp = new ArrayList<>(temp);
                }
                // add to the list as long as the sum is less than target
            }

        }

        return subarrays;
    }

    /**
     * You keep going forward till your too big
     * // calling this part B
     * each time you go forward, and if your product is less than target
     * add everything from right to left to the result array
     * <p>
     * as soo as you become equal too or greater than the target, remove the number
     * from the product going from left to right till
     * you become smaller than the target
     * <p>
     * then do part B
     **/

    public static List<List<Integer>> findSubarraysGORK(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        double product = 1;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left < arr.length)
                product /= arr[left++];
            // since the product of all numbers from left to right is less than the target therefore,
            // all subarrays from left to right will have a product less than the target too; to avoid
            // duplicates, we will start with a subarray containing only arr[right] and then extend it
            List<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }

}
