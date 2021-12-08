package com.JavaAlgos.EPI.Medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Given the root of a binary tree, return the level order traversal
     * of its nodes' values. (i.e., from left to right, level by level).
     * <p>
     * Example 1:
     * <p>
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3],[9,20],[15,7]]
     * Example 2:
     * <p>
     * Input: root = [1]
     * Output: [[1]]
     * Example 3:
     * <p>
     * Input: root = []
     * Output: []
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [0, 2000].
     * -1000 <= Node.val <= 1000
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        nodes.add(null);
        List<Integer> answers = new ArrayList<>();
        List<List<Integer>> answersFinal = new ArrayList<>();
        levelOrderHelper(nodes, answers);
        List<Integer> answersSubArr = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i) == null) {
                answersFinal.add(new ArrayList<>(answersSubArr));
                answersSubArr.clear();
            } else {
                answersSubArr.add(answers.get(i));
            }
        }
        if (answersSubArr.size() > 0) {
            answersFinal.add(new ArrayList<>(answersSubArr));
        }
        return answersFinal;
    }

    public static void levelOrderHelper(List<TreeNode> nodes, List<Integer> answers) {
        if (nodes.size() == 0 || (nodes.size() == 1 && nodes.get(0) == null)) {
            System.out.println("Returned");
            return;
        }

        // take out the first value from nodes
        TreeNode curNode = nodes.remove(0);

        if (curNode != null) {
            // put the next two into nodes
            if (curNode.left != null) {
                nodes.add(curNode.left);
            }

            if (curNode.right != null) {
                nodes.add(curNode.right);
            }

            // put the next two into answers
            answers.add(curNode.val);
            // put the null at the very end if you see it again
        } else {
            nodes.add(null);
            answers.add(null);
        }
        levelOrderHelper(nodes, answers);
    }
}
