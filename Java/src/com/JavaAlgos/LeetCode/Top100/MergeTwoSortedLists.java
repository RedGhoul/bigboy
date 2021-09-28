package com.JavaAlgos.LeetCode.Top100;
class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
public class MergeTwoSortedLists {
    /***
     * Merge two sorted linked lists and return it as a sorted list.
     * The list should be made by splicing together the nodes of the first two lists.
     *
     * Input: l1 = [1,2,4], l2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     * Example 2:
     *
     * Input: l1 = [], l2 = []
     * Output: []
     * Example 3:
     *
     * Input: l1 = [], l2 = [0]
     * Output: [0]
     *
     *
     * Problem Key:
     * O(N)
     * One loop to compare
     * One loop for the leftover right stuff
     * One loop for the leftover left stuff
     *
     * What did I learn from this:
     * pay attention to ifs
     *
     * What mistakes did I make:
     * - Not taking my "IF" statements seriously
     * aka not paying enough attention to them
     *
     * */
    public static void main(String[] args){
        Test1();
        Test2();
        Test3();
    }

    private static void Test1() {
        ListNode temp10 = new ListNode(-1);
        ListNode temp1 = new ListNode(1);
        ListNode temp12 = new ListNode(2);
        ListNode temp13 = new ListNode(4);
        temp10.next = temp1;
        temp1.next = temp12;
        temp12.next = temp13;

        ListNode temp2 = new ListNode(1);
        ListNode temp22 = new ListNode(3);
        ListNode temp23 = new ListNode(4);
        temp2.next = temp22;
        temp22.next = temp23;

        ListNode temp = mergeTwoLists(temp10, temp2);
    }

    private static void Test2() {
        ListNode temp10 = new ListNode(-1);

        ListNode temp2 = null;

        ListNode temp = mergeTwoLists(temp10, temp2);
    }

    private static void Test3() {
        ListNode temp10 = null;

        ListNode temp2 = null;

        ListNode temp = mergeTwoLists(temp10, temp2);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     *
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode l1temp = l1;
        ListNode l2temp = l2;
        if(l1 != null || l2 != null){
            if((l1temp != null && l2temp == null)){
                newHead = new ListNode(l1temp.val);
                l1temp = l1temp.next;
            }else if(l1temp == null && l2temp != null){
                newHead = new ListNode(l2temp.val);
                l2temp = l2temp.next;
            }
            else if(l1temp.val <= l2temp.val){
                newHead = new ListNode(l1temp.val);
                l1temp = l1temp.next;
            }else if (l1temp.val >= l2temp.val){
                newHead = new ListNode(l2temp.val);
                l2temp = l2temp.next;
            }

            ListNode newTemp = newHead;

            while(l1temp != null && l2temp != null){
                if(l1temp.val <= l2temp.val){
                    newTemp.next = new ListNode(l1temp.val);
                    l1temp = l1temp.next;
                }else{
                    newTemp.next = new ListNode(l2temp.val);
                    l2temp = l2temp.next;
                }
                newTemp = newTemp.next;
            }

            while(l1temp != null) {
                newTemp.next = new ListNode(l1temp.val);
                newTemp = newTemp.next;
                l1temp = l1temp.next;
            }

            while(l2temp != null) {
                newTemp.next = new ListNode(l2temp.val);
                newTemp = newTemp.next;
                l2temp = l2temp.next;
            }
        }

        return newHead;
    }


}
