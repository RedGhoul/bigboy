package com.JavaAlgos.Grokking.Medium;

import com.JavaAlgos.LeetCode.Top100.ListNode;

public class PalindromeLinkedList {
    /**
     * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
     *
     * Your algorithm should use constant space and the input LinkedList should be in the
     * original form once the algorithm is finished. The algorithm should have O(N)time
     * complexity where ‘N’ is the number of nodes in the LinkedList.
     *
     * Example 1:
     *
     * Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
     * Output: true
     * Example 2:
     *
     * Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
     * Output: false
     *
     * What I am thinking:
     * Since they say to have a constant space complexity. I am going to assume
     * I can not use a Stack, List, or Hashmap.
     *
     * So I am thing going to just try to stick to the over all theme of these questions,
     * which is just one fast, one slow pointer.
     *
     * Slow pointer start, then fast pointer going to till it reaches the end
     * Then move slow pointer by one, and then restart the fast pointer minus the last run length
     *
     * Seems like this will be in double for loop territory
     *
     * The really had thing is the fact we need to use O(1) space and O(n) time.
     *
     *
     * 99 -> 61 -> 2 -> 4 -> 6 -> 4 -> 2 -> 61 -> 99
     *
     * Find the middle and reverse from there
     *
     * then compare
     *
     * then un reverse from there
     *
     * **/

    public static boolean isPalindrome(ListNode head) {
        // we find the middle
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // we reverse half
        ListNode p4 = reverse(p1.next);
        ListNode p4Copy = p4;
        ListNode p3 = head;

        while(p3 != null && p4 != null){
            if(p3.val != p2.val) return false;
            p3 = p3.next;
            p4 = p4.next;
        }
        if(p2 == null || p3 == null) return false;

        // un reverse
        reverse(p4Copy);
        return true;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode future = null;

        while(cur != null){
            future = cur.next;
            cur.next = prev;
            prev = cur;
            cur = future;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));
    }


    public static boolean isPalindromeVActuallyWorks(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // find middle of the LinkedList
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverseVActuallyWorks(slow); // reverse the second half
        ListNode copyHeadSecondHalf = headSecondHalf; // store the head of reversed part to revert back later

        // compare the first and the second half
        while (head != null && headSecondHalf != null) {
            if (head.val != headSecondHalf.val) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverseVActuallyWorks(copyHeadSecondHalf); // revert the reverse of the second half
        if (head == null || headSecondHalf == null) // if both halves match
            return true;
        return false;
    }

    private static ListNode reverseVActuallyWorks(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
