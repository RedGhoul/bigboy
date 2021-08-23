package com.JavaAlgos.Jose;

import java.util.HashMap;
import java.util.Map;

public class FindMissingElement {
    public static void main(String[] args){
        System.out.println(findMissingElement(new int[]{1,2,3,4,5,6,7}, new int[]{3,7,2,1,4,6}) + " is the missing number");
        System.out.println(findMissingElement(new int[]{5,5,7,7}, new int[]{5,7,7}) + " is the missing number");
    }
/**
 *     Option 1: You could use a sort and then compare the two. Would be O(n*log(n)) but less memory
 *
 *     Option 2: Create hashmaps on the smaller array first - faster but less memory
 *
 *     Option 3: If there aren't any doubles, you could sum each array and find the diff.
 *
 *     Option 4: XOR it: Linear time and constant space - If we XOR a number with
 *     some number an odd number of times, there will be no effect. The extra number without its pair
 *     in the second array will cause the result to be that number.
 *     http://www.ardendertat.com/2011/09/27/programming-interview-questions-4-find-missing-element/
 *
 *     Assuming: Assuming there is only one element in the array that is missing.
 * */

    public static int findMissingElement(int[] array1, int[] array2){
        // going with option 2
        int[] smallArray = array1;
        int[] bigArray = array2;
        if(array1.length < array2.length){
            smallArray = array1;
            bigArray = array2;
        }else{
            smallArray = array2;
            bigArray = array1;
        }
        HashMap<Integer, Integer> hashForSmallArray = new HashMap<>();
        for(int i = 0; i < smallArray.length; i++){
            int curInt = smallArray[i];
            if(hashForSmallArray.containsKey(curInt)) {
                hashForSmallArray.put(curInt,  hashForSmallArray.get(curInt) + 1);
            }else{
                hashForSmallArray.put(curInt, 1);
            }

        }

        HashMap<Integer, Integer> hashForBigArray = new HashMap<>();
        for(int i = 0; i < bigArray.length; i++){
            int curInt = bigArray[i];
            if(hashForBigArray.containsKey(curInt)) {
                hashForBigArray.put(curInt,  hashForBigArray.get(curInt) + 1);
            }else{
                hashForBigArray.put(curInt, 1);
            }

        }

        for(Map.Entry<Integer, Integer> map: hashForBigArray.entrySet()){
            if(!hashForSmallArray.containsKey(map.getKey()) || !hashForSmallArray.get(map.getKey()).equals(map.getValue())){
                return map.getKey();
            }
        }

        return 0;
    }
}
