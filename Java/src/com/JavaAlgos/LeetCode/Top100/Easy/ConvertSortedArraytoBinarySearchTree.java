package com.JavaAlgos.LeetCode.Top100.Easy;


public class ConvertSortedArraytoBinarySearchTree {
    /**
     * Given an integer array nums where the elements are sorted in ascending order,
     * convert it to a height-balanced binary search tree.
     *
     * A height-balanced binary tree is a binary tree in which the depth of the two
     * subtrees of every node never differs by more than one.
     *
     *
     * What I did I learn from this is ?
     * Follow your own rules, trees equal recursive
     *
     * Problem key:
     * It's not enough that you go from the middle out, in the beginning,
     * You have to do that for every subset of values for the middle to the
     * outs.
     *
     * 1,2,3,4,5,6
     *
     * mid is 4
     * so what comes to the left of the 4
     * should be determined between 1 - 3
     * now you have to determine the mid between
     * 1 -> 3
     *
     * you don't even need to really compare since everything has a middle,
     * since you are given a sorted array
     * **/

    public static void main(String[] args){

    }

//    public TreeNode sortedArrayToBST(int[] nums) {
//        if(nums.length == 0) return null;
//        if(nums.length == 1) return new TreeNode(nums[0]);
//
//        int midNum = (nums.length-1)/2;
//        TreeNode root = new TreeNode(midNum);
//        TreeNode curTop = root;
//        for(int i = midNum-1; i >= 0; i--){
//            int curVal = nums[i];
//            TreeNode newNode = new TreeNode(curVal);
//            if(curVal < curTop.val){
//                curTop.left = newNode;
//                curTop = newNode;
//            }else {
//                curTop.right = newNode;
//                curTop = newNode;
//            }
//        }
//        curTop = root;
//        for(int i = midNum+1; i < nums.length; i++){
//            int curVal = nums[i];
//            TreeNode newNode = new TreeNode(curVal);
//            if(curVal < curTop.val){
//                curTop.left = newNode;
//                curTop = newNode;
//            }else {
//                curTop.right = newNode;
//                curTop = newNode;
//            }
//        }
//        return root;
//    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        if(nums.length == 1) return new TreeNode(nums[0]);

        TreeNode root = sortHelper( 0, nums.length-1,nums);
        //System.out.println(root.val);
        return root;
    }

    public TreeNode sortHelper(int start, int end, int[] nums){
        // only doesn't make sense when start is greater than end
        if(start > end) return null;
        int midNum = (start+end)/2;
        // always need to make a new node every time
        // so that every recursive calls also makes a new node
        TreeNode node = new TreeNode(nums[midNum]);
        node.left = sortHelper(start,midNum-1,nums);
        node.right = sortHelper(midNum+1,end,nums);

        return node;
    }
}
