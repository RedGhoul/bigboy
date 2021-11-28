package com.JavaAlgos.EPI.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortAAlmostSortedArray {
    /**
     * Inputs: Array of ints, int K (K places away from where it should it be)
     * Output: The array of sorted ints
     **/


    public static void main(String[] args) {
        System.out.println(
                SortAAlmostSortedArray.SortApproximatelySortedData(new int[]{3, -1, 2, 6, 4, 5, 8}, 2));
        System.out.println(
                SortAAlmostSortedArray.SortApproximatelySortedData2(new int[]{3, -1, 2, 6, 4, 5, 8}, 2));
    }

    /**
     * The reason that this works out to be a better, is cause its O(n*Log(k)) instead of O(n*log(n))
     * Because we will only ever have K values in the min heap at any given time
     * So every insertion and deletion will be log(k) time complexity
     * <p>
     * But then you need K things in the min heap because all K elements are k distances apart in sorted order
     * So it's the min number of things to keep in the min heap to make sure the value on top is actually the min
     * <p>
     * So you simply need to add and then remove a new value to keep K elements in the min heap
     * <p>
     * Let say you put one thing in there
     * then another thing
     * then pull one out
     * is that the smallest in the array ??? no it isn't to actually say it is you need another one
     * cause they are sorted K places apart
     **/
    public static List<Integer> SortApproximatelySortedData(
            int[] inputData, int placesAwayFromTheSort) {
        ArrayList<Integer> finalAnswer = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i;
        for (i = 0; i < placesAwayFromTheSort; i++) {
            minHeap.add(inputData[i]);
        }
        while (i < inputData.length) {
            minHeap.add(inputData[i]);
            finalAnswer.add(minHeap.poll());
            i++;
        }

        while (!minHeap.isEmpty()) {
            finalAnswer.add(minHeap.poll());
        }

        return finalAnswer;

    }

    public static List<Integer> SortApproximatelySortedData2(
            int[] inputData, int placesAwayFromTheSort) {
        ArrayList<Integer> finalAnswer = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        while (i < inputData.length) {
            minHeap.add(inputData[i]);
            //finalAnswer.add(minHeap.poll());
            i++;
        }

        while (!minHeap.isEmpty()) {
            finalAnswer.add(minHeap.poll());
        }

        return finalAnswer;

    }
}
