package com.weiqian.leetcodesolutions.algorithm;

import com.weiqian.core.ListNode;

/*
 *  83. Remove Duplicates from Sorted List
 *
 *  Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 *  Return the linked list sorted as well.
 *
 *  Example 1:
 *  Input: head = [1,1,2]
 *  Output: [1,2]
 *
 *  Example 2:
 *  Input: head = [1,1,2,3,3]
 *  Output: [1,2,3]
 *
 *  Constraints:
 *  The number of nodes in the list is in the range [0, 300].
 *  -100 <= Node.val <= 100
 *  The list is guaranteed to be sorted in ascending order.
 *
 */
public class A83_RemoveDuplicatesFromSortedList {

    /*
     *    cur  cur.next
     *     |     |
     *     1 --> 1 --> 1 --> 2 --> null
     *     |
     *    head
     *
     *    cur     cur.next
     *     |         |
     *     1 --> (1) 1 --> 2 --> null
     *     |
     *    head
     *
     *     cur            cur.next
     *     |                 |
     *     1 --> (1) (1) --> 2 --> null
     *     |
     *    head
     *
     *                      cur
     *                       |
     *     1 --> (1) (1) --> 2 --> null
     *     |
     *    head
     *
     *                             cur
     *                              |
     *     1 --> (1) (1) --> 2 --> null
     *     |
     *    head
     *
     *   return  1 --> 2 --> null
     *
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            while(cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }

        return head;
    }
}
