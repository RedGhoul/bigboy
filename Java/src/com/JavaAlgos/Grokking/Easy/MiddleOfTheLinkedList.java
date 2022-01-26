package com.JavaAlgos.Grokking.Easy;

public class MiddleOfTheLinkedList {
    /**
     * PATTERN: FAST SLOW POINTERS
     * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
     *
     * If the total number of nodes in the LinkedList is even, return the second middle node.
     *
     * What I am thinking:
     * Way 1:
     * 1) Go through the linked list once, and find the length.
     * 2) Then go through it another time and stop at the length /2,
     * to find the middle
     *
     * Way 2:
     * 1) Use the two pointer technique. One fast, one slow.
     * 2) If the fast pointer points to a node that is pointing to null
     * or is null stop and return the slow pointer
     *
     * I was right !
     *
     * Time complexity:
     * O(N) just loop through
     *
     * Space Complexity:
     * O(1) not creating new stuff to store stuff
     * **/

    public static ListNode findMiddle(ListNode head) {
        // I think I am just going to use way 2
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + findMiddle(head).value);
    }
}
