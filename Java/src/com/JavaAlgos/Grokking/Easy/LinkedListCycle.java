package com.JavaAlgos.Grokking.Easy;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}
public class LinkedListCycle {
    /**
     * Use your fears to drive you in the right direction !!!
     *
     * remember how crazy useful two binary search / modified binary search can be
     *
     * Given the head of a Singly LinkedList, write a function to
     * determine if the LinkedList has a cycle in it or not.
     *
     * What I am thinking:
     * This is a classic fast slow problem
     * P1 points to first
     * P2 points to first
     *
     * Get into a loop
     * While(true)
     * P1 is moved forward by one
     * P2 is moved forward by two
     * if(p2.next != null && p2.next.next != null) return false
     * if(P1 == P2) return true
     *
     * return false;
     *
     * time complexity is:
     * O(n) go through the whole list exactly once
     * Space complexity is:
     * O(1) you aren't making anything that is new,
     * just using something that is already there
     * **/
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }

    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode p1 = head;
        ListNode p2 = head;

        while(true){
            p1 = p1.next;
            if(p2.next != null && p2.next.next != null){
                p2 = p2.next.next;
            }
            else {
                return false;
            }
            if(p1 == p2 && p1 != null){
                return true;
            }
        }
    }

    /** a more compact version that does not rely upon an
    always true while loop **/
    public static boolean hasCycleV2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // you were already thinking about adding this as a condition
        // but did it as an if above. Cause if this condition ever
        // becomes true it proves that there is an end to the linked list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true; // found the cycle
        }
        return false;
    }

}
