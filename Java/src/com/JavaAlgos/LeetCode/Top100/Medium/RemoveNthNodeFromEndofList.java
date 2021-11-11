package com.JavaAlgos.LeetCode.Top100.Medium;

import com.JavaAlgos.LeetCode.Top100.ListNode;

public class RemoveNthNodeFromEndofList {
    public static void main(String[] args){

    }

    /**
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     * Example 2:
     *
     * Input: head = [1], n = 1
     * Output: []
     * Example 3:
     *
     * Input: head = [1,2], n = 1
     * Output: [1]
     *
     *
     * Constraints:
     *
     * The number of nodes in the list is sz.
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     * What did I learn from this ?
     * Don't forget your semi colons
     * Try a ton of cases before submission
     * Try middle cases as well and work through your logic
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        if(head.next == null){
            return null;
        }
        rightBeforeP1
        headPointer = head;
        p1 = head;
        p2 = head;

        int numberOfStepsFromEnd = n - 1;

        p1 = head
        p2 = head

        for(int i = 0; i < numberOfStepsFromEnd; i++){
            p2 = p2.next;
        }

        while(p2.next != null){
            rightBeforeP1 = p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        if(n == 0){
            rightBeforeP1.next = null;
        }else{
            rightBeforeP1.next = p2;
        }


        return headPointer;

        */

        if(head.next == null){
            return null;
        }
        ListNode rightBeforeP1 = null;
        ListNode headPointer = head;
        ListNode p1 = head;
        ListNode p2 = head;

        int numberOfStepsFromEnd = n - 1;

        p1 = head;
        p2 = head;

        for(int i = 0; i < numberOfStepsFromEnd; i++){
            p2 = p2.next;
        }

        while(p2.next != null){
            rightBeforeP1 = p1;
            p1 = p1.next;
            p2 = p2.next;

        }

        if(numberOfStepsFromEnd == 0){
            rightBeforeP1.next = null;
        }else{
            if(rightBeforeP1 == null){
                return p1.next;
            }
            rightBeforeP1.next = p1.next;
        }


        return headPointer;

    }
}
