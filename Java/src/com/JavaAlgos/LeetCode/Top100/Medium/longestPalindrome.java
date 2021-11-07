package com.JavaAlgos.LeetCode.Top100.Medium;

public class longestPalindrome {
    /**
     * So two main things:
     *
     * Figuring out what the solution is
     * - Get more experience with seeing a bunch of problems
     * - getting a fundamental understanding of the idea in the problem
     * - getting an understanding of what the final runtime complexity would look like
     *
     * statement
     * For example:
     * - What makes a palindrome, a palindrome ?
     * - How do figure out if a string is a palindrome ?
     *
     * Implementing the solution
     * - this part should be lighting fast
     * - really need to know you lang really well, and it is standard libraries
     *
     *
     * I didn't do any of that for this question, I just talked a lot and didn't really
     * THINK ! Just kind of went to the easiest thing possible
     *
     * This problem can be solved in two non DP ways:
     * Way 1:
     * you know if something is a palindrome if it's equal to its reversed self
     * So why don't you reverse the input string, and find the longest matching substring in it ?
     * also make sure you verify that the substring is a palindrome
     *
     * Way 2:
     * You also know that you can know if something is a palindrome, not just from the outside in,
     * but also from the inside out. So you can treat ever value in the string as a center,
     * and try to expand out. And try to find the biggest palindromic substring that way.
     *
     * **/

    //weird hybrid approach of stuff I saw online and in the leetcode solution
    // time O(n^2), space O(1) - "substring" doesn't count as copy over
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        int startf = 0;
        int endf = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            start = i;
            end = i;
            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                if((end-start+1) > max){
                    max = end-start+1;
                    startf = start;
                    endf = end;
                }
                start--;
                end++;
            }
            // for the even plaindrome case
            start = i;
            end = i+1;
            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                if((end-start+1) > max){
                    max = end-start+1;
                    startf = start;
                    endf = end;
                }
                start--;
                end++;
            }


        }

        return s.substring(startf,endf+1);
    }

}
