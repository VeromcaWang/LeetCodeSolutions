package com.weiqian.leetcodesolutions.algorithm;

public class A520_DetectCapital {

    /*
     *  1.如果第一个字母大写：
     *    (1).后面的字母全大写
     *    (2).后面的字母全小写
     *  2.如果第一个字母小写：
     *    (1).后面的字母全小写
     *
     *  先判断第一个字母是否大写：
     *  大写 --> 判断第二个字母是否大写：
     *          --> 大写 --> 循环，一旦不是大写:false
     *          --> 小写 --> 循环，一旦不是小写:false
     *  小写 --> 循环，一旦不是小写:false
     */
    public boolean detectCapitalUse(String word) {
        if(word.length() < 2) return true;
        if(Character.isUpperCase(word.charAt(0))){
            if(Character.isUpperCase(word.charAt(1))) {
                for(int i = 2; i < word.length(); i++){
                    if(!Character.isUpperCase(word.charAt(i))) return false;
                }
            } else {
                for(int i = 2; i < word.length(); i++){
                    if(Character.isUpperCase(word.charAt(i))) return false;
                }
            }
        } else {
            for(int i = 1; i < word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }
}
