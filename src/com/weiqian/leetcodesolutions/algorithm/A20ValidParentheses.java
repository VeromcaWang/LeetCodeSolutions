package com.weiqian.leetcodesolutions.algorithm;

import java.util.Stack;

/*
 *  20. Valid Parentheses
 *
 *  Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 *  determine if the input string is valid.
 *
 *  An input string is valid if:
 *  1.Open brackets must be closed by the same type of brackets.
 *  2.Open brackets must be closed in the correct order.
 *
 *  Note that an empty string is also considered valid.
 *
 *  Example 1:
 *  Input: "()"
 *  Output: true
 *
 *  Example 2:
 *  Input: "()[]{}"
 *  Output: true
 *
 *  Example 3:
 *  Input: "(]"
 *  Output: false
 *
 *  Example 4:
 *  Input: "([)]"
 *  Output: false
 *
 *  Example 5:
 *  Input: "{[]}"
 *  Output: true
 */
public class A20ValidParentheses {

    /*
     * 从左到右把整个String过一遍，如果是做括号，放入stack，如果是右括号，从stack顶部拿出一个左括号来比较是否配对
     * 一旦任何括号不配对，返回FALSE
     * 一遍过完之后应该留下空的STACK
     */
    public boolean isValid(String s) {
        if (s == null) return true;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(!pair(top,c)) return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }

    public boolean pair(char a, char b){
        if((a == '(' && b == ')')
                || (a == '{' && b == '}')
                || (a == '[' && b == ']')) return true;
        return false;
    }
}
