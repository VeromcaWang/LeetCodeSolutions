package com.weiqian.leetcodesolutions.algorithm;

public class A2AddTwoNumbers {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        ListNode p1 = l1;
        ListNode p2 = l2;
        boolean add = false;

        while(p1 != null && p2 != null){
            head.next = new ListNode(0);
            head = head.next;
            if(!add){
                if(p1.val + p2.val < 10){
                    head.val = p1.val + p2.val;
                } else {
                    int dig = (p1.val + p2.val) % 10;
                    head.val = dig;
                    add = true;
                }
            } else {
                if(p1.val + p2.val < 9){
                    head.val = p1.val + p2.val + 1;
                    add = false;
                } else {
                    int dig = (p1.val + p2.val + 1) % 10;
                    head.val = dig;
                }
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        if(p1 != null && p2 == null){
            while(p1 != null){
                head.next = new ListNode(0);
                head = head.next;
                if(!add){
                    head.val = p1.val;
                } else {
                    if(p1.val < 9){
                        head.val = p1.val + 1;
                        add = false;
                    } else {
                        int dig = (p1.val + 1) % 10;
                        head.val = dig;
                    }
                }
                p1 = p1.next;
            }
        } else if (p1 == null && p2 != null){
            while(p2 != null){
                head.next = new ListNode(0);
                head = head.next;
                if(!add){
                    head = p2;
                    break;
                } else {
                    if(p2.val < 9){
                        head.val = p2.val + 1;
                        add = false;
                    } else {
                        int dig = (p2.val + 1) % 10;
                        head.val = dig;
                    }
                }
                p2 = p2.next;
            }
        }

        if(add){
            head.next = new ListNode(1);
        }

        return res.next;
    }


    public static void main(String[] args){

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);

        ListNode res = addTwoNumbers(l1, l2);
        ListNode p = res;
        while(p != null){
            System.out.print(p.val + ", ");
            p = p.next;
        }


    }
}
