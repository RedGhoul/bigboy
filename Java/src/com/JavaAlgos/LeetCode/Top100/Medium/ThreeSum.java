package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.*;

public class ThreeSum {
    /**
     * PROBLEM STATEMENT:
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Example 2:
     *
     * Input: nums = []
     * Output: []
     * Example 3:
     *
     * Input: nums = [0]
     * Output: []
     *
     *
     * Constraints:
     *
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     * */
    /**
     * Was kind of sort of able to solve this, around 80% to the right solution
     * Just had to end up using "sorted array, and two pointer"
     * **/

    /**
     * two pointers
     * some sort of werid dp - something you have seen before in that video
     * brute force would be 3 for loops for n^3
     * <p>
     * make nums into arrayList
     * final answers array
     * for loop for first number
     * take out the currentNum
     * <p>
     * becomes a twosum problem for currentNum
     * hashmap comes in
     * for loop for the other two numbers
     * get currentNum2
     * check if it exist in the hash map
     * if it doesn't then
     * - currentNum = currentNum2 + anotherNumber
     * - currentNum - currentNum2 = anotherNumber
     * - (currentNum + currentNum2) = anotherNumber
     * store that in the hashmap where the key
     * is anotherNumber, and the value is currentNum2
     * if it does exist:
     * store the three numbers in the final answer array
     * <p>
     * <p>
     * return the final answers array
     * time (O(n^2))
     * space(O(n))
     * <p>
     * <p>
     * the other way to do this would have been to sort the array
     * then do the inital for loop
     * then do a two pointer method to figure out which numbers add up to the target
     * (to use less space)
     * time (O(n^2))
     * space(O(1))
     * Could I solve this ? got 75% to the answer, did not know about the whole two pointer thing
     */

//         List<List<Integer>> finalAnswer = new ArrayList<ArrayList<Integer>>();

//         for(int i =0; i < nums.length; i++){
//             int currentVal = -1 * nums[i];

//             HashMap<Integer,Integer> bag = new HashMap<Integer,Integer>();

//             for(int j = i+1; j < nums.length; j++){
//                 int currentVal2 = nums[j];
//                 int p1 = currentVal - currentVal2;
//                 if(bag.contains(currentVal2)){
//                     finalAnswer.add(new ArrayList<Integer>() {
//                         add(currentVal);
//                         add(currentVal2);
//                         add(p1);
//                     });
//                 }else{
//                     bag.put(p1,currentVal2);
//                 }
//             }
//         }

//         return finalArray;
    public static void main(String[] args) {
        // threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public static List<List<Integer>> threeSumfml(int[] nums) {
        List<List<Integer>> finalAnswer = new ArrayList<>();
        HashMap<Integer, Integer> bag = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int currentVal = 0 - nums[i];

            for(int j = i+1; j < nums.length; j++){
                int currentVal2 = nums[j];
                int p1 = currentVal - currentVal2;
                if(bag.containsKey(currentVal2)){
                    finalAnswer.add(new ArrayList<Integer>() {{
                        add(-1*currentVal);
                        add(currentVal2);
                        add(p1);
                    }});
                    bag.remove(-1*currentVal);
                    bag.remove(currentVal2);
                    bag.remove(p1);
                }else{
                    bag.put(p1,currentVal2);
                }
            }
        }

        return finalAnswer;

    }

    /**
     * Two pointers are king everything is two pointer
     * they expect to see two pointers
     * */
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-1; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;// do this to avoid dups
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
