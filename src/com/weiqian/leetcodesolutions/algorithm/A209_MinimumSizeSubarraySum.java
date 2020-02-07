package com.weiqian.leetcodesolutions.algorithm;


/*
 * 209. Minimum Size Subarray Sum
 *
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 *
 * Example:
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 */
public class A209_MinimumSizeSubarraySum {

    public int minSubArrayLen1(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[] preSum = new int[nums.length+1];

        for(int i = 1; i < preSum.length; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < preSum.length; i++){
            for(int j = i+1; j < preSum.length; j++){
                if(preSum[j] - preSum[i] >= s){
                    int length = j - i;
                    if(length < res) res = length;
                }
            }
        }
        if(res == Integer.MAX_VALUE) res = 0;
        return res;
    }



}