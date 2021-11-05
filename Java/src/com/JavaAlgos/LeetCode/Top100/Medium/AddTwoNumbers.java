package com.JavaAlgos.LeetCode.Top100.Medium;

import com.JavaAlgos.LeetCode.Top100.ListNode;

public class AddTwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
     * order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     * Example 2:
     *
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     * Example 3:
     *
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     *
     * */
    public static void main(String[] args){
        ListNode n1= new ListNode(2);
        var n2 = new ListNode(4);
        var n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode a1= new ListNode(5);
        var a2 = new ListNode(6);
        var a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;

        ListNode finalAn = addTwoNumbers(n1, a1);
        System.out.println(finalAn);

        ListNode n11= new ListNode(9);
        var n12 = new ListNode(9);
        var n13 = new ListNode(9);
        var n14 = new ListNode(9);
        var n15 = new ListNode(9);
        var n16 = new ListNode(9);
        var n17 = new ListNode(9);
        var n18 = new ListNode(9);
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;
        n15.next = n16;
        n16.next = n17;
        n17.next = n18;

        ListNode a11= new ListNode(5);
        var a12 = new ListNode(6);
        var a13 = new ListNode(4);
        a11.next = a12;
        a12.next = a13;

        ListNode finalAna = addTwoNumbers(n11, a11);
        System.out.println(finalAna);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         1 1
         9,9,9,9,9,9,9
         9,9,9,9
         8 9

         Have two pointers, point to the two diff linked lists

         Then create a 3rd pointer (this is gonna be our answer)
         then create a headToNewPointer (p3)
         carryOver = 0;

         loop

         if p1.next != null || p2.next != null:

         int sumValue = p1.value + p2.value + carryOver;
         carryOver = 0;
         if(sumValue > 9){
         carryOver = Math.Floor(sumValue / 10 % 10)
         }
         if(p3 == null){
         p3 = new ListNode(sumValue % 10)
         }else{
         p3.next = new ListNode(sumValue % 10);

         What I learned:
         You can get what number is where using this sort of system
         By using division and the modulo operator
         var ones = Math.floor(num % 10),
         tens = Math.floor(num/10 % 10),
         hundreds = Math.floor(num/100 % 10),
         thousands = Math.floor(num/1000 % 10),
         tenThousands = Math.floor(num / 10000 % 10),
         hundredThousands = Math.floor(num / 100000 % 10),
         millions = Math.floor(num / 1000000 % 10),
         tenMillions = Math.floor(num / 10000000 % 10),
         hundredMillions = Math.floor(num / 100000000 % 10);
         }

         What could have done better:
         - Go deeper in your play through of different values through the program
         - Missed a few main cases that cause the program to error out

         What I did well:
         You actually did 95% of this code, without the help of a code editor
         **/
        int carryOver = 0;
        ListNode p3 = null;
        ListNode returnHead = null;
        while(l1 != null && l2 != null){

            int sumValue = l1.val + l2.val + carryOver;
            carryOver = 0;
            if(sumValue > 9){
                carryOver = (int)Math.floor(sumValue / 10 % 10);
            }
            if(p3 == null){
                p3 = new ListNode(sumValue % 10);
                returnHead = p3;
            }else{
                p3.next = new ListNode(sumValue % 10);
                p3 = p3.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int sumValue = carryOver + l1.val;
            carryOver = 0;
            if(sumValue > 9){
                carryOver = (int)Math.floor(sumValue / 10 % 10);
            }

            p3.next = new ListNode(sumValue % 10);
            p3 = p3.next;
            l1 = l1.next;
        }


        while(l2 != null){
            int sumValue = carryOver + l2.val;
            carryOver = 0;
            if(sumValue > 9){
                carryOver = (int)Math.floor(sumValue / 10 % 10);
            }

            p3.next = new ListNode(sumValue % 10);
            p3 = p3.next;
            l2 = l2.next;
        }

        if(carryOver == 1){
            p3.next = new ListNode(carryOver);
        }

        return returnHead;

    }
}
