package com.JavaAlgos.Stephen;

public class LinkedList_Stephen {

    public static void main(String[] args){
        LinkedList_Stephen sss = new LinkedList_Stephen();
        sss.insertFirst(1);
        sss.insertFirst(2);
        sss.insertFirst(344);
        sss.insertFirst(100);
        System.out.println(sss.size());
        System.out.println(sss.getFirst().data);
        System.out.println(sss.getLast().data);
        sss.removeFirst();
        System.out.println(sss.getFirst().data);
        sss.removeLast(); // takes out the one

        sss.insertLast(333);
        sss.insertLast(444);
        System.out.println("Cur size " + sss.size());
        System.out.println(sss.getLast().data);

        for(int i =0; i < sss.size(); i++){
            System.out.println("this is the order " + sss.getAt(i).data);
        }
        sss.removeAt(0);

        for(int i =0; i < 33; i++){
            sss.insertFirst(i);
        }
        System.out.println("-------------------------------------------");
        for(int i =0; i < sss.size(); i++){
            System.out.println("this is the order " + sss.getAt(i).data);
        }

        sss.removeAt(5);
        System.out.println("-------------------------------------------");
        for(int i =0; i < sss.size(); i++){
            System.out.println("this is the order " + sss.getAt(i).data);
        }

    }
    StephenNode head = null;

    public LinkedList_Stephen(){

    }

    public void insertFirst(int input){
        // could also do this
        // StephenNode newNode = new StephenNode(input, this.head);
        StephenNode newNode = new StephenNode(input);
        if(head != null){
            StephenNode oldNode = head;
            head = newNode;
            head.nextNode = oldNode;
        }else{
            head = newNode;
        }
    }

    public int size(){
        int count = 0;
        StephenNode currentNode = this.head;
        while(currentNode != null){
            count++;
            currentNode = currentNode.nextNode;
        }
        return count;
    }

    public StephenNode getFirst(){
        return this.head;
    }

    public StephenNode getLast(){
        StephenNode currentNode = this.head;
        while(currentNode.nextNode != null){
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    public void clear(){
        this.head = null;
    }

    public void removeFirst(){
        if(this.head != null){
            this.head = this.head.nextNode;
        }
    }

    public void removeLast(){
        if(this.head.nextNode == null){
            this.head = null;
            return;
        }
        if(this.head != null){
            StephenNode currentNode = this.head;
            while(currentNode.nextNode != null && currentNode.nextNode.nextNode != null){
                currentNode = currentNode.nextNode;
            }
            System.out.println("Following node with data " + currentNode.nextNode.data + " has been removed");
            currentNode.nextNode = null;
        }
    }

    public void insertLast(int dataIn){
        StephenNode newNode = new StephenNode(dataIn);
        if(this.head == null){
            this.head = newNode;
            return;
        }

        StephenNode curNode = this.head;

        while(curNode.nextNode != null){
            curNode = curNode.nextNode;
        }

        curNode.nextNode = newNode;

    }

    public StephenNode getAt(int index){
        if(index > (this.size()-1) || index < 0){
            return null;
        }
        if(this.head == null){
            return null;
        }
        StephenNode curNode = this.head;
        int curCount = 0;
        while(curCount != index){
            curNode = curNode.nextNode;
            curCount++;
        }

        return curNode;
    }

    public void removeAt(int index){
        if(index == 0){
            this.removeFirst();
            return;
        }
        if(index > (this.size()-1) || index < 0){
            return;
        }
        if(this.head == null){
            return;
        }

        int count = 0;
        StephenNode curNode = this.head;
        StephenNode prev = null;
        while(count != index){
            prev = curNode;
            curNode = curNode.nextNode;
            count++;
        }

        prev.nextNode = curNode.nextNode;
    }
}
