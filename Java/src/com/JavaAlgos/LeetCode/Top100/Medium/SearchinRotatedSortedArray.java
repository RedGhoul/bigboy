package com.JavaAlgos.LeetCode.Top100.Medium;

public class SearchinRotatedSortedArray {
    /**
     * There is an integer array nums sorted in ascending order (with distinct values).
     *
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot
     * index k (1 <= k < nums.length) such that the resulting array is
     * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
     * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     *
     * Given the array nums after the possible rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     *
     * Input: nums = [1], target = 0
     * Output: -1
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * All values of nums are unique.
     * nums is an ascending array that is possibly rotated.
     * -104 <= target <= 104
     *
     *
     * **/

    /**
     * Thoughts:
     * It took me reading the same thing 5 times to fully understand what the question was asking.
     * So really we are looking for the pivot "index"
     * And then we are told a target to look for.
     * <p>
     * So I guess what we are really doing is looking for something, and returning its index
     * <p>
     * "Given the array nums after the possible rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums."
     * <p>
     * I guess I should have read this a 6th time since they litrally just say what I was thinking
     * <p>
     * What we know:
     * - This is going to be a two pointer - we are dealing with an array
     * - Binary search algo type problem - they literally say
     * "You must write an algorithm with O(log n) runtime complexity."
     * <p>
     * - complexity comes in since this array we are given isn't properly sorted
     * <p>
     * Brainstorm
     * <p>
     * I think you could split it off into two different arrays,
     * using pointers
     * [4,5,6,7,0,1,2]
     * <p>
     * becomes:
     * <p>
     * A) 4,5,6,7
     * <p>
     * B) 0,1,2
     * <p>
     * then do binary search on each of them
     * <p>
     * Or just sort them, but that would make the time complexity O(n*log(n))
     * <p>
     * So I checked if I was on the right track with this solution, before committing to it.
     * And it turned out I was :)
     * <p>
     * However, I had to double-check I was using the right mid point formula for Binary Search
     * low + ((high-low)/2)
     * <p>
     * Also, I didn't double-check through a mental trace of the program before running it
     **/
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {
        // nums will never be zero

        // make 4 var for each pointer
        int p11 = 0;
        int p12 = 0;
        int p21 = 0;
        int p22 = nums.length - 1;
        //We go through the array and look for split
        for (int i = 0; i < nums.length - 1; i++) {
            int left = nums[i];
            int right = nums[i + 1];
            // if (right num < left num)
            if (right < left) {
                p12 = i;
                p21 = i + 1;
                break;
            }
            // setup pointers
            // leftNumber becomes p12
            // rightNumber becomes p21
        }


        // to find the mid we need to do the following:
        // p11 + (p12-p11)/2
        // do bin search using p1 pointers
        // if found return index
        int targetIndex1 = binsr(nums, p11, p12, target);
        if (targetIndex1 != -1) return targetIndex1;

        // do bin search using p2 pointers
        // p21 + (p22+p21)/2
        // if found return index
        int targetIndex2 = binsr(nums, p21, p22, target);
        if (targetIndex2 != -1) return targetIndex2;
        // if we got hear then we need return -1

        return -1;
    }

    public static int binsr(int nums[], int start, int end, int target) {
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            int curVal = nums[mid];
            if (curVal == target) return mid;
            if (target > curVal) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
