package com.itheima.datastaructure.stack;

import java.util.LinkedList;

public class E02Leetcode150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String t : tokens) {
            if (t.equals("+")) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                stack.push(a + b);
            } else if (t.equals("-")) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                stack.push(a - b);
            } else if (t.equals("*")) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                stack.push(a * b);
            } else if (t.equals("/")) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

    }
}
