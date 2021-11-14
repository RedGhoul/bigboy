package com.JavaAlgos.LeetCode.Top100.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static void main(String[] args){
        System.out.println(Arrays.toString(generateParenthesis(3).toArray()));
    }
    /**
     *
     * What do I really know about this ? It seems kind of like it just came from left field.
     *
     * It's asking for "combinations" so we know it's going to be a backtracking problem
     *
     * We have done a problem that is sort of like this before called "LetterCombinationsofaPhoneNumber",
     * can we apply anything we learned from that ?
     *
     * Yes we can. So another thing we know is that we can think of this kind of like a tree
     *
     * So lets get a bit more organized - Things we know:
     * - this is a backtracking problem
     * - your kind of going to have to go through some sort of tree
     * - it's going involve recursion
     * - going to have a sort of shell function,
     * and helper function same sort of deal with "LetterCombinationsofaPhoneNumber"
     * - pointers to switch things around
     *
     *
     * a, add to the state
     * b, backtrack
     * c, remove what you had just added, so you get
     * back to where you started from (before step a)
     *
     *
     * You really have to get the hang of how to draw the tree for this stufffff
     *
     * Cause if you draw the tree you will get the "the main logic that needs to be in the backtrack function"
     *
     * The main crux of the idea is that
     * you got to keep track of the open and closed braces
     * answer = []
     * stack = []
     *
     * if(numberofOpen == numberofClose && numberofClose == n){
     *   answer.add(stack.tostring())
     *   return
     * }
     * if the numberofOpen < n:
     *  add to stack ( "(" )
     *  backtrack(stack, numberofOpen+1, numberofClose)
     *  pop from the stack
     *
     *
     * if the numberofOpen > numberofClose:
     * add to stack ( ")" )
     * backtrack(stack, numberofOpen, numberofClose+1)
     * pop from the stack
     *
     *
     * return answer.tostring()
     *
     * time complexity is number of valid combos * depth of the tree (n)
     * space is o(n)
     *
     * Could I solve this ? no way, this was more out of left field for me again
     * Had to look at youtube video
     * **/


    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        gPHelper(answer,stack,0,0, n);
        return answer;
    }

    public static void gPHelper(List<String> answer, Stack<String> stack, int Open,int Closed, int max){
        if(Open == Closed && Closed == max){
            StringBuffer strbuffer = new StringBuffer();
            var arr = stack.toArray();
            for(int i = 0; i < arr.length; i++){
                strbuffer.append(arr[i]);
            }
            answer.add(strbuffer.toString());
            return;
        }

        if(Open < max){
            stack.add("(");
            gPHelper(answer,stack,Open+1,Closed,max);
            stack.pop(); // undo what we just did
        }

        if(Open > Closed){
            stack.add(")");
            gPHelper(answer,stack,Open,Closed+1,max);
            stack.pop(); // undo what we just did
        }

    }
}
