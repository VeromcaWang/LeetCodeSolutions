package com.weiqian.leetcodesolutions.algorithm.implementStackQueueArray;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;

    /** Initialize your data structure here. */
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(queue1.size() > 1){
            queue2.add(queue1.remove());
        }
        int res = queue1.remove();

        while(queue2.size() > 0){
            int tmp = queue2.remove();
            queue1.add(tmp);
            top = tmp;
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.size() == 0;
    }
}
