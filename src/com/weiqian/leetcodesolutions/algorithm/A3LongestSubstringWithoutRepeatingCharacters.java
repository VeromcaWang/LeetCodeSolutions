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
 */
public class A3LongestSubstringWithoutRepeatingCharacters {

    /*
     * Sliding Window
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int res = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        for(int right = 0; right < s.length(); right++){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            int length = right - left + 1;
            res = length > res? length : res;
        }
        return res;
    }

}
