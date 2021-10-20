package com.JavaAlgos.LeetCode.Top100.Easy;

public class DiameterofBinaryTree {

    /**
     * Given the root of a binary tree, return the length of the diameter of the tree.
     *
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     *
     * The length of a path between two nodes is represented by the number of edges between them.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,2,3,4,5]
     * Output: 3
     * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
     * Example 2:
     *
     * Input: root = [1,2]
     * Output: 1
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 104].
     * -100 <= Node.val <= 100
     *
     * What I am thinking.
     * It has to go through the root, you are just looking for the
     * upside down "V"
     *
     * So find the longest path on either side and you got your answer
     *
     * So need to find the max depth on each side of the tree
     *
     * The basic Premise of the "V" was completely WRONG
     *
     * You need to longest parth between these nodes, it doesn't nessarly need to
     * pass through the root node.
     *
     * You basically need to calculate the length from either side of the node
     * your currently at. So it more of a side to side thing then a top down
     *
     * You are really just trying to figure out how much stuff you have
     * on either side of where you are in tree
     *
     * // this down here was also wrong
     * It is just the longest path wins aka MAX depth
     * So you were on the right track, but just made it more complex
     * than it needed to be
     * **/
    public static void main(String[] args){

    }

//    public int diameterOfBinaryTree(TreeNode root) {
//        if(root == null) return 0;
//        int maxDia = 0;
//
//        List<Integer> max1 = new ArrayList<>();
//        MaxD(root.left,0,0,max1);
//        int maxDia1 = Collections.max(max1);
//        if(maxDia1 > 0){
//            maxDia1--;
//        }
//        List<Integer> max2 = new ArrayList<>();
//        MaxD(root.left,0,0,max2);
//        int maxDia2 = Collections.max(max2);
//        if(maxDia2 > 0){
//            maxDia2--;
//        }
//
//        maxDia = 2 + maxDia1 + maxDia2;
//
//        return maxDia;
//    }

//    public int diameterOfBinaryTree(TreeNode root) {
//        if(root == null) return 0;
//
//        List<Integer> max1 = new ArrayList<>();
//        MaxD(root.left,0,0,max1);
//        int maxDia1 = Collections.max(max1);
//        return maxDia1;
//    }
//
//    public static void MaxD(TreeNode node , int max, int curMax, List<Integer> bag){
//        if(node == null) return;
//        max++;
//        if(max > curMax){
//            curMax = max;
//            bag.add(curMax);
//        }
//        if(node.left != null){
//            MaxD(node.left,max,curMax, bag);
//        }
//        if(node.right != null){
//            MaxD(node.right,max,curMax, bag);
//        }
//    }


    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
