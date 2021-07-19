package com.JavaAlgos.Colt;

public class BinarySearchTree {
    public BSTNode root;
    public BinarySearchTree(){
        root = null;
    }

    public void insert(int value){
        if(this.root == null) return;

        int rootValue = this.root.value;
        if(value > rootValue && this.root.right != null){
            this.insertHelper(this.root.right, value);
        }else if (value > rootValue){
            this.root.right = new BSTNode(value);
        }

        if(value < rootValue && this.root.left != null){
            this.insertHelper(this.root.left, value);
        }else if (value < rootValue) {
            this.root.left = new BSTNode(value);
        }

    }

    private void insertHelper(BSTNode curNode, int input){
        if(input > curNode.value && curNode.right != null){
            this.insertHelper(curNode.right,input);
        }else if (input > curNode.value) {
            curNode.right = new BSTNode(input);
        }

        if(input < curNode.value && curNode.left != null){
            this.insertHelper(curNode.left,input);
        }else if (input < curNode.value) {
            curNode.left = new BSTNode(input);
        }
    }
}
