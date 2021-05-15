package com.JavaAlgos.Stephen;

import java.util.ArrayList;

public class Tree {

    public static void main(String[] args){
        TreeNode root = new TreeNode("20");
        TreeNode l1_a = new TreeNode("0");
        TreeNode l1_b = new TreeNode("40");
        TreeNode l1_c = new TreeNode("-15");
        TreeNode l2_a = new TreeNode("12");
        TreeNode l2_b = new TreeNode("-2");
        TreeNode l2_c = new TreeNode("1");
        TreeNode l2_d = new TreeNode("-2");

        root.children.add(l1_a);
        root.children.add(l1_b);
        root.children.add(l1_c);

        l1_a.children.add(l2_a);
        l1_a.children.add(l2_b);
        l1_a.children.add(l2_c);

        l1_c.children.add(l2_d);

        Tree newTree = new Tree(root);
        Tree.BreathFirstTraverse(newTree);
        System.out.println("-------------------------------------------");
        Tree.DepthFirstTraverse(newTree);
        System.out.println("-------------------------------------------");
        var stuff = Tree.GetLevelWidth(newTree);
    }

    TreeNode root;
    public Tree(TreeNode data){
        root = data;
    }



    public static void BreathFirstTraverse(Tree input){
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(input.root);
        BFTHelper(nodes);
    }

    public static void BFTHelper(ArrayList<TreeNode> nodes){
        if(nodes.size() == 0) return;
        TreeNode curNode = nodes.remove(0);
        System.out.println(curNode.data + " ,");
        for(int i =0; i < curNode.children.size(); i++){
            nodes.add(curNode.children.get(i));
        }
        BFTHelper(nodes);
    }

    public static ArrayList<Integer> GetLevelWidth(Tree input){
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        ArrayList<Integer> widths = new ArrayList<Integer>();
        nodes.add(input.root);
        nodes.add(new TreeNode("Marker"));
        return GetLevelWidthHelper(nodes,widths,0);
    }

    public static ArrayList<Integer> GetLevelWidthHelper(ArrayList<TreeNode> nodes,ArrayList<Integer> widths, int count){
        // Putting A on top was making it return too early
        TreeNode curNode = nodes.remove(0);
        System.out.println(curNode.data);
        if(curNode.data.equals("Marker")){
            nodes.add(new TreeNode("Marker"));
            widths.add(count);
            count = 0;
            if(nodes.size() == 1 && nodes.get(0).data.equals("Marker") ) return widths; // A
            return GetLevelWidthHelper(nodes,widths,count);
        }
        count++;
        for(int i =0; i < curNode.children.size(); i++){
            nodes.add(curNode.children.get(i));
        }
        return GetLevelWidthHelper(nodes,widths,count);
    }

    public static void DepthFirstTraverse(Tree input){
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(input.root);
        DFTHelper(nodes);
    }

    public static void DFTHelper(ArrayList<TreeNode> nodes){
        if(nodes.size() == 0) return;
        TreeNode curNode = nodes.remove(0);
        System.out.println(curNode.data);
        for(int i =curNode.children.size()-1; i >= 0; i--){
            nodes.add(0,curNode.children.get(i));
        }
        DFTHelper(nodes);
    }
}
