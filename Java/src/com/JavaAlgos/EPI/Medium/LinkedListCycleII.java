package com.JavaAlgos.EPI.Medium;

import com.JavaAlgos.LeetCode.Top100.ListNode;

public class LinkedListCycleII {
    /**
     * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
     * <p>
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
     * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
     * connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
     * <p>
     * Do not modify the linked list.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [3,2,0,-4], pos = 1
     * Output: tail connects to node index 1
     * Explanation: There is a cycle in the linked list, where tail connects to the second node.
     * Example 2:
     * <p>
     * <p>
     * Input: head = [1,2], pos = 0
     * Output: tail connects to node index 0
     * Explanation: There is a cycle in the linked list, where tail connects to the first node.
     * Example 3:
     * <p>
     * <p>
     * Input: head = [1], pos = -1
     * Output: no cycle
     * Explanation: There is no cycle in the linked list.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of the nodes in the list is in the range [0, 104].
     * -105 <= Node.val <= 105
     * pos is -1 or a valid index in the linked-list.
     * <p>
     * <p>
     * Follow up: Can you solve it using O(1) (i.e. constant) memory?
     * <p>
     * <p>
     * First thought was a hashtable and I was write. BUT then it wouldn't be constant space :(
     * So have to do some magic
     * <p>
     * The magic in this case is to notice there is a cycle.
     * 1) Then find the length of the cycle - move fast up by one and see how long it takes to get back from fast.next
     * to slow by incrementing by one
     * 2) And then go from head to the end of the length of the cycle, based on the length you got from step 1 - P1
     * 3) Then take P2 and move it one node at a time along with P1, till they both point to the same thing
     * And that is your final cycle node
     **/
    public ListNode detectCycle0(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {

            }
        }

        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (head != fast) {
                    // don't have to do part 2 since you already
                    // at a place in the node cycle with fast
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
