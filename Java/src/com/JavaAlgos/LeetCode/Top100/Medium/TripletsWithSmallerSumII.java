package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSmallerSumII {
    /**
     * * SIMILAR PROBLEMS
     * * Write a function to return the list of all such triplets instead of the count.
     * * How will the time complexity change in this case?
     * * Time complexity would be O(N^3)
     * * Space complexity would be O(1) for sorting and also the fact the we are now storing an answer array
     * N+ N = 2 N => N
     **/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchTripletsPart2(new int[]{-1, 4, 2, 1, 3}, 5).toArray()));
        System.out.println(Arrays.toString(searchTripletsPart2(new int[]{-1, 0, 2, 3}, 3).toArray()));
    }

    public static List<List<Integer>> searchTripletsPart2(int[] arr, int target) {
        List<List<Integer>> answer = new ArrayList<>();
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
                    // Since everything from start to end could be a potential combination to lead
                    // to a sum that is less than the target. We iterate through the possible
                    // combos from "start" to "end", and add them to our answers.
                    // not including the start since we already have it as one part of the three input
                    // answer
                    answer.add(Arrays.asList(arr[start], arr[end], arr[i]));
                    for (int j = start + 1; j < end; j++) {
                        answer.add(Arrays.asList(arr[start], arr[j], arr[i]));
                    }

                    start++;
                } else {
                    end--;
                }
            }
        }
        return answer;
    }
}
