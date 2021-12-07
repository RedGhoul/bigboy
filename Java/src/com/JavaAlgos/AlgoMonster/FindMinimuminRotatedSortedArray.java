package com.JavaAlgos.AlgoMonster;

public class FindMinimuminRotatedSortedArray {
    /**
     * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
     * For example, the array nums = [0,1,2,4,5,6,7] might become:
     * <p>
     * [4,5,6,7,0,1,2] if it was rotated 4 times.
     * [0,1,2,4,5,6,7] if it was rotated 7 times.
     * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the
     * array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
     * <p>
     * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
     * <p>
     * You must write an algorithm that runs in O(log n) time.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,4,5,1,2]
     * Output: 1
     * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
     * Example 2:
     * <p>
     * Input: nums = [4,5,6,7,0,1,2]
     * Output: 0
     * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
     * Example 3:
     * <p>
     * Input: nums = [11,13,15,17]
     * Output: 11
     * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 1 <= n <= 5000
     * -5000 <= nums[i] <= 5000
     * All the integers of nums are unique.
     * nums is sorted and rotated between 1 and n times.
     * <p>
     * Clarify Question: What am I really looking for ?
     * Question says I am looking for the min in the array. But is that really true ? NO
     * I am looking for something that can point me in the right direction of the min
     * Really is "inflection point" aka the point where the High goes to low
     * Cause the thing that going to be on the right of that point is going to be the min
     * <p>
     * How to do I find it ??? easy use binary search. But HOW ???
     * <p>
     * You know that if your mid point is greater than the first thing in the array.
     * That section (low to mid) is in increasing order. Will you find the inflection point there ???
     * the answer is NO
     * <p>
     * That mean you know that you have to look in the right part of the array, cause it still ascending in that left
     * part of the array
     * <p>
     * If the mid point is less than the first, that means its not ascending, that means its going down.
     * So we have to look in the left part the array, since the inflection point will always be on HIGH -> Low
     **/
    public static void main(String[] args) {
        //System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public static int findMin2(int[] nums) {
        nums = null;
        int low = 0;
        int high = nums.length - 1;
        int finalAnswer = 0;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int lowVal = nums[low];
            int midVal = nums[mid];
            if (midVal > lowVal) {
                finalAnswer = lowVal;
                low = mid + 1;
            } else {

                high = low - 1;
            }
        }
        return finalAnswer;
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) { // cause we are just looking for inflection point
            int mid = low + ((high - low) / 2);
            int lowVal = nums[low];
            int midVal = nums[mid];
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // midVal > nums[high] this part is just there to make sure your not in the
            // lower part of a sorted part of the array
            // Cause you might be thinking you need to go further to the right when really
            // you need to go left. Cause your in tail end section of the array

            if (midVal >= lowVal && midVal > nums[high]) {
                low = mid + 1;
            } else {

                high = mid - 1;
            }
        }
        return nums[low];
    }
}
