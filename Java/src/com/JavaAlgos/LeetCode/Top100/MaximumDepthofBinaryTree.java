package com.JavaAlgos.LeetCode.Top100;

import java.util.*;

public class MaximumDepthofBinaryTree {
    /**
     * Given the root of a binary tree, return its maximum depth.
     *
     * A binary tree's maximum depth is the number of nodes along
     * the longest path from the root node down to the farthest leaf node.
     *
     * Got it right on the first try (of submission) yay !
     *
     * Problem Key:
     * Got to know how to traverse binary tree.
     * You just have to keep track of the depth of the
     * recursive function. Then return the max depth it reached.
     *
     * Things that I learned:
     * Not much, other than basics are really important
     *
     * Pattern:
     * Anything tree = some tree traversal involved
     *
     * Homework:
     * Look at the way other people did this same problem.
     * Solutions either used less memory OR used an iterative approach
     * **/

    public static void main(String[] args){

    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Integer max = Integer.MIN_VALUE;
        Integer currentMax = 0;
        ArrayList<Integer> bag = new ArrayList<>();
        maxDepthHelper(root, max,currentMax, bag);
        return Collections.max(bag);
    }

    public void maxDepthHelper(TreeNode root, Integer max, Integer currentMax, List bag){
        if(root == null) return;
        currentMax++;
        if(currentMax > max){
            max = currentMax;
            bag.add(max);
        }

        if(root.left != null){
            maxDepthHelper(root.left,max,currentMax, bag);
        }

        if(root.right != null){
            maxDepthHelper(root.right,max,currentMax, bag);
        }
    }
}
