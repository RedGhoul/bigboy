package com.JavaAlgos.LeetCode.Top100;

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode() {}
TreeNode(int val) { this.val = val; }
TreeNode(int val, TreeNode left, TreeNode right) {
this.val = val;
this.left = left;
this.right = right;
}
}
public class BinaryTreeInorderTraversal {
    /**
    Given the root of a binary tree, return the inorder traversal of its nodes' values.

    Example 1:


    Input: root = [1,null,2,3]
    Output: [1,3,2]
    Example 2:

    Input: root = []
    Output: []
    Example 3:

    Input: root = [1]
    Output: [1]
    Example 4:


    Input: root = [1,2]
    Output: [2,1]
    Example 5:


    Input: root = [1,null,2]
    Output: [1,2]


    Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

    wtf is inorder traversal ?
    just means you have to put your work stuff in the middle

    Problem Key:
    You have already seen this, Inorder just means you do your work in the
    middle.
    Classic recursive problem

    Things that could be improved:
    Do a refresher every morning on basic compsci stuff

    Things that I learned
    This whole thing revolves around getting all the stuff on the left,
    then starting to look at the stuff on the right

    So the iterative solution, would just end up loading all the
    left most nodes on to a stack, then pop them off and process val.
    then add the right node to the stack, then add all its left nodes
    to the stack. Then you keep doing this till the stack is empty.
    Pattern:
    When ever you have some sort of "tree" or "graph" thing
    in the problem, it's gonna most likely involve recursion


    **/


    public static void main(String[] args){

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> input = new ArrayList<>();
        if(root == null) {
            return input;
        }

        inorderHelper(input,root);
        return input;
    }

    public void inorderHelper(List<Integer> input, TreeNode root){
        if(root == null) return;
        if(root.left != null){
            inorderHelper(input,root.left);
        }
        input.add(root.val);
        if(root.right != null){
            inorderHelper(input,root.right);
        }
    }


}
