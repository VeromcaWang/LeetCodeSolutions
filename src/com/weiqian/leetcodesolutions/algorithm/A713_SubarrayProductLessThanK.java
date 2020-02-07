package com.weiqian.leetcodesolutions.algorithm;

/*
 * 713. Subarray Product Less Than K
 * Your are given an array of positive integers nums.
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 *
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 *
 */
public class A713_SubarrayProductLessThanK {

    /*
     * Force solution: Time O(n^2) Space O(n)
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int i = 0;
        int j = nums.length-1;

        while(i <= j){
            if(i < j){
                int prod = 1;
                for(int h = i; h < j+1; h++){
                    prod *= nums[h];
                    if(prod > k) break;
                }
                if(prod < k){
                    res++;
                }
                j--;
            } else {
                if(nums[i] < k){
                    res++;
                }
                i++;
                j = nums.length-1;
            }
        }
        return res;
    }


    /*
     * Slide Window: https://juejin.im/post/5cccc9d1f265da0384129e5f
     * With template
     */
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) return 0;
        int res = 0;
        int prod = 1;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            prod *= nums[right];
            while(prod >= k){
                prod /= nums[left];
                left++;
            }
            res += (right - left + 1);
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK2(nums, k));
    }
}

