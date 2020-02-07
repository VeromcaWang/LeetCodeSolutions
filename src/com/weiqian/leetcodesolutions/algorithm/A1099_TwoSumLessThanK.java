package com.weiqian.leetcodesolutions.algorithm;

import java.util.Arrays;

/*
 * 1099. Two Sum Less Than K
 * Given an array A of integers and integer K, return the maximum S
 * such that there exists i < j with A[i] + A[j] = S and S < K.
 * If no i, j exist satisfying this equation, return -1.
 *
 * Example 1:
 * Input: A = [34,23,1,24,75,33,54,8], K = 60
 * Output: 58
 * Explanation: We can use 34 and 24 to sum 58 which is less than 60.
 *
 * Example 2:
 * Input: A = [10,20,30], K = 15
 * Output: -1
 * Explanation: In this case it's not possible to get a pair sum less that 15.
 */
public class A1099_TwoSumLessThanK {

    /*
     * Approach 1:
     * Force solution without sorting  Time: O(n^2) Space: O(1)
     */
    public int twoSumLessThanK(int[] A, int K) {
        int res = -1;
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                if(A[i] + A[j] < K) {
                    if(A[i] + A[j] > res){
                        res = A[i] + A[j];
                    }
                }
            }
        }
        return res;
    }

    /*
     * Approach 2:
     * Sort before manipulating Time: O(n*log(n)) Space: O(n)
     *
     * Use 2 pointers, traverse from the left end and right end of this sorted array
     * if A[i] + A[j] < K, move the left pointer right towards
     * if A[i] + A[j] >= K, move the right pointer left towards
     * Each time update res
     *
     * --> we do not care where is the 2 proper values (their index)
     * --> we do not care what's the sum number A[i] + A[j] is when this loop ends
     * --> we only care the max res under the condition A[i] + A[j] < K
     * --> therefore, each time when A[i] + A[j] < K happens, we compare res and update res.
     */
    public int twoSumLessThanK2(int[] A, int K) {
        int res = -1;

        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;

        while(i < j){
            if(A[i] + A[j] < K){
                if(A[i] + A[j] > res){
                    res = A[i] + A[j];
                }
                i++;
            } else {
                j--;
            }
        }

        return res;
    }

    /*
     * Arrays.sort(T):
     * 1. Quick sort for primitive types: int, short, long, float, double. Time: O(n*log(n)) Space: O(n+n)
     * 2. Merge sort for Object types. Time: O(n*log(n)) Space: O(n)
     */
}
