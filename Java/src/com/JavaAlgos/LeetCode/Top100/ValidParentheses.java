package com.JavaAlgos.LeetCode.Top100;
import java.util.*;
public class ValidParentheses {
    /**
         Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

         An input string is valid if:

         Open brackets must be closed by the same type of brackets.
         Open brackets must be closed in the correct order.


         Example 1:

         Input: s = "()"
         Output: true
         Example 2:

         Input: s = "()[]{}"
         Output: true
         Example 3:

         Input: s = "(]"
         Output: false
         Example 4:

         Input: s = "([)]"
         Output: false
         Example 5:

         Input: s = "{[]}"
         Output: true


         Constraints:

         1 <= s.length <= 104
         s consists of parentheses only '()[]{}'. <-- important

        Problem Key:
        Just use a stack
        Keep adding things till you see the closing brace type
        You can do it in a single loop


        Mistake:
         Forgot to treat the stack like a stack. Once things are taken off the stack
         They should be gone for good. Should have used "Remove" instead of "Get" on ArrayList

         Follow your instincts, you should have checked the length of the string. If its only one
         then you should have returned a false

         Only when the stack is empty should I ever return true
     **/
    public static void main(String[] args){
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("{"));
        System.out.println(isValid("{{"));
    }

    public static boolean isValidV0(String s) {
        if(s.isEmpty()) return false;
        ArrayList<String> stack = new ArrayList<>();
        HashMap<String,String> bracketLookUp = new HashMap<>();
        bracketLookUp.put("]","[");
        bracketLookUp.put("}","{");
        bracketLookUp.put(")","(");

        String[] input = s.split("");
        for(int i =0; i < input.length; i++){
            String curValue = input[i];
            if(bracketLookUp.containsKey(curValue)){
                if(stack.isEmpty()) return false;
                String leftBracket = stack.get(stack.size()-1);
                if(!leftBracket.equals(bracketLookUp.get(curValue))) return false;
            }else{
                stack.add(curValue);
            }
        }
        return true;
    }

    public static boolean isValid(String s) {
        if(s.isEmpty() || s.length() == 1) return false;
        ArrayList<String> stack = new ArrayList<>();
        HashMap<String,String> bracketLookUp = new HashMap<>();
        bracketLookUp.put("]","[");
        bracketLookUp.put("}","{");
        bracketLookUp.put(")","(");

        String[] input = s.split("");
        for(int i =0; i < input.length; i++){
            String curValue = input[i];
            if(bracketLookUp.containsKey(curValue)){
                if(stack.isEmpty()) return false;
                String leftBracket = stack.remove(stack.size()-1);
                if(!leftBracket.equals(bracketLookUp.get(curValue))) return false;
            }else{
                stack.add(curValue);
            }
        }

        return stack.size() == 0;
    }
}
