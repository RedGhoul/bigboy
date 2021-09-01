package com.JavaAlgos.Jose;
import java.util.*;
public class BalancedParentheses {
    public static void main(String[] args){
        System.out.println(isBalanced("()"));
        System.out.println(isBalanced("{([])}"));
        System.out.println(isBalanced("[{])"));
    }

    /**
     * Option 1: using a stack
     * Assuming input string has no spaces
     */
    public static boolean isBalanced(String input){
        if(input == null || input.isEmpty()) return false;

        ArrayList<String> stack = new ArrayList<>();
        HashMap<String,String> mappings = new HashMap<>();
        mappings.put("}","{");
        mappings.put("]","[");
        mappings.put(")","(");
        String[] inputArray = input.split("");
        for(int i = 0; i < inputArray.length; i++){
            String curParam = inputArray[i];
            if(mappings.containsKey(curParam) && stack.size() > 0){
                String counterValue = stack.remove(stack.size()-1);
                if(!counterValue.equals(mappings.get(curParam))){
                    return false;
                }
            }else{
                if(curParam.equals("{") || curParam.equals("[") || curParam.equals("(")){
                    stack.add(curParam);
                }else{
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
