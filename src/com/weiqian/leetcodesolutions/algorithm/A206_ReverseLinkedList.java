package com.weiqian.leetcodesolutions.algorithm;

/* 206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 */
public class A206_ReverseLinkedList {

    /*
     *             head
     *              |
     *   null       1  -->  2  -->  3  -->  4  -->  5  -->  null
     *    |         |
     *   prev      cur
     *
     *                     head
     *                      |
     *   null       1  -->  2  -->  3  -->  4  -->  5  -->  null
     *    |         |
     *   prev      cur
     *
     *                     head
     *                      |
     *   null  <--  1       2  -->  3  -->  4  -->  5  -->  null
     *    |         |
     *   prev      cur
     *
     *                     head
     *                      |
     *   null  <--  1       2  -->  3  -->  4  -->  5  -->  null
     *              |
     *           prev,cur
     *
     *                     head
     *                      |
     *   null  <--  1       2  -->  3  -->  4  -->  5  -->  null
     *              |       |
     *             prev    cur
     *
     */
    public ListNode reverseListIteratively(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null) {
            head = head.next;
            cur.next = prev;
            prev = cur;
            cur = head;
        }

        return prev;
    }


    /*
     *   head
     *    |
     *    1  -->  2  -->  3  -->  4  -->  5  -->  null
     *
     *
     *   head
     *    |
     *    1  --> [ 2  -->  3  -->  4  -->  5  -->  null ]
     *             |
     *             m
     *
     *
     *   head
     *    |
     *    1  -->  null        [ 2  -->  3  -->  4  -->  5  -->  null ]
     *                          |
     *                          m
     *
     *
     *   head
     *    |
     *    1  -->  null         [ 5 (reversed list head) -->  4  --> 3  -->  2 -->  null ]
     *                           |                                          |
     *                           n                                          m
     *
     *
     *                                                       head
     *                                                        |
     *   [ 5 (reversed list head) -->  4  --> 3  -->  2 ] --> 1  -->  null
     *     |                                          |
     *     n                                          m
     *
     */
    public ListNode reverseListRecursively(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode m =head.next;
        head.next = null;
        ListNode n = reverseListRecursively(m);
        m.next = head;
        return n;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
