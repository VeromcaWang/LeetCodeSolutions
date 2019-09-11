package com.weiqian.leetcodesolutions.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 279. Perfect Square
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 *
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 */
public class A279PerfectSquare {

    /*
     * BFS Aproach:
     *
     * 1. Switch the number to a graph: each edge is a square number
     * 2. Use BFS to traverse each level
     * 3. To see how many edges we have gone through when we get a node "0"
     *
     *                   13
     *       (1*1)/  (2*2)|     \(4*4)
     *          12        9      4
     *       /  |  \   /  |  \   |  \
     *     11   8  5  8   5  0   3  0
     *
     */
    public int numSquares(int n) {
        List<Integer> queue = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(n);

        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int length = queue.size();
            for(int i = 0; i < length; i++){
                int currentNum = queue.remove(0);
                int root = 1;
                int square = 1;
                while(square <= currentNum){
                    if(square == currentNum){
                        return level;
                    }
                    int nextNum = currentNum - square;
                    if(set.add(nextNum)){
                        queue.add(nextNum);
                    }
                    root++;
                    square = root * root;
                }
            }
        }

        return level;
    }
}
