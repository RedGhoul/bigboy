package com.JavaAlgos.LeetCode.Top100.Easy;

public class SearchInsertPosition {
    public static void main(String[] args){
        //searchInsert(new int[]{1,3,5,6}, 5);
//        System.out.println(searchInsert(new int[]{-3,-1,0,1,3,5,6}, 2));
//        System.out.println(searchInsert(new int[]{-3,-1,0,1,3,5,6}, -1));
//        System.out.println(searchInsert(new int[]{-3,-1,0,1,3,5,6}, 99));
        //System.out.println(searchInsert(new int[]{1,2,3,4,5,10}, 2));
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
//        System.out.println(searchInsert(new int[]{-1,3,5,6}, 4));
        System.out.println(searchInsert(new int[]{-99,-1,3,4,8,10}, 0));
    }

    //finding the midpoint will always be floor((start+end)/2)
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int midPoint = (int)Math.floor((end+start)/2);
        int midPointValue = nums[midPoint];
        if(target == midPointValue) return midPoint;
        if(target+1 == midPointValue && midPoint-1 >= 0 && target != nums[midPoint-1]) return midPoint;
        while(end > start){

            if(target < midPointValue){
                end = midPoint-1;
            }
            else{
                start = midPoint+1;
            }
            midPoint = (int)Math.floor((end+start)/2);
            midPointValue = nums[midPoint];
            if(target == midPointValue) return midPoint;
            if(target+1 == midPointValue) return midPoint;
        }

        return start;
    }

    /**
     * the key thing I ended up learning here was that binary search already kind of does everything for you
     * One of the properties of binary search I didn't know is that
     * Not only would it try to find where the target is, but it would also SHOW where it SHOULD be.
     *
     * Also make sure you know what you are doing. Got confused since what you thought was wrong was actually right,
     * because you have to many testcases in leetcodes test window
     *
     * LOOK don't spend soooo much time on a single problem, its un productive !!!
     * If the answer and understand it, learn from it
    **/
    public static int searchInsertv2(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low <= high){
            mid = low + (high-low)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high= mid -1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }
}
