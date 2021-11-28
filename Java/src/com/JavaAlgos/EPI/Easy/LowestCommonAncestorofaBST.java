package com.JavaAlgos.EPI.Easy;

public class LowestCommonAncestorofaBST {
    /**
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     * <p>
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p
     * and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     * Example 2:
     * <p>
     * <p>
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
     * Example 3:
     * <p>
     * Input: root = [2,1], p = 2, q = 1
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [2, 105].
     * -109 <= Node.val <= 109
     * All Node.val are unique.
     * p != q
     * p and q will exist in the BST.
     * <p>
     * root node
     * <p>
     * valCurP  = root.left
     * dfs call that is looking for p
     * returns
     * <p>
     * valCurQ = root.right
     * if(valCurQ.val != q.value)
     * <p>
     * dfs call that is logging for q
     * returns
     * <p>
     * is valCurQ.val == valCurP.val
     * return valCurQ;
     * <p>
     * <p>
     * YOUR NOT UNDERSTANDING THE BASICS OF BST
     * <p>
     * EVERYTHING TO THE LEFT IS LESS THAN
     * EVERYTHING TO THE RIGHT IS GREATER THAN
     * So if your given two node, and told to find the new common between them, you have to be between them.
     * Then it's really saying that this "LCA" has to be greater than P but less than Q
     **/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root.val < p.val || root.val > q.val) {
            while (root.val < p.val) {
                root = root.right;
            }
            while (root.val > q.val) {
                root = root.left;
            }
        }

        return root;
    }

//    public TreeNode LCAHelper(TreeNode root, TreeNode T1, TreeNode T2){
//
//        TreeNode left = root.left;
//
//        if(left != null && left.val != T1.val){
//            left = LCAHelper(left, T1,T2);
//        }
//
//        TreeNode right  = root.right;
//
//        if(right != null && right.val != T2.val){
//            right = LCAHelper(right, T1,T2);
//        }
//
//        if(right != null && left != null && right.val == left.val) return right;
//        return null;
//    }
//
//    public TreeNode LCAHelper2(TreeNode root, TreeNode T1, TreeNode T2){
//        if(root == null) return null;
//        if(T1.val > root.val){
//            LCAHelper2(root.right, T1, T2);
//        }else if (T1.val < root.val){
//            LCAHelper2(root.left, T1, T2);
//        }
//
//        if(T2.val > root.val){
//            LCAHelper2(root.right, T1, T2);
//        }else if (T2.val < root.val){
//            LCAHelper2(root.left, T1, T2);
//        }
//
//
//    }
}
