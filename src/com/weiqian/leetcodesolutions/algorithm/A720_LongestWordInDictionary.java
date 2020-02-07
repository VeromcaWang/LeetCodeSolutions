package com.weiqian.leetcodesolutions.algorithm;


import java.util.HashSet;
import java.util.Set;

/*
 * 720. Longest Word in Dictionary
 *
 * Given a list of strings words representing an English Dictionary,
 * find the longest word in words that can be built one character at a time by other words in words.
 * If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 *
 * If there is no answer, return the empty string.
 *
 * Example 1:
 * Input: words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 *
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 *
 *
 * Example 2:
 * Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 *
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary.
 * However, "apple" is lexicographically smaller than "apply".
 *
 * Note:
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 *
 */
public class A720_LongestWordInDictionary {

    public String longestWord(String[] words) {
        String res = "";
        Set<String> prefixes = new HashSet<>();

        // Step1: add all the words into the set
        for(String word: words){
            prefixes.add(word);
        }

        // Step2: for each words, if the set contains all of its prefixes, use it as the answer
        for(int i = 0; i < words.length; i++){
            boolean good = true;
            for(int j = words[i].length()-1; j > 0; j--){
                if(!prefixes.contains(words[i].substring(0, j))){
                    good = false;
                    break;
                }
            }
            if(good){
                // we want the smaller lexicographical one when 2 answers have same length
                // words[i].compareTo(res) < 0
                if(words[i].length() > res.length()
                        || (words[i].length() == res.length() && words[i].compareTo(res) < 0)){
                    res = words[i];
                }
            }
        }

        return res;
    }

}
