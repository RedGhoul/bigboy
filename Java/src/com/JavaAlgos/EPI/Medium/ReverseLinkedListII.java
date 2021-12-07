package com.JavaAlgos.EPI.Medium;

import com.JavaAlgos.LeetCode.Top100.ListNode;

public class ReverseLinkedListII {
    /**
     * Given the head of a singly linked list and two integers left and right where left <= right,
     * reverse the nodes of the list from position left to position right, and return the reversed list.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [1,2,3,4,5], left = 2, right = 4
     * Output: [1,4,3,2,5]
     * Example 2:
     * <p>
     * Input: head = [5], left = 1, right = 1
     * Output: [5]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is n.
     * 1 <= n <= 500
     * -500 <= Node.val <= 500
     * 1 <= left <= right <= n
     * <p>
     * Basically the algo is
     * <p>
     * Reverse only whats between m & n everything else is trash, BUT keep track of the point before m,
     * and the point after n
     * <p>
     * Take the point before m, and you point it to the end of the revesed section
     * <p>
     * Set the start of the newly reversed ll to the point after n
     **/

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
