package com.JavaAlgos.LeetCode.Top100;
import java.util.*;
public class IntersectionofTwoLinkedLists {
    /**
     * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
     *
     * For example, the following two linked lists begin to intersect at node c1:
     *
     *
     * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
     *
     * Note that the linked lists must retain their original structure after the function returns.
     *
     * Custom Judge:
     *
     * The inputs to the judge are given as follows (your program is not given these inputs):
     *
     * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
     * listA - The first linked list.
     * listB - The second linked list.
     * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
     * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
     * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * Output: Intersected at '8'
     * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
     * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
     * Example 2:
     *
     *
     * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * Output: Intersected at '2'
     * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
     * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
     * Example 3:
     *
     *
     * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * Output: No intersection
     * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
     * Explanation: The two lists do not intersect, so return null.
     *
     *
     * What I think I can do:
     * Guessing we just use a hash map, go through
     * each linked list and store what each one was pointing to
     *
     * Then go through each hash map and see if it was pointing to something else
     *
     * I just want to know if there is a intersection
     *
     * Problem Key
     * traversing two linked lists and storing the answer in something
     * doesn't always have to be a hashmap
     *
     * When you compare two lists you may have to reverse them
     *
     * Things I learned
     * always draw out what you are trying to do if you can.
     *
     * Pattern
     * While loop for going through a tree
     * Storing stuff and comparing while going through a linked list
     * **/
    public static void main(String[] args){

    }


//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if(headA == null || headB == null) return null;
//        HashMap<ListNode, ListNode> HashMapA = new HashMap<>();
//        ListNode curNodeA = headA;
//        while(curNodeA != null){
//            HashMapA.put(curNodeA.next,curNodeA);
//            curNodeA = curNodeA.next;
//        }
//
//        HashMap<ListNode, ListNode> HashMapB = new HashMap<>();
//        ListNode curNodeB = headB;
//        while(curNodeB != null){
//            HashMapB.put(curNodeB.next,curNodeB);
//            curNodeB = curNodeB.next;
//        }
//
//        for(Map.Entry<ListNode,ListNode> entry: HashMapA.entrySet()){
//            if(HashMapB.containsKey(entry.getKey())){
//                return entry.getKey();
//            }
//        }
//        return null;
//    }
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            if(headA == headB) return headA;

            ArrayList<ListNode> nodesA = new ArrayList<>();
            ListNode curNodeA = headA;
            while(curNodeA.next != null){
                nodesA.add(curNodeA);
                curNodeA = curNodeA.next;
            }
            if(nodesA.size() == 0){
                nodesA.add(headA);
            }
            ArrayList<ListNode> nodesB = new ArrayList<>();
            ListNode curNodeB = headB;
            while(curNodeB.next != null){
                nodesB.add(curNodeB);
                curNodeB = curNodeB.next;
            }
            if(nodesB.size() == 0){
                nodesB.add(headB);
            }

            Collections.reverse(nodesA); // each is a O(n) complexity
            Collections.reverse(nodesB);
            int loopSize = 0;
            if(nodesA.size() > nodesB.size()){
                loopSize = nodesA.size();
            }else{
                loopSize = nodesB.size();
            }
            for(int i = 0; i < loopSize; i++){
                ListNode curNode1 = null;
                if(i < nodesA.size()){
                    curNode1 = nodesA.get(i);
                }

                ListNode curNode2 = null;
                if(i < nodesB.size()){
                    curNode2 = nodesB.get(i);
                }

                if(i != 0 && curNode1 != curNode2){
                    int valIndex = i -1;
                    if(valIndex < nodesA.size() &&
                            valIndex < nodesB.size() &&
                            nodesA.get(valIndex) == nodesB.get(valIndex)){
                        return nodesA.get(valIndex) == null ? nodesB.get(valIndex) : nodesA.get(valIndex);
                    }
                }
            }
            return null;
        }

}
