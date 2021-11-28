package com.JavaAlgos.EPI.Medium;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     * function A
     * pre - order here
     * rec func
     * <p>
     * inorder here
     * <p>
     * rec func
     * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
     * inorder is the inorder traversal of the same tree, construct and return the binary tree.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     * <p>
     * You were right the whole time kind of made it more complex than it needed to be
     * And couldn't come up with the solution because you weren't concentrating (talking to friend)
     * <p>
     * Things aren't always what they seem, didn't have to use both of the arrays in the way that
     * you though you did
     **/
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        // Take the index of zero from preoder and make it the main head
        // now call the rec function
        // return the mainHead
        return null;
    }

    // left side arrayPointer , right side arrayPointers, mainHead, newHeadPointer
    public static void buildTreeHelper(int lp1, int lp2, int rp1, int rp2, TreeNode mainNode, int newHeadp, int[] preOrder, int[] inOrder) {
        for (int i = lp1; i <= lp2; i++) {
            if (inOrder[i] == preOrder[newHeadp]) {
                TreeNode lef = new TreeNode(preOrder[newHeadp]);
                mainNode.left = lef;
                // buildTreeHelper(int lp1, int lp2, int rp1, int rp2, TreeNode mainNode, int newHeadp, int[] preOrder, int[] inOrder)
            }
        }
        for (int i = rp1; i <= rp2; i++) {
            if (inOrder[i] == preOrder[newHeadp]) {
                mainNode.right = new TreeNode(preOrder[newHeadp]);
            }
        }

    }
}
