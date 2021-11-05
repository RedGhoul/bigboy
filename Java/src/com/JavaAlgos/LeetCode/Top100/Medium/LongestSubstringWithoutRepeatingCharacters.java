package com.JavaAlgos.LeetCode.Top100.Medium;
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     could use:
     - Hashmap
     - a two pointer
     - some bit minipulation with unicode XOR

     Time: O(n)
     Space: O(n)


     examples

     exghjklal

     longestCount
     currentCount
     HashMap Buffer
     loop through string
     Check if char already in buffer
     currentCount = 1
     reset your buffer
     if it isnt't then put it in
     increment currentCount

     If it is then check to see if currentCount > longCount -
     if it is then set longestCount to that value

     return your longestCount

     int longestCount = INTERGER.MIN_VALUE;
     int currentCount = 0;

     String[] stringArray = s.split("");

     HashMap<String,Boolean> buffer = new HashMap<String,Boolean>();

     for(int i =0; i < stringArray.length; i++){
     String currentValue = stringArray[i];

     if(buffer.containsKey(currentValue)){
     currentCount = 1;
     buffer = new HashMap<String,Boolean>();
     }else{
     buffer.put(currentValue,true);
     currentCount += 1;
     }

     if(currentCount > longestCount){
     longestCount = currentCount;
     }
     }

     return longestCount;
     What I learned
     -- could also use "sets", keep it in your bag of tricks
     -- go in deep, don't use short variables, make them mean something next time
     -- keep the sliding window, in mind

     Thoughts:
     The reason your initial solution was soo slow was cause you weren't using a sliding window
     You went all the way back once you found a duplicate

     What You could have done better:
     Could have realized the massive runtime flaw and worked up a new solution, that was more space efficient.
     Instead, tried to make a bad solution better

     **/
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstringV1("abcagcbb"));
        System.out.println(lengthOfLongestSubstringV1("bbbbb"));
        System.out.println(lengthOfLongestSubstringV1("pwwkew"));
        System.out.println(lengthOfLongestSubstringV1("pwwkefgw"));
        System.out.println(lengthOfLongestSubstringV1("dvdf"));
        System.out.println(lengthOfLongestSubstringV1(""));
        System.out.println("-------------------------------");
        System.out.println(lengthOfLongestSubstringV2("abcagcbb"));
        System.out.println(lengthOfLongestSubstringV2("bbbbb"));
        System.out.println(lengthOfLongestSubstringV2("pwwkew"));
        System.out.println(lengthOfLongestSubstringV2("pwwkefgw"));
        System.out.println(lengthOfLongestSubstringV2("dvdf"));
        System.out.println(lengthOfLongestSubstringV2(""));
    }
    //
    public static int lengthOfLongestSubstringV1(String s) {
        if(s == null || s.length() == 0) return 0;
        /**
         * only thing you missed is the integer thing
         * should just be Integer, not INTERGER
         * **/
        int longestCount = Integer.MIN_VALUE;
        int currentCount = 0;

        HashMap<Character,Integer> buffer = new HashMap<Character,Integer>();
        /**
         * not much of sliding window
         * Your basically throwing away most of the work you ended up doing
         * every time you encounter a value you have already seen, you start
         * alllll the way from the beginning, by resetting your I value
         * **/
        for(int i =0; i < s.length(); i++){
            char currentValue = s.charAt(i);

            if(buffer.containsKey(currentValue)){
                i = buffer.get(currentValue) + 1;
                currentValue = s.charAt(i);
                currentCount = 1;
                buffer.clear();
                buffer.put(currentValue,i);

            }else{
                buffer.put(currentValue,i);
                currentCount += 1;
            }

            if(currentCount > longestCount){
                longestCount = currentCount;
            }
        }

        return longestCount;

    }
   // main idea behind this was sliding window

    public static int lengthOfLongestSubstringV2(String s) {
        if(s == null || s.length() == 0) return 0;
        /**
         * only thing you missed is the integer thing
         * should just be Integer, not INTERGER
         * **/
       int p1 = 0;
       int p2 = 0;
       // the two pointers represent your sliding window
       int max = 0;
       Set<Character> bag = new HashSet<>();
        // pwwjklpw
        //  1
        /**
         * It's not that we keep a contagious set of values in memory,
         * rather It's that we keep the count of contiguous uniques
         * */
       while(p2 < s.length()){
           if(bag.contains(s.charAt(p2))){
               /**
                * So if you have found something, just remove it,
                * Then increase the p1 by one
                * **/
               bag.remove(s.charAt(p1));
               p1++;
           }else{
               /**
                * If you didn't find it just add it to the bag
                * */
               bag.add(s.charAt(p2));
               p2++;
               max = Math.max(max,bag.size());
           }

       }
        return max;
    }
}
