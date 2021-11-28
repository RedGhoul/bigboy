package com.JavaAlgos.EPI.Medium;

public class SearchInRotatedSortedArray {
    /**
     * Already did this problem a while ago on leet code
     * <p>
     * Gonna just practice implementing Binary Search now
     * 1
     * 127001
     **/

    public static int binS(int[] inputData, int value) {
        if (inputData.length == 0) return 0;
        int p1 = 0;
        int p2 = inputData.length - 1;

        while (p1 < p2) {
            int mid = p1 + ((p2 - p1) / 2);
            int midVal = inputData[mid];
            if (midVal == value) {
                return mid;
            }
            if (value < midVal) {
                p2 = mid - 1;
            } else if (value > midVal) {
                p1 = mid + 1;
            }
        }
        return -1;
    }
}
