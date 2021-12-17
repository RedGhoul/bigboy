package com.JavaAlgos.LeetCode.Top100.Easy;

import java.util.Arrays;

public class SquaringASortedArray {
    /**
     * Given a sorted array, create a new array containing squares of all the numbers of the input
     * array in the sorted order.
     * <p>
     * Example 1:
     * <p>
     * Input: [-2, -1, 0, 2, 3]
     * Output: [0, 1, 4, 4, 9]
     * Example 2:
     * <p>
     * Input: [-3, -1, 0, 1, 2]
     * Output: [0, 1, 1, 4, 9]
     * <p>
     * wow i was right
     * <p>
     * Time: O(n)
     * Space: O(n) since we are using a new array
     **/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(makeSquares(new int[]{-2, -1, 0, 2, 3})));
        System.out.println(Arrays.toString(makeSquares(new int[]{-3, -1, 0, 1, 2})));
    }

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        int endNew = end;
        while (endNew >= 0) {
            int left = Math.abs(arr[start]);
            int right = Math.abs(arr[end]);
            if (right >= left) {
                squares[endNew] = right * right;
                end--;
            } else {
                squares[endNew] = left * left;
                start++;
            }
            endNew--;
        }
        return squares;
    }
}
