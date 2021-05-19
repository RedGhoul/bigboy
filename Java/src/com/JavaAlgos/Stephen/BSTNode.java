package com.JavaAlgos.Stephen;

public class BSTNode {
    public BSTNode left;
    public BSTNode right;
    public int value;

    public BSTNode(BSTNode left, BSTNode right, int value){
        left = left;
        right = right;
        value = value;
    }
    // does this need to look for doubles ?
    public void insert(int value){
        if(this.value == value){
            System.out.println("Found the same");
        }else if(this.value > value){
            if(this.left == null){
                this.left = new BSTNode(null, null, value);
            }else{
                this.left.insert(value);
            }
        }else if(this.value < value){
            if(this.right == null){
                this.right = new BSTNode(null, null,value);
            }else{
                this.right.insert(value);
            }
        }
    }

    public void insert2(int value){
        if(value < this.value && this.left != null){
            this.left.insert2(value);
        } else if(value < this.value){
            this.left = new BSTNode(null, null, value);
        } else if(value > this.value && this.right != null){
            this.right.insert2(value);
        } else if (value > this.value){
            this.right = new BSTNode(null, null,value);
        }
    }

    public Integer contains(int value){
        if(this.value == value){
            System.out.println("This BST contains the following value: " + value);
            return value;
        }else if(value > this.value && this.right != null){
            return this.right.contains(value);
        } else if(value < this.value && this.left != null){
            return this.left.contains(value);
        }
        return null;
    }
    /*
    * The Max is for the left since nothing can ever be greater then the max the
    * further down the tree you get
    *
    * The Min is for the right since nothing can be less then the min further down the tree
    * you go
    *
    * The current node must always be between the min and the max
    * */
    public boolean validate(BSTNode node, Integer min, Integer max){
        if(max != null && node.value > max){
            return false;
        }
        if(min != null && node.value < min){
            return false;
        }
        /*
        * This validate(node.left,min,node.value) call splits off ,
        * and validates another section of the tree
        *
        * Since we have two different sides to validate, we can't just put
        * the recursive call in the return statement. Even if it did return true
        * it would only be true for the right side or left side of the tree
        * without checking to see if other side of the tree was also valid
        * */
        if(node.left != null && !validate(node.left,min,node.value)){
            return false;
        }

        if(node.right != null && !validate(node.right, node.value,max)){
            return false;
        }
        return true;
    }
}
