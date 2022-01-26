package com.JavaAlgos.Grokking.Easy;

public class LinkedListCycleFindLength {
    /**
     * PATTERN: FAST SLOW POINTERS
     * Given the head of a LinkedList with a cycle,
     * find the length of the cycle.
     *
     * Part 1) Use what you did in "LinkedListCycle" as the first part.
     * Part 2) Then use the node that is the intersection of the two pointers in part 1,
     * as your starting point, and start moving your new pointer by one. And counting each
     * move, till you find your self back at the pointer you came to in Part 1.
     * **/
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + findCycleLength(head));
    }
    public static int findCycleLength(ListNode head){
        if(head == null || head.next == null) return 0;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = null;
        while(true){
            p1 = p1.next;
            if(p2.next != null && p2.next.next != null){
                p2 = p2.next.next;
            }
            else {
                return 0;
            }
            if(p1 == p2 && p1 != null){
                p3 = p1;
                break;
            }
        }
        /**
         * Do the standard find cycle in linked list
         * Then take the loop back node (node where p1 == p2)
         * Move over one on another pointer. Then keep moving
         * to the next and counting till you get back
         * to the loop back node.
         * **/

        int length = 1;
        p1 = p3.next;
        while(p1 != p3){
            p1 = p1.next;
            length++;
        }
        return length;
    }
}
