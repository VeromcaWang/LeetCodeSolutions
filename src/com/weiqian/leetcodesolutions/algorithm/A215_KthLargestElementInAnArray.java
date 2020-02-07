package com.weiqian.leetcodesolutions.algorithm;

import java.util.Arrays;


/* 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4  sorted: 1,2,2,3,3,4,5,5,6
 * Output: 4
 *
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 */

public class A215_KthLargestElementInAnArray {

    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }




    // Very Important
    // quick select Time O(n), Space O(1)
    public int findKthLargest2(int[] nums, int k) {

        // 抽取一个元素作为中心点，大的放左边，小的放右边，那么这个元素在数组中的位置m就表示它是第m大的元素
        // 然后去验证这个m是否等于k，如果m比k大，就再同样处理一次这个数左边的部分， m比k小就处理它右边

        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length-1;

        while(true){
            int pos = partition(nums, left, right);
            if(pos + 1 == k) return nums[pos];
            else if (pos + 1 > k) right = pos - 1;
            else left = pos + 1;
        }
    }

    public int partition(int[] nums, int left, int right){
        int pivot = nums[left]; // 真正快速排序的算法里，pivot一般是用到一个随机的函数，是一个随机的选择，这里我们直接用left也可以
        int l = left+1; // 因为left被用作pivot了，所以l从left+1开始
        int r = right;
        while(l <= r){
            if(nums[l] < pivot && nums[r] > pivot){
                swap(nums, l, r);
                l++;
                r--;
            }

            if(nums[l] >= pivot){
                l++;
            }

            if(nums[r] <= pivot){
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
