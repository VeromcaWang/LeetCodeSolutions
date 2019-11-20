package com.weiqian.leetcodesolutions.algorithm;


/*
 * 63. Unique Paths II
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output: 2
 *
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 */
public class A63UniquePathsII {

    /*
     * DP Approach: 62的变体
     *
     * 不一样的地方是：
     * 1. 当obstacleGrid [0][0] = 1时，return 0.
     * 2. f[0][j]和f[i][0]未必为1. --> 62中f[0][j]和f[i][0]都为1
     *    f[i][j] = (obstacleGrid[i][j] == 1)? 0 : f[i][j-1];
     *    f[i][j] = (obstacleGrid[i][j] == 1)? 0 : f[i-1][j];
     * 3. 当(i, j)有障碍时f[i][j] = 0，无障碍时f[i][j] = 通项公式(也就是f[i-1][j] + f[i][j-1])。
     *
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;

        // grid length, width
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // f[i][j] = f[i-1][j] + f[i][j-1]
        int[][] f = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    if(obstacleGrid[0][0] == 1) return 0;
                    f[i][j] = 1;
                } else if(i == 0){
                    f[i][j] = (obstacleGrid[i][j] == 1)? 0 : f[i][j-1];
                } else if(j == 0){
                    f[i][j] = (obstacleGrid[i][j] == 1)? 0 : f[i-1][j];
                } else {
                    f[i][j] = (obstacleGrid[i][j] == 1)? 0 : f[i-1][j] + f[i][j-1];
                }
            }
        }

        return f[m-1][n-1];
    }

    public static void main(String[] args){
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,1,0},{0,1,0},{0,0,0}}));
    }
}
