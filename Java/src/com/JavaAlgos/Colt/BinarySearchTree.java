package com.JavaAlgos.Colt;

public class BinarySearchTree {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(13);
        tree.insert(2);
        tree.insert(7);
        tree.insert(11);
        tree.insert(16);
        tree.insert(16);
        var stuff = tree.find(163);
        System.out.println(stuff);
    }

    public BSTNode root;
    public BinarySearchTree(){
        root = null;
    }

    public void insert(int value){
        if(this.root == null) {
            this.root = new BSTNode(value);
        }

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

    /*
    * I did this in a recursive way. But can also do this in
    * a iterative way. With a while loop.
    * One of the questions you can ask is "how should we handle duplicates"
    * */
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

    // Interactive way
    private void insert2(int input){
        if(this.root == null){
            this.root = new BSTNode(input);
            return;
        }
        BSTNode current = this.root;
        while(true){
            if(input > current.value){
                if(current.right != null){
                    current = current.right;
                }else{
                    current.right = new BSTNode(input);
                    return;
                }
            }else if (input < current.value) {
                if(current.left != null){
                    current = current.left;
                } else {
                    current.left = new BSTNode(input);
                    return;
                }
            }else if(input == current.value){
                return;
            }
        }
    }
    // can also do this recursively
    private BSTNode find(int input){
        if(this.root == null) return null;
        if(this.root.value == input) return this.root;
        BSTNode current = this.root;
        while(current != null){
            if(input == current.value) return current;
            if(input < current.value){
                current = current.left;
            }else if (input > current.value){
                current = current.right;
            }
        }
        return null;
    }
}
