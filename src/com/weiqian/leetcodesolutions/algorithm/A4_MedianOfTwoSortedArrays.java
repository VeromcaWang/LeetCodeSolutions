package com.weiqian.leetcodesolutions.algorithm;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 *
 */

public class A4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // always keep nums1 is the shorter one
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length;
        int n = nums2.length;

        int start = 0;
        int end = m;

        while(start <= end){
            int p1 = (start + end)/2; // median index of nums1
            int p2 = (m + n + 1)/2 - p1; // median index of

            int maxL1 = p1 == 0 ? Integer.MIN_VALUE : nums1[p1-1];
            int maxL2 = p2 == 0 ? Integer.MIN_VALUE : nums2[p2-1];
            int minR1 = p1 == m? Integer.MAX_VALUE : nums1[p1];
            int minR2 = p2 == n? Integer.MAX_VALUE : nums2[p2];

            if(maxL1 <= minR2 && maxL2 <= minR1){
                if((m+n)%2 == 0) return (double)(Math.max(maxL1, maxL2)+Math.min(minR1, minR2))/2;
                else return (double)Math.max(maxL1, maxL2);
            } else if(maxL1 > minR2) end = p1-1;
            else start = p1+1;
        }
        return 0.0;

    }
}
