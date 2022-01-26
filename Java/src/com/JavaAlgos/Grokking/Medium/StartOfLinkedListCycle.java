package com.JavaAlgos.Grokking.Medium;


import com.JavaAlgos.LeetCode.Top100.ListNode;

import java.util.List;

public class StartOfLinkedListCycle {
    /**
     * I guess one way of doing it would be to increment p1 by one
     * Then go all the way to the end with the p2 incrementing by 1
     * If that pointer doesn't see p1, but loops back
     *
     * I guess another of doing this would be to use some sort of hashmap
     * as you go through to catch if you see something more than once
     *
     * After learning the secrets:
     * Intuition is that you don't need to do everything at once. You can break it into
     * multiple parts.
     *
     * Like what you did with LinkedListCycleFindLength question:
     * A) you realized that there was cycle in the linked list
     * B) you could figure out the length by, moving the pointer
     * till it looped back on its self
     *
     * So you that there are two part. Now the funny is that all you had to do
     * Is just add to it to figure this out.
     *
     * All you had to do was recognized you just needed a part C)
     * Now to get to the start of the linked list you just needed its length (X)
     * So now all you had to do was move the fast pointer X places forward
     * then move them both one at a time, till they meet up again, which would be at the start
     * of the linked list
     *
     * Time complexity:
     * O(N) since there are no double for loops, and we are just going straight through
     * Space complexity:
     * O(1) since we aren't allocating a large list of things
     * What did I learn from this ?
     *
     * - Your in the two pointer section, of course you can do it with two pointers !
     * - So you have a tendency to look at a problem as all at once or nothing
     * sort of thing. But as we saw here, they can be broken up into chunks, or
     * you can keep building on top of answers to the smaller questions
     *
     * To find the start, all you need is the length of the cycle. And you need to move one pointer
     * all the way X places, and then move them one at a time till the end up pointing to the same
     * thing
     * **/
    public static ListNode findCycleStart(ListNode head) {
        // Part A)
        ListNode p1 = head;
        ListNode p2 = head;

        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;

            if(p1 == p2){
                break;
            }
        }

        // Part B)
        int count = 0;
        ListNode p3 = p2.next;
        while(p3 != p2){
            count++;
            p3 = p3.next;
        }

        // Part C)
        p1 = head;
        p2 = head;
        while(count > 0){
            p2 = p2.next;
            count--;
        }

        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).val);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).val);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).val);
    }
}
