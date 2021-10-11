package com.JavaAlgos.LeetCode.Top100;

public class InvertBinaryTree {
    /**
     * Given the root of a binary tree, invert the tree, and return its root.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     * Example 2:
     *
     *
     * Input: root = [2,1,3]
     * Output: [2,3,1]
     * Example 3:
     *
     * Input: root = []
     * Output: []
     *
     * What I am thinking
     * They had really nice pictures, but they didn't transfer over
     *
     * Seem like you have to swap the child nodes of every element in the
     * tree. So left becomes right, and right becomes left
     *
     * So I think we are going to have to traverse the tree
     * It is going to be recursive
     * A function that takes in a node, then swaps left right
     * Then calls the same thing on the other two nodes
     *
     *
     * Wow got it in on my first try
     * **/

    public static void main(String[] args){

    }

    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }

    public static void invertTreeHelper(TreeNode root){
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }
}
