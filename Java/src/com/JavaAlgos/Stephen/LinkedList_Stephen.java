package com.JavaAlgos.Stephen;

public class LinkedList_Stephen {

    public static void main(String[] args){
        LinkedList_Stephen sss = new LinkedList_Stephen();
        sss.insertFirst(1);
        sss.insertFirst(2);
        sss.insertFirst(3);
    }
    StephenNode head = null;

    public LinkedList_Stephen(){

    }

    public void insertFirst(int input){
        StephenNode newNode = new StephenNode(input);
        if(head != null){
            StephenNode oldNode = head;
            head = newNode;
            head.nextNode = oldNode;
        }else{
            head = newNode;
        }
    }
}
