package com.weiqian.leetcodesolutions.algorithm;

import java.util.PriorityQueue;


/* 378. Kth Smallest Element in a Sorted Matrix
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order
 * find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 */

public class A378_KthSmallestElementInSortedMatrix {

    //把matrix每一列看成一个链表，一共有matrix[0].length个链表，每次抛出所有表头中最小的一个
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(matrix.length, (a, b) -> a.val-b.val);//pq中的元素都是从小到大排序的，所以最小的一定是第一个，每次刨除最小的元素时就直接poll就好了

        //把第一行的所有元素加入pq中
        for(int i = 0; i < matrix.length; i++){
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }

        //poll出来k-1次
        for(int i = 0; i < k-1; i++){
            Tuple tp = pq.poll();
            if(tp.x == matrix.length-1) continue;
            pq.offer(new Tuple(tp.x + 1, tp.y, matrix[tp.x+1][tp.y]));
        }

        return pq.poll().val;
    }

    class Tuple{
        int x;
        int y;
        int val;
        //x,y 相当于matrix[i][j]的坐标，即x相当于i，y相当于j，val相当于matrix[i][j]
        //把每个元素写成tuple的形式

        public Tuple(int a, int b, int v){
            this.x = a;
            this.y = b;
            this.val = v;
        }
    }

}
