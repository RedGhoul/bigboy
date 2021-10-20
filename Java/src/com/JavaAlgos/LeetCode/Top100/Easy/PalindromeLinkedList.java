package com.JavaAlgos.LeetCode.Top100.Easy;

public class PalindromeLinkedList {
    /**
     * Given the head of a singly linked list, return true if it is a palindrome.
     *
     * Example 1:
     * Input: head = [1,2,2,1]
     * Output: true
     * Example 2:
     *
     *
     * Input: head = [1,2]
     * Output: false
     *
     *
     * Constraints:
     *
     * The number of nodes in the list is in the range [1, 105].
     * 0 <= Node.val <= 9
     *
     *
     * Follow up: Could you do it in O(n) time and O(1) space?
     *
     * What I am thinking:
     *
     * Easiest thing to do is just run through the linked list,
     * and put everything into an array list
     *
     * Then use the double pointer method
     *
     * But it wouldn't be O(1) space complexity
     *
     * So I am going to:
     *
     * A) Find the middle of the ll
     * B) Then reverse it from there
     * C) Compare the two
     * **/
    public static void main(String[] args){

    }

    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return true;
        ListNode prev = null;
        ListNode start = head;
        ListNode end = null;

        ListNode current = null;

        while(start != null){
            prev = start;
            start = start.next;
            end = start.next;
            if(start == null) return false;
            if(prev.val == start.val){
                current = start;
                break;
            }
            if(end == null) return false;
            if(prev.val == end.val){
                current = end;
                break;
            }
        }


        ListNode past = null;
        ListNode future = null;
        while(current != null){
            future = current.next;
            current.next = past;
            past = current;
            current = future;
        }

        while(past != null && head != null){
            if(past.val != head.val) return false;
            past = past.next;
            head = head.next;
        }
        return true;
    }
}
