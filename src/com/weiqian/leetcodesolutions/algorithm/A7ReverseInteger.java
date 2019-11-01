package com.weiqian.leetcodesolutions.algorithm;


/*
 *  7. Reverse Integer
 *  Given a 32-bit signed integer, reverse digits of an integer.
 *
 *  Example 1:
 *  Input: 123
 *  Output: 321
 *
 *  Example 2:
 *  Input: -123
 *  Output: -321
 *
 *  Example 3:
 *  Input: 120
 *  Output: 21
 *
 *  Note:
 *  Assume we are dealing with an environment which could only store integers within
 *  the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem,
 *  assume that your function returns 0 when the reversed integer overflows.
 */
public class A7ReverseInteger {

    /*
     * A pure math problem.
     * But we need to check if res < -2^31 or res > 2^31 - 1
     */
    public static int reverse(int x) {
        boolean negative = (x < 0);
        x = Math.abs(x);
        int res = 0;

        while (x > 0){
            int dig = x % 10;
            x = x / 10;

            /*
             * Max is 0x7fffffff, last digit is 7.
             */
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && dig > 7)) {
                return 0;
            }
            res = res * 10 + dig;
        }

        if(negative){
            res *= -1;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }
}
