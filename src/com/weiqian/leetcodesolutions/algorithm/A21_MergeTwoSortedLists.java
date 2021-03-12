package com.weiqian.leetcodesolutions.algorithm;

import com.weiqian.core.ListNode;

/*
 *  21. Merge Two Sorted Lists
 *  Merge two sorted linked lists and return it as a sorted list.
 *  The list should be made by splicing together the nodes of the first two lists.
 *
 *  Example 1:
 *  Input: l1 = [1,2,4], l2 = [1,3,4]
 *  Output: [1,1,2,3,4,4]
 *
 *  Example 2:
 *  Input: l1 = [], l2 = []
 *  Output: []
 *
 *  Example 3:
 *  Input: l1 = [], l2 = [0]
 *  Output: [0]
 *
 *  Constraints:
 *  The number of nodes in both lists is in the range [0, 50].
 *  -100 <= Node.val <= 100
 *  Both l1 and l2 are sorted in non-decreasing order.
 *
 */
public class A21_MergeTwoSortedLists {

    /*
     *    l1                            l2
     *    |                             |
     *    1 --> 2 --> 4 --> null        1 --> 3 --> 4 --> null
     *
     *  list, head
     *    |
     *    0 --> null
     *
     *  list, head                         l2
     *    |                                |
     *    0 --> 1 --> 2 --> 4 --> null      1 --> 3 --> 4 --> null
     *          |
     *          l1
     *
     *  head   list                         l2
     *    |     |                           |
     *    0 --> 1 --> 2 --> 4 --> null      1 --> 3 --> 4 --> null
     *                |
     *                l1
     *
     *  head   list
     *    |     |
     *    0 --> 1 --> 1 --> 3 --> 4 --> null         2 --> 4 --> null
     *                |                              |
     *                l2                             l1
     *
     *  head         list
     *    |           |
     *    0 --> 1 --> 1 --> 3 --> 4 --> null         2 --> 4 --> null
     *                      |                        |
     *                      l2                       l1
     *
     *   head        list
     *    |           |
     *    0 --> 1 --> 1 --> 2 --> 4 --> null         3 --> 4 --> null
     *                      |                        |
     *                      l1                       l2
     *
     *   head              list
     *    |                 |
     *    0 --> 1 --> 1 --> 2 --> 4 --> null         3 --> 4 --> null
     *                            |                  |
     *                            l1                 l2
     *
     *   head              list
     *    |                 |
     *    0 --> 1 --> 1 --> 2 --> 3 --> 4 --> null       4 --> null
     *                            |                      |
     *                            l2                     l1
     *
     *   head                    list
     *    |                       |
     *    0 --> 1 --> 1 --> 2 --> 3 --> 4 --> null       4 --> null
     *                                  |                |
     *                                  l2               l1
     *
     *   head                    list
     *    |                       |
     *    0 --> 1 --> 1 --> 2 --> 3 --> 4 --> null       4 --> null
     *                                  |                |
     *                                  l1               l2
     *
     *   head                         list
     *    |                             |
     *    0 --> 1 --> 1 --> 2 --> 3 --> 4 --> null       4 --> null
     *                                         |         |
     *                                         l1        l2
     *
     *   head                         list
     *    |                             |
     *    0 --> 1 --> 1 --> 2 --> 3 --> 4 --> 4 --> null        null
     *                                        |                  |
     *                                        l2                 l1
     *
     *   return head.next
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode head = list;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                list.next = l1;
                l1 = l1.next;
            } else {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }

        if(l1 != null) {
            list.next = l1;
        }
        if(l2 != null) {
            list.next = l2;
        }
        return head.next;
    }

}
