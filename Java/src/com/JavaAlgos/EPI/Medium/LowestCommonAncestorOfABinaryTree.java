package com.JavaAlgos.EPI.Medium;

public class LowestCommonAncestorOfABinaryTree {
    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * <p>
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes
     * p and q as the lowest node in T that has both p and q as descendants
     * (where we allow a node to be a descendant of itself).”
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of nodes 5 and 1 is 3.
     * Example 2:
     * <p>
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of
     * itself according to the LCA definition.
     * <p>
     * Example 3:
     * <p>
     * Input: root = [1,2], p = 1, q = 2
     * Output: 1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [2, 105].
     * -109 <= Node.val <= 109
     * All Node.val are unique.
     * p != q
     * p and q will exist in the tree.
     * <p>
     * First thoughts I was right
     * So my approach was the following
     * Traverse the tree find to find the "p" node, and collect the nodes you had to go through along the way
     * Do the same for the "q" node
     * Then compare the lists in order to get the lowest common node between the two lists
     * <p>
     * So the most efficient way of doing this would be to:
     * Do it recursively based on a few different base cases
     * But at its core its doing the following:
     * Go Left
     * Go Right
     * then return a node or null based on a set of conditions
     * That makes sense as to what the under lying LCA is
     * <p>
     * if the root is p or q you know you have hit one of the values you are looking in the recusive call so
     * you return it
     * <p>
     * If your left and right side return a value then return root cause that what they have in common
     * <p>
     * If your left and right are both null, then you know there is nothing in common so you return null
     * <p>
     * If left is not null return left, else return right, cause your returning the last result you got
     * from one of the child trees, which means the LCA was part of that node group or is that node
     * <p>
     * You're going to have to go through the whole tree so
     * TIME COMPLEXITY O(n)
     * SPACE COMPLEXITY O(n) - where N is the size of the stack which is dependent on the height of the tree
     **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (left != null && right != null) return root;

        if (left != null) return left;
        return right;
    }
}
