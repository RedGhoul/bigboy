package com.JavaAlgos.LeetCode.Top100.Easy;

public class SymmetricTree {
    /**
     * Given the root of a binary tree, check whether
     * it is a mirror of itself (i.e., symmetric around its center).
     *
     * I am just going to, do this the basic way. Which is treat the two
     * sides like two separate trees, and compare the output of
     * an inorder traversal
     *
     * Problem Key:
     *
     * Recursive all the way. The point aka the thing that
     * always needs to be true to make something symmetric
     * is that the left node of A node. Needs to the same
     * as the right node of B node.
     *
     * So you can create a recursive method that takes in
     * both A & B node and just checks if they are the same.
     * For every left right node in the tree, that would need to
     * match
     *
     * Things that could be improved:
     * Actually properly read the question. Pay attention to the
     * examples they give. they said SYMMETRIC Tree, NOT SAME tree.
     * Symmetric is very different from same tree.
     *
     * Do recursive properly, take a good look at your base cases. And
     * Account for null values
     *
     *Things I learned:
     *
     * - LOOK AT THE PROBLEM STATEMENT !!!!!!
     * - TAKE YOUR BASE CASES SERIOUSLY
     *
     *
     * PATTERN
     * Trees == Mostly likely a recursive question
     *
     *
     *
     *      * Homework:
     *      * Look at the way other people did this same problem.
     *      * Solutions either used less memory OR used an iterative approach
     * **/

    public static void main(String[] args){

    }

    //[1,2,2,2,null,2]
    //[1,2,2,2,2,2,2]
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        return GetNodes(root.left,root.right);
    }

    public static boolean GetNodes(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if((node1 == null && node2 != null) ||
                (node1 != null && node2 == null)) {
            return false;
        }
        if(node1.val != node2.val) return false;
        if(!GetNodes(node1.left, node2.right)){
            return false;
        }
        if(!GetNodes(node1.right, node2.left)){
            return false;
        }

        return true;

    }


//    public boolean isSymmetric(TreeNode root) {
//        List<Integer> C1 = new ArrayList<>();
//        List<Integer> C2 = new ArrayList<>();
//        if(root == null) return false;
//        GetNodes(C1,root.left);
//        GetNodes(C2,root.right);
//        if(C1.size() != C2.size()) return false;
//        Collections.reverse(C2);
//        for(int i = 0; i < C1.size(); i++){
//            System.out.println("C1 " + C1.get(i));
//            System.out.println("C2 " + C2.get(i));
//            if(!C1.get(i).equals(C2.get(i))) return false;
//        }
//        return true;
//    }
//
//    public static void GetNodes(List<Integer> collector, TreeNode node){
//        if(node == null) return;
//        if(node.left != null){
//            GetNodes(collector, node.left);
//        }
//
//        collector.add(node.val);
//
//        if(node.right != null){
//            GetNodes(collector, node.right);
//        }
//    }
}
