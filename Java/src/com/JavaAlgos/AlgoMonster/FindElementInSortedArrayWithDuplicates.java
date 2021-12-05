package com.JavaAlgos.AlgoMonster;

import java.util.ArrayList;
import java.util.List;

public class FindElementInSortedArrayWithDuplicates {

    public static void main(String[] args) {
        ArrayList<Integer> gfg = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
                add(3);
                add(3);
                add(3);
                add(6);
                add(10);
                add(10);
                add(10);
                add(100);
            }
        };
        System.out.println(findFirstOccurrence(gfg, 3));
    }

    // if you want the left most thing you put it in the high
    // if you want the right most thing you put it in the low
    public static int findFirstOccurrence(List<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        int answer_index = -1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int value = arr.get(mid);
            if (value >= target) {
                answer_index = mid;
                high = mid - 1;
            } else {

                low = mid + 1;
            }
        }
        // we check if we actually found what we were looking for
        if (arr.get(answer_index) != target) return -1;
        return answer_index;
    }
}
