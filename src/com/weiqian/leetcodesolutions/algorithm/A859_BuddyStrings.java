package com.weiqian.leetcodesolutions.algorithm;

/**
 *  859. Buddy Strings
 *  Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal,
 *  otherwise, return false.
 *
 *  Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and
 *  swapping the characters at s[i] and s[j].
 *
 *  For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 *
 *  Example 1:
 *  Input: s = "ab", goal = "ba"
 *  Output: true
 *  Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
 *
 *  Example 2:
 *  Input: s = "ab", goal = "ab"
 *  Output: false
 *  Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
 *
 *  Example 3:
 *  Input: s = "aa", goal = "aa"
 *  Output: true
 *  Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
 *
 *  Example 4:
 *  Input: s = "aaaaaaabc", goal = "aaaaaaacb"
 *  Output: true
 *
 */
public class A859_BuddyStrings {
    public boolean buddyStrings(String s, String goal) {

        // 1.1 check length - not equal - false
        if(s.length() != goal.length()) return false;

        // 1.2 length equal - check if the 2 strings are equal
        if(s.equals(goal)) { // 1.2.1 the 2 Strings are equal
            // Situation 1.2.1.#1 - s and goal are equal, then we need to make sure that there are
            // "at least" 2 characters in s (or goal) are the same, so we can swap them,
            // this will not cause any diff.
            int[] count = new int[26]; // record each character appears how many times

            for(int i = 0; i < s.length(); i++) { // iterate each character of "s"
                count[s.charAt(i) - 'a']++;
            }

            for(int c: count) { // iterate the count of each character
                if (c > 1) return true;
            }
            return false;

        } else {
            // Situation 1.2.1.#2 - s and goal are not equal, then we need to find the 2 indexes i and j,
            // which meet the condition: s[i] = goal[j] and s[j] = goal[i], except for the 2 indexes,
            // the characters on other positions should be exactly the same - therefore we can iterate
            // the characters on each postion - if meet diff, then record the index and the character.
            int indexI = -1;
            int indexJ = -1;

            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != goal.charAt(i)) {
                    if(indexI == -1) {
                        indexI = i;
                    } else if (indexJ == -1) {
                        indexJ = i;
                    } else { // there are more than 2 diff characters - no way to make the 2 strings the same
                        // by swapping only 2 characters.
                        return false;
                    }
                }
            }

            // After iterating the all the characters in s, and make sure there will no more
            // than 2 characters diff - then check if indexI and J are found (not equal to -1)
            return (indexI != -1
                    && indexJ != -1
                    && s.charAt(indexI) == goal.charAt(indexJ)
                    && s.charAt(indexJ) == goal.charAt(indexI));

        }
    }
}
