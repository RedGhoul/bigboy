package com.JavaAlgos.EPI.Medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * <p>
     * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
     * <p>
     * Note that division between two integers should truncate toward zero.
     * <p>
     * It is guaranteed that the given RPN expression is always valid. That means the expression would always
     * evaluate to a result, and there will not be any division by zero operation.
     * <p>
     * Example 1:
     * <p>
     * Input: tokens = ["2","1","+","3","*"]
     * Output: 9
     * Explanation: ((2 + 1) * 3) = 9
     * Example 2:
     * <p>
     * Input: tokens = ["4","13","5","/","+"]
     * Output: 6
     * Explanation: (4 + (13 / 5)) = 6
     * Example 3:
     * <p>
     * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
     * Output: 22
     * <p>
     * 0 17
     * <p>
     * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     * = ((10 * (6 / (12 * -11))) + 17) + 5
     * = ((10 * (6 / -132)) + 17) + 5
     * = ((10 * 0) + 17) + 5
     * = (0 + 17) + 5
     * = 17 + 5
     * = 22
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= tokens.length <= 104
     * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
     * <p>
     * <p>
     * ["2","1","+","3","*"]
     * The key to this problem is the stack
     **/
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> computation = new Stack<Integer>();

        // for loop
        for (int i = 0; i < tokens.length; i++) {
            String curVal = tokens[i];
            if (Character.isDigit(curVal.charAt(curVal.length() - 1))) {
                computation.push(Integer.parseInt(curVal));
                continue;
            }
            int a = computation.pop();
            int b = computation.pop();
            // GOT TO USE EQUALS FOR STRING Equality in java
            if (curVal.equals("+")) {
                //System.out.println("GOT CALL PLUS");
                computation.push((int) Math.floor(b + a));
            } else if (curVal.equals("-")) {
                computation.push((int) Math.floor(b - a));
            } else if (curVal.equals("*")) {
                computation.push(b * a);
            } else if (curVal.equals("/")) {
                computation.push((int) Math.floor(b / a));
            }

        }
        return computation.pop();
    }
}
