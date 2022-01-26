package com.JavaAlgos.Grokking.Medium;

import com.JavaAlgos.LeetCode.Top100.ListNode;

public class RearrangeALinkedList {
    /**
     * Problem Statement
     * Given the head of a Singly LinkedList, write a method to modify
     * the LinkedList such that the nodes from the second half of the
     * LinkedList are inserted alternately to the nodes from the first half
     * in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null,
     * your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
     *
     * Your algorithm should not use any extra space and the input
     * LinkedList should be modified in-place.
     *
     * Example 1:
     *
     * Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
     * Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
     * Example 2:
     *
     * Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
     * Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
     *
     * What I am thinking:
     * Do this stuff in two parts
     * 1) Find the middle node
     * 2) Reverse from the middle node to the end
     * 3) Interweave these two linked lists together
     *
     * YAY my logic was right !!!
     *
     * What I learned: You can do stuff in smaller parts.
     * You can break it down into a bunch of little pieces
     *
     * **/
    public static void reorder(ListNode head) {
        if(head == null) return;
        //1) finding the middle
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //2) reverse from the middle to the end
        ListNode middle = slow;

        ListNode prev = null;
        ListNode cur = middle;
        ListNode future = null;

        while(cur != null){
            future = cur.next;
            cur.next = prev;
            prev = cur;
            cur = future;
        }

        ListNode newReHalf = prev;

        //3 interweave nodes

        ListNode start = head;
        ListNode end = slow;
        while(start != end){ // so it seems like this logic was wrong
            ListNode next = start.next;
            start.next = newReHalf;
            newReHalf = newReHalf.next;
            start.next.next = next;
            start = start.next.next;
        }
        end.next = null;
    }
    public static void reorderV2(ListNode head) {
        if (head == null || head.next == null)
            return;

        // find the middle of the LinkedList
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now pointing to the middle node
        ListNode headSecondHalf = reverse(slow); // reverse the second half
        ListNode headFirstHalf = head;

        // rearrange to produce the LinkedList in the required order
        while (headFirstHalf != null && headSecondHalf != null) {
            ListNode temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }

        // set the next of the last node to 'null'
        if (headFirstHalf != null)
            headFirstHalf.next = null;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        reorder(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
