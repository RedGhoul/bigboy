package com.JavaAlgos.EPI.Easy;

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

public class SymmetricTree {
    /**
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: root = [1,2,2,3,4,4,3]
     * Output: true
     * Example 2:
     * <p>
     * <p>
     * Input: root = [1,2,2,null,3,null,3]
     * Output: false
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [1, 1000].
     * -100 <= Node.val <= 100
     * https://leetcode.com/problems/symmetric-tree/discuss/33054/Recursive-and-non-recursive-solutions-in-Java
     * <p>
     * Look at the above to the interactive approach
     **/
    public boolean isSymmetric(TreeNode root) {

        // seprate it into two different trees aka nodes
        // left & right have an equal value if doesn't return false
        // return put it in my helper function
        return true;
    }

    // helper function input A & B
    // if(A == null && B == null) return true;
    // if ((A == null && B != null) || (B != null && A == null)) return false;
    // if(A.value != B.value) return false;
    // if(!function (A.Left,B.right)) return false;
    // if(!function (A.right, B.Left)) return false;
    // return true;
}
