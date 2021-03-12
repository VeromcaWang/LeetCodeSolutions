package com.weiqian.leetcodesolutions.algorithm;

import com.weiqian.core.ListNode;
/*
 *  1669. Merge In Between Linked Lists
 *
 *  You are given two linked lists: list1 and list2 of sizes n and m respectively.
 *  Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 *
 *  Example 1:
 *  Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 *  Output: [0,1,2,1000000,1000001,1000002,5]
 *  Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place.
 *
 *  Example 2:
 *  Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 *  Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
 *
 *
 *  Constraints:
 *  3 <= list1.length <= 104
 *  1 <= a <= b < list1.length - 1
 *  1 <= list2.length <= 104
 *
 */
public class A1669_MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode end2 = list2;
        while(end2.next != null){
            end2 = end2.next;
        }

        ListNode beforeA = list1;
        ListNode afterB = list1;
        for(int i = 0; i < a-1; i++){
            beforeA = beforeA.next;
        }
        for(int i = 0; i < b+1; i++){
            afterB = afterB.next;
        }

        beforeA.next = list2;
        end2.next = afterB;

        return list1;
    }
}
