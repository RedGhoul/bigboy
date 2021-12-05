package com.JavaAlgos.AlgoMonster;

public class FindingBoundaryWithBinarySearch {
    /**
     * An array of boolean values is divided into two sections; the left section consists of all false
     * and the right section consists of all true. Find the boundary of the right section, i.e.
     * the index of the first true element. If there is no true element, return -1.
     * <p>
     * Input: arr = [false, false, true, true, true]
     * <p>
     * Output: 2
     * <p>
     * Explanation: first true's index is 2.
     * <p>
     * binary search is better than going through the array looking for any change in i & i + 1 which would
     * result in O(n) time complexity, whereas binary search would always be O(Log(N))
     * <p>
     * we don't want to return the second we find the "true"
     * <p>
     * we only want to return the index of the boundary at the very end
     * binary search ends up fixating on middle by cutting stuff in half so it will
     * center at the left most true so we just have to record it ever time
     **/
    public static void main(String[] args) {
        System.out.println(findBoundary(new boolean[]{false, false, false, true, true}));
    }

    public static int findBoundary(boolean[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int boundaryVal = -1;
        while (low <= high) {
            int midPoint = low + ((high - low) / 2);
            boolean curVal = arr[midPoint];
            if (curVal == false) {
                //boundaryVal = midPoint;
                // you could do it here and get where the boundary is will false
                low = midPoint + 1;
            } else {
                // this means we have found a true
                // that is why we are setting boundaryVal to what ever the midpoint was
                // putting it here because we want the boundary of true
                boundaryVal = midPoint;
                high = midPoint - 1;
            }
        }

        return boundaryVal;
    }

}
