package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.Arrays;

public class TripletsWithSmallerSum {
    /**
     * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that
     * arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
     * Write a function to return the count of such triplets.
     * <p>
     * Example 1:
     * <p>
     * Input: [-1, 0, 2, 3], target=3
     * Output: 2
     * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
     * Example 2:
     * <p>
     * Input: [-1, 4, 2, 1, 3], target=5
     * Output: 4
     * Explanation: There are four triplets whose sum is less than the target:
     * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
     * <p>
     * YOU were on the right track, actually did it right.
     * However you did 100% understand the question. It didn't case about doubles
     **/

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }

    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int interTarget = target - arr[i];
            int end = arr.length - 1;
            int start = i + 1;
            while (start < end) {
                int curSum = arr[start] + arr[end];
                if (curSum < interTarget) {
                    // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                    // left and right to get a sum less than the target sum
                    // so we end up having a count that is the length between end and start
                    count += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }

    public static int searchTripletsBefore(int[] arr, int target) {
        int count = -1;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] != arr[i]) {
                int interTarget = target - arr[i - 1];
                int end = arr.length - 1;
                int start = i;
                while (start < end) {
                    int curSum = arr[start] + arr[end];
                    if (curSum < interTarget) {
                        count++;
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return count;
    }


}
