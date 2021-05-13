package com.JavaAlgos.Stephen;

public class BackFromTailLL {
    public static void main(String[] args){
        LinkedList_Stephen ll = new LinkedList_Stephen();
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(3);
        ll.insertLast(4);
        ll.insertLast(5);
        ll.insertLast(66);

        System.out.println(StepXFromTail(ll,6).data);
    }

    public static StephenNode StepXFromTail(LinkedList_Stephen ll, int n){
        if(n <= 1) return ll.head;
        if(n > ll.size()) return null;
        StephenNode p1 = ll.head;
        StephenNode p2 = ll.head;

        int count = 1;
        while(count < n && p2.nextNode != null){
            p2 = p2.nextNode;
            count++;
        }

        if(p2.nextNode == null){
            return p1;
        }

        while(p2.nextNode != null){
            p1 = p1.nextNode;
            p2 = p2.nextNode;
        }

        return p1;
    }
}
