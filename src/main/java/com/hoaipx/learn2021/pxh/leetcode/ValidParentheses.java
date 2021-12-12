package com.hoaipx.learn2021.pxh.leetcode;


import java.util.Stack;

// Ref: https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

    public static void main(String... args) {
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }

        }

        return stack.isEmpty();
    }

    public static boolean isValidV2(String s) {
        int length = s.length();
        int half = length / 2;
        if (length % 2 != 0) return false;
        byte[] stack = new byte[half + 1];
        int pos = 0;
        for (int i = 0; i < length; i++) {
            byte ch = (byte) s.charAt(i);
            if (ch == 40 || ch == 91 || ch == 123) stack[pos++] = ch;
            else if (pos == 0 || (stack[--pos] / 40 != ch / 40)) return false;
            if (pos > half) return false;
        }
        return pos == 0;
    }
}