package com.JavaAlgos.Colt;

import java.util.HashMap;
// Leet code - 3. Longest Substring Without Repeating Characters - Medium
public class FindLongestSubstring {
    public static void main(String[] args){
//        System.out.println(find(""));
//        System.out.println(find("rithmschool"));
        System.out.println(find2("thisisawesome"));
        System.out.println(find("thecatinthehat"));
        System.out.println(find("bbbbbbbbbbb"));
        System.out.println(find("longestsubstring"));
        System.out.println(find("thisishowwedoit"));
    }

    public static int find(String input){
        if(input.isEmpty()) return 0;
        HashMap<String,Integer> bag = new HashMap<>();
        int maxSub = Integer.MIN_VALUE;
        int curSub = 0;
        for(int i =0; i < input.length(); i++){
            maxSub = Math.max(maxSub,curSub);
            String curValue = String.valueOf(input.charAt(i));
            if(bag.containsKey(curValue)){
                curSub = 0;
                bag.clear();
            }
            curSub++;
            bag.put(curValue,1);
        }
        return maxSub;
    }
    /*
    *
    * This is a window with only one real point
and a incrementally moving forward point

A) this is where we reset our start cause we already saw it before, so the one after it
is what we are setting it to (what we did in B)

Makes a list of this is where you should point your start if you see me again, in the hash map

Then the length gets computed by subtracting the current index we are on from the current start value

B) last time we saw something like this + 1 so its one before it
    * */
    public static int find2(String input){
        if(input.isEmpty()) return 0;
        HashMap<String,Integer> bag = new HashMap<>();
        int max = 0;
        int start = 0;
        for(int i =0; i < input.length(); i++){

            String curValue = String.valueOf(input.charAt(i));
            if(bag.containsKey(curValue)){
                start = Math.max(start,bag.get(curValue));
            }

            max = Math.max(max,i - start + 1);

            bag.put(curValue,i + 1);
        }
        return max;
    }
}
