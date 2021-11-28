package com.JavaAlgos.EPI.EPIMagic;

import java.util.HashMap;
import java.util.List;

public class FindTheNearestRepeatedEntriesInAnArray {
    /**
     * Already kind of went over this in my talks. So won't really try to explain it here
     * I need a break lol
     ***/

    public static int find(List<String> words) {
        if (words == null || words.isEmpty()) return -1;

        int smallestDistance = Integer.MAX_VALUE;
        HashMap<String, Integer> distanceBag = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String curVal = words.get(i);
            if (distanceBag.containsKey(curVal)) {
                smallestDistance = Math.min(smallestDistance, i - distanceBag.get(curVal));
            }

            distanceBag.put(curVal, i);
        }

        if (smallestDistance == Integer.MAX_VALUE) return -1;
        return smallestDistance;
    }
}
