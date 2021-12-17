package com.JavaAlgos.LeetCode.Top100.Easy;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
        System.out.println(remove(new int[]{2, 2, 2, 11}));
        System.out.println(remove(new int[]{2, 3, 4, 11}));
    }

    /**
     * Not everything starts from front and back pointers for two pointer problems
     * <p>
     * Here we are using two pointers, however we are using the first one
     * to pave the way for the second that only gets incremented if we have found something
     * that isn't equal.
     * <p>
     * So if we found something at I that doesn't equal at the last good index (nextNonDuplicate-1)
     * then we overwrite it with what we found forward
     * then we increment the nextNonDuplicate
     * we can do this cause everything in the array is already sorted, so the dups are bunched up for us
     * <p>
     * We are building a sorted array as we go
     * <p>
     * Time: O(n)
     * Space: O(1)
     **/
    public static int remove3(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    // my version
    public static int remove(int[] arr) {
        int start = 1;
        int end = arr.length - 1;
        while (start < end) {
            int startVal = arr[start];
            if (arr[start - 1] >= startVal) {
                arr[start] = arr[end];
                end--;
            }
            start++;
        }
        return start;
    }
}
