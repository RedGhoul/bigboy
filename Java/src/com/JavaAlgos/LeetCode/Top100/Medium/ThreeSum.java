package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args){
       // threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public static List<List<Integer>> threeSumfml(int[] nums) {
        List<List<Integer>> finalAnswer = new ArrayList<>();
        HashMap<Integer,Integer> bag = new HashMap<Integer,Integer>();
        for(int i =0; i < nums.length; i++){
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
