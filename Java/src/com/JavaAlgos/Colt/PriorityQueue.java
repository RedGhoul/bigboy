package com.JavaAlgos.Colt;


import java.util.ArrayList;

public class PriorityQueue {
    public ArrayList<PQNode> values = new ArrayList<>();

    public void main(String args){

    }

    // Dequeue you pull off the top
    // taking the bottom and putting it on the top
    // then "bubbling down"
    public PQNode Dequeue(){
        PQNode extracted = this.values.remove(0);
        PQNode temp = this.values.remove(this.values.size()-1);
        this.values.add(0, temp);
        if(this.values.size() == 1){
            this.values = new ArrayList<>();
            return extracted;
        }
        int curPos = 0;
        int rightPos = getChildRight(curPos);
        int leftPos = getChildLeft(curPos);
        PQNode cur = this.values.get(0);
        PQNode curLeft = null;
        PQNode curRight = null;

        while(rightPos <= this.values.size()-1 || leftPos <= this.values.size()-1){

            if(rightPos <= this.values.size()-1 ){
                curRight = this.values.get(rightPos);
            }
            if(leftPos <= this.values.size()-1){
                curLeft = this.values.get(leftPos);
            }

            if(curLeft.priority < curRight.priority && curLeft.priority < cur.priority){
                swap(curPos,leftPos);
                curPos = leftPos;
            }else if(curRight.priority < curRight.priority && curRight.priority < cur.priority){
                swap(curPos,rightPos);
                curPos = rightPos;
            }

        }

        return extracted;
    }
    // Enqueue is "bubbling up"
    public void Enqueue(PQNode node){
        this.values.add(node);
        int curIndex = this.values.size()-1;
        int parIndex = getParent(this.values.size()-1);
        PQNode cur = node;
        PQNode ParNode = this.values.get(parIndex);
        while(cur.priority < ParNode.priority){
            swap(curIndex,parIndex);
            curIndex = parIndex;
            parIndex = getParent(curIndex);
            cur = this.values.get(curIndex);
            ParNode = this.values.get(parIndex);
        }

    }

    public void swap(int a, int b){
        PQNode temp = this.values.get(a);

        this.values.set(a,this.values.get(b));
        this.values.set(b,temp);
    }

    public static int getParent(int pos){
        if(pos == 0) return 0;
        return (int) Math.floor((pos-1)/2);
    }
    public static int getChildLeft(int pos){
        return 2 * pos + 1;
    }

    public static int getChildRight(int pos){
        return 2 * pos + 2;
    }

}
