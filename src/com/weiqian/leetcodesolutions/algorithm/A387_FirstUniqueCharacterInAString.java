package com.weiqian.leetcodesolutions.algorithm;

import java.util.HashMap;
import java.util.Map;

public class A387_FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }


    /*
     * 用array比HashMap省时间和空间，因为HashMap需要用到get和put，
     * get: 先用key算出hashCode(即存放的位置)，然后去那个位置取
     * put: 先用key算出hashCode(即存放的位置)，然后把东西放到那个位置上
     *
     * 如果hash函数设计的比较好，比较平静，也就是某个位置只有一个pair，那get/put时间复杂度是O(1)
     * Worst case: hash函数设计得不好，某个位置有很多个pair，甚至全部的pair都在同一个bucket，那么就需要在这个bucket内部的list里遍历
     * get时间复杂度就会变成O(n)
     *
     */
    public int firstUniqChar2(String s) {
        int[] chars = new int[256];

        for(char c : s.toCharArray()){
            chars[c]++;
        }

        for(int i = 0; i < s.length(); i++){
            if(chars[s.charAt(i)] == 1){
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar3(String s) {
        int[] chars = new int[26];

        for(char c : s.toCharArray()){
            chars[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            if(chars[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }

}
