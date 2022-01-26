package com.JavaAlgos.Grokking.Hard;

public class CycleInACircularArray {
    /**
     * PATTERN: FAST SLOW POINTERS
     * Cycle in a Circular Array (hard)
     * We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’
     * at a particular index. Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move
     * backwards ‘M’ indices. You should assume that the array is circular which means two things:
     *
     * If, while moving forward, we reach the end of the array, we will jump to the first element to continue the
     * movement.
     * If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue
     * the movement.
     * Write a method to determine if the array has a cycle. The cycle should have more than one element and should
     * follow one direction which means the cycle should not contain both forward and backward movements.
     *
     * Example 1:
     *
     * Input: [1, 2, -1, 2, 2]
     * Output: true
     * Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0
     * Example 2:
     *
     * Input: [2, 2, -1, 2]
     * Output: true
     * Explanation: The array has a cycle among indices: 1 -> 3 -> 1
     * Example 3:
     *
     * Input: [2, 1, -1, -2]
     * Output: false
     * Explanation: The array does not have any cycle.
     *
     * Thoughts:
     * A couple of points that try to reach the original pointer
     *
     * This is legit the standard two pointer thing in regular linked lists
     *
     * Except the cycle can be only forward or backwards not both
     * If the pointer ends up pointing backwards after a move the whole thing
     * is done. Since there can be no backwards forward again cycle. It all
     * has to in one smooth direction
     *
     *
     * Time Complexity:
     * O(N^2)
     * Cause we have a while loop inside of a for loop. Where we are checking
     * every since point in the array if its a loop.
     * So if i = 1, and length = 9, then we have search through the rest of the 7.
     * And try two find a loop from i = 1
     * Space Complexity: O(1)
     *
     *
     * An Alternate Approach#
     * In our algorithm, we don’t keep a record of all the numbers that have been evaluated for cycles.
     * We know that all such numbers will not produce a cycle for any other instance as well. If we can
     * remember all the numbers that have been visited, our algorithm will improve to O(N)O(N) as, then, each
     * number will be evaluated for cycles only once. We can keep track of this by creating a separate array,
     * however, in this case, the space complexity of our algorithm will increase to O(N).O(N).
     * **/
    public static boolean loopExists(int[] arr) {
        int p1 = 0;
        while(arr[p1] != -1*arr[p1+1]){
            p1 = p1+arr[p1];
            if(p1 > arr.length-1){
                p1 = arr[p1] - (arr.length-1-p1);
            }
        }
        return false;
    }

    public static boolean loopExistsV2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0; // if we are moving forward or not
            int slow = i, fast = i;

            // if slow or fast becomes '-1' this means we can't find cycle for this number
            do {
                slow = findNextIndexV2(arr, isForward, slow); // move one step for slow pointer
                fast = findNextIndexV2(arr, isForward, fast); // move one step for fast pointer
                if (fast != -1)
                    fast = findNextIndexV2(arr, isForward, fast); // move another step for fast pointer
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast)
                return true;
        }

        return false;
    }

    private static int findNextIndexV2(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward != direction)
            return -1; // change in direction, return -1

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
        if (nextIndex < 0)
            nextIndex += arr.length; // wrap around for negative numbers

        // one element cycle, return -1
        if (nextIndex == currentIndex)
            nextIndex = -1;

        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
