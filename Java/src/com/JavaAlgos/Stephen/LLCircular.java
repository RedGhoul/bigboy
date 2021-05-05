package com.JavaAlgos.Stephen;

public class LLCircular {
    public static void main(String[] args){
        LinkedList_Stephen ll = new LinkedList_Stephen();
        ll.insertFirst(1);
        ll.insertFirst(2);
        ll.insertFirst(3);
        ll.insertFirst(4);
        ll.insertFirst(5);
        ll.insertFirst(66);
        StephenNode nodeMain = ll.getLast();
        StephenNode nodeTie = ll.getAt(1);
        nodeMain.nextNode = nodeTie;

        System.out.println(isCircular(ll));


        LinkedList_Stephen ll2 = new LinkedList_Stephen();
        ll2.insertFirst(1);
        ll2.insertFirst(2);
        ll2.insertFirst(3);
        ll2.insertFirst(4);
        ll2.insertFirst(5);
        ll2.insertFirst(66);
        System.out.println(isCircular(ll2));

    }

    public static boolean isCircular(LinkedList_Stephen ll){
        if(ll == null || ll.head == null || ll.head.nextNode == null) return false;

        StephenNode p1 = ll.head;
        StephenNode p2 = p1;

        while (p2.nextNode != null && p2.nextNode.nextNode != null){

            p1 = p1.nextNode;
            p2 = p2.nextNode.nextNode;

            if(p1 == p2){
                return true;
            }
        }
        return false;
    }
}
