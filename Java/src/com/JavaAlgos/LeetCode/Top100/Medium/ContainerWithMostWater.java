package com.JavaAlgos.LeetCode.Top100.Medium;

public class ContainerWithMostWater {
            /*
        Two pointers
        at each end
        keep trying to move them in
        after computing the first area, figure out which pointer move
        you want to replace your smallest current pointer with a bigger one, so then you move it.
        then make the move, and recompute the area to figure out the max
        */

    /**
     * Maybe go through a mental model of what in your tool box ???
     *
     * The only Reason I decided to use a "two pointer"
     * was because I remembered a heuristic.
     *
     * If given an array based problem which this was:
     * - see if sorting helps
     * - mostly likely will have something to do with two pointers
     * There are only three ways to use two pointers
     * - fast slow
     * - originating at a single point and moving outward
     * - one pointer at start, and another at end. And then moving them around based on a huristic
     *
     *
     * In this case it was that last one. We know we want bigger heights, so after computing the inital
     * area, move the pointer that is pointing to the smallest height between the two
     *
     * **/

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length -1;
        int maxArea = 0;
        while(left < right){
            int leftVal = height[left];
            int rightVal = height[right];

            int width = right - left;
            int heightFinal = Math.min(leftVal,rightVal);

            maxArea = Math.max(width*heightFinal,maxArea);
            if(leftVal < rightVal){
                left++;
            }else{
                right--;
            }

        }

        return maxArea;

    }

}
