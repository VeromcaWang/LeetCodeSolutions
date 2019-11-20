package com.weiqian.leetcodesolutions.algorithm;

/*
 *  62. Unique Paths
 *
 *  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *  The robot can only move either down or right at any point in time. The robot is trying to reach
 *  the bottom-right corner of the grid (marked 'Finish' in the diagram below). How many possible
 *  unique paths are there?
 *
 *  Example 1:
 *  Input: m = 3, n = 2
 *  Output: 3
 *  Explanation:
 *  From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 *  1. Right -> Right -> Down
 *  2. Right -> Down -> Right
 *  3. Down -> Right -> Right
 *
 *  Example 2:
 *  Input: m = 7, n = 3
 *  Output: 28
 */
public class A62UniquePaths {
    public int uniquePaths(int m, int n) {
        // f[i][j] = f[i-1][j] + f[j-1][i]
        int[][] f = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                // f[0][0] = 1;
                // f[0][1] = 1;
                // f[1][0] = 1;
                if(i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }

        return f[m-1][n-1];
    }
}
