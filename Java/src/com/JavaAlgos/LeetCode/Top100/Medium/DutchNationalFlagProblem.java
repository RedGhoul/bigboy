package com.JavaAlgos.LeetCode.Top100.Medium;

public class DutchNationalFlagProblem {
    /**
     * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as
     * objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
     * <p>
     * The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also
     * consists of three different numbers that is why it is called Dutch National Flag problem.
     * <p>
     * Example 1:
     * <p>
     * Input: [1, 0, 2, 1, 0]
     * Output: [0, 0, 1, 1, 2]
     * Example 2:
     * <p>
     * Input: [2, 2, 0, 1, 2, 0]
     * Output: [0, 0, 1, 2, 2, 2,]
     * <p>
     * The key was the 3 in problem, "3" types of objects
     * <p>
     * And you know this is gonna be part of a two pointer problem
     * <p>
     * So then you say hey what if I put every zero behind a pointer,
     * and moved it up, every time I put a new 0
     * so now everything behind the first pointer (p1) is 0
     * <p>
     * Then if we do the same thing on the other side except for "2" using another pointer.
     * Using P1 minus P2 we get the length of the array that is still disorganized,
     * so we only have to integrate over that subsection
     * <p>
     * So while iterating, we will move all 0s before low and all 2s after
     * high so that in the end, all 1s will be between low and high.
     * <p>
     * Time: O(N)
     * Space: O(1)
     **/
    public static void main(String[] args) {
        sort(new int[]{1, 0, 2, 1, 0});
    }

    public static void sort(int[] arr) {
        if (arr == null) return;
        // for the zeros
        int zeroMarker = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[zeroMarker] != 0 && arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[zeroMarker];
                arr[zeroMarker] = temp;
                zeroMarker++;
            }
        }

        // for the twos
        int twoMarker = arr.length - 1;
        for (int i = arr.length - 1; i >= zeroMarker; i--) {
            if (arr[twoMarker] != 2 && arr[i] == 2) {
                int temp = arr[i];
                arr[i] = arr[twoMarker];
                arr[twoMarker] = temp;
                twoMarker--;
            }
        }
    }

    // they just did it in one big loop here
    public static void sortBigLoop(int[] arr) {
        // all elements < low are 0 and all elements > high are 2
        // all elements from >= low < i are 1
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                // increment 'i' and 'low'
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else { // the case for arr[i] == 2
                swap(arr, i, high);
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
            }
        }
    }

    // should have added swap function as well
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
