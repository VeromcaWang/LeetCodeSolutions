package com.weiqian.leetcodesolutions.algorithm;

import com.weiqian.core.ListNode;

/*
 *  1290. Convert Binary Number in a Linked List to Integer
 *
 *  Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *  Return the decimal value of the number in the linked list.
 *
 *  Example 1:
 *  Input: head = [1,0,1]
 *  Output: 5
 *  Explanation: (101) in base 2 = (5) in base 10
 *
 *  Example 2:
 *  Input: head = [0]
 *  Output: 0
 *
 *  Example 3:
 *  Input: head = [1]
 *  Output: 1
 *
 *  Example 4:
 *  Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 *  Output: 18880
 *
 *  Example 5:
 *  Input: head = [0,0]
 *  Output: 0
 *
 *
 *  Constraints:
 *  The Linked List is not empty.
 *  Number of nodes will not exceed 30.
 *  Each node's value is either 0 or 1.
 *
 */
public class A1290_ConvertBinaryNumberInALinkedListToInteger {

    /*
     *  Way to convert base 2 into base 10:
     *  from left to right:
     *  digital_1 *2 + digital_2
     *  ( digital_1 *2 + digital_2 ) *2 + digital_3
     *  ( ( digital_1 *2 + digital_2 ) *2 + digital_3 ) *2 + digital_4
     *  ... ...
     *
     *  Example: 1,0,1
     *  ( 1 *2 + 0 ) *2 + 1 = 5
     *
     *  Example: 1,1,0,1,0
     *  ( ( ( 1 *2 + 1 ) *2 + 0 ) *2 + 1 ) *2 + 0 = 26
     *
     */
    public int getDecimalValue1(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }

    /*
     *  Integer.parseInt(sb.toString(), 2) will parse base 2 into base 10
     *  Just need to convert the list into a string, we can call this method to get decimal value
     */
    public int getDecimalValue2(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
