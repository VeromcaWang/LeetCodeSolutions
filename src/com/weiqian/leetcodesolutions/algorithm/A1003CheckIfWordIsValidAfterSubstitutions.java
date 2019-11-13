package com.weiqian.leetcodesolutions.algorithm;


import java.util.Stack;

/*
 * 1003. Check If Word Is Valid After Substitutions
 *
 * We are given that the string "abc" is valid.
 *
 * From any valid string V, we may split V into two pieces X and Y such that X + Y (X concatenated with Y)
 * is equal to V.  (X or Y may be empty.) Then, X + "abc" + Y is also valid.
 *
 * If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".
 * Examples of invalid strings are: "abccba", "ab", "cababc", "bac".
 *
 * Return true if and only if the given string S is valid.
 *
 * Example 1:
 * Input: "aabcbc"
 * Output: true
 * Explanation:
 * We start with the valid string "abc".
 * Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is "aabcbc".
 *
 * Example 2:
 * Input: "abcabcababcc"
 * Output: true
 * Explanation:
 * "abcabcabc" is valid after consecutive insertings of "abc".
 * Then we can insert "abc" before the last letter, resulting in "abcabcab" + "abc" + "c" which is "abcabcababcc".
 *
 * Example 3:
 * Input: "abccba"
 * Output: false
 *
 * Example 4:
 * Input: "cababc"
 * Output: false
 *
 */
public class A1003CheckIfWordIsValidAfterSubstitutions {

    /*
     *  Approach 1: replace "abc" util S becomes empty.
     */
    public static boolean isValid1(String S) {
        while (S.length() != 0){
            if(S.contains("abc")){
                S = S.replace("abc", "");
            } else {
                return false;
            }
        }
        return true;
    }

    /*
     *  Approach 2: Similar with 20. Valid Parentheses --> 基本一模一样
     *  用一个stack，每当遇到'a'或者'b'的时候就存入stack中， 每当遇到'c'，就从stack中pop出来看是不是b，
     *  然后再pop一个看是不是a，因为一定是a-->b-->c 的顺序循环，一旦不符合这个顺序，就返回false
     */
    public boolean isValid2(String S) {
        Stack<Character> stack = new Stack<>();

        for(char c: S.toCharArray()){
            if(c != 'c'){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                if(stack.pop() != 'b') return false;
                if(stack.isEmpty()) return false;
                if(stack.pop() != 'a') return false;
            }
        }

        if(stack.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args){
        System.out.println(isValid1("abababccabcc"));
    }
}
