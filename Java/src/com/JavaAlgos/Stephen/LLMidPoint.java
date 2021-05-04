package com.JavaAlgos.Stephen;

public class LLMidPoint {
    public static void main(String[] args){
        LinkedList_Stephen llS = new LinkedList_Stephen();
        llS.insertLast(1);
        llS.insertLast(2);
        llS.insertLast(3);
        llS.insertLast(4);
        llS.insertLast(5);
        System.out.println(FindMidPoint(llS).data);
    }

    // Move one node faster then the other
    public static StephenNode FindMidPoint(LinkedList_Stephen linkedListStephen){
        if(linkedListStephen.head == null) return null;
        if(linkedListStephen.head.nextNode == null) return linkedListStephen.head;

        StephenNode p1 = linkedListStephen.head;
        StephenNode p2 = p1;

        while(p2.nextNode != null && p2.nextNode.nextNode != null){
            p1 = p1.nextNode;
            p2 = p2.nextNode.nextNode;
        }
        return p1;
    }

}
