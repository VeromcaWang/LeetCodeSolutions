package com.weiqian.leetcodesolutions.algorithm;

/*
 *  9. Palindrome Number
 *  Determine whether an integer is a palindrome.
 *  An integer is a palindrome when it reads the same backward as forward.
 *
 *  Example 1:
 *  Input: 121
 *  Output: true
 *
 *  Example 2:
 *  Input: -121
 *  Output: false
 *  Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 *  Therefore it is not a palindrome.
 *
 *  Example 3:
 *  Input: 10
 *  Output: false
 *  Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 *  Follow up:
 *  Could you solve it without converting the integer to a string?
 */
public class A9PalindromeNumber {

    /*
     * Approach 1: convert the number to a string
     */
    public boolean isPalindrome1(int x) {
        if(x < 0) return false;
        String num = String.valueOf(x);
        for(int i = 0; i < num.length()/2; i++){
            if(num.charAt(i) != num.charAt(num.length()-1-i)){
                return false;
            }
        }
        return true;
    }



    /*
     * Approach 2: use A7ReverseInteger. Compare if the reversed number is the same.
     * For Follow up: without converting to a string.
     */
    public boolean isPalindrome2(int x) {
        if(x < 0) return false;
        int reversed = reverse(x);
        return x == reversed;
    }

    public int reverse(int x){
        int res = 0;
        while (x > 0){
            int dig = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && dig > 7)) {
                return -1;
            }
            res = res * 10 + dig;
        }
        return res;
    }


    /*
     * Approach 3: convert half of the number
     *
     */
    public boolean isPalindrome3(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int res = 0;
        while (x > res){
            int dig = x % 10;
            x = x / 10;
            res = res * 10 + dig;
        }
        return x == res || x == res/10;
    }
}
