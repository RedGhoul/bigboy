package com.JavaAlgos.Stephen;

import java.util.ArrayList;

public class TreeNode {
    String data;
    ArrayList<TreeNode> children;

    public TreeNode(String data){
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    public void add(String data){
        children.add(new TreeNode(data));
    }

    public void remove(String data){
        for(int i = 0; i < this.children.size(); i++){
            TreeNode curNode = this.children.get(i);
            if(curNode.data.equals(data)){
                this.children.remove(i);
                return;
            }
        }
    }
}
