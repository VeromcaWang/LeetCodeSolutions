package com.weiqian.leetcodesolutions.algorithm;

import java.util.HashSet;
import java.util.Set;

/*
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 *    res = Math.max(l-r+1, res)
 *    res: 2
 *    set:
 *
 *       p   w    w   k   e   w
 *                l
 *                r
 */
public class A3_LongestSubstringWithoutRepeatingCharacters {

    /*
     * Sliding Window
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int res = 0;
        int left = 0;

        Set<Character> set = new HashSet<>();

        for(int right = 0; right < s.length(); right++){

            // if repeat detected, there exactly be 2 letters the same
            // one is the current "right" pointed letter
            // other one is on the left side of current letter
            // start from the left pointer, remove one by one, until the left repeat one is removed
            // then the window becomes start from the latest "left" pointer position and not repeat between left and right
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            // when set does not contain s.charAt(right)
            set.add(s.charAt(right));
            int length = right - left + 1;
            res = length > res? length : res;
        }
        return res;
    }

}
