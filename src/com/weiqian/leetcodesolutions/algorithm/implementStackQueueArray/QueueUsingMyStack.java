package com.weiqian.leetcodesolutions.algorithm.implementStackQueueArray;

import java.util.StringJoiner;

public class QueueUsingMyStack {

    StackUsingArrays stack1;
    StackUsingArrays stack2;
    int front;

    /** Initialize your data structure here. */
    public QueueUsingMyStack() {
        stack1 = new StackUsingArrays();
        stack2 = new StackUsingArrays();
    }

    /** Push element x to the back of queue. */
    public void enQueue(int x) {
        stack1.push(x);
        if(stack1.index == 1){
            front = x;
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int deQueue() {
        while(stack1.index > 1){
            stack2.push(stack1.pop());
        }
        int res = stack1.pop();

        if(stack2.index > 0){
            front = stack2.pop();
            stack1.push(front);
        }

        while(stack2.index > 0){
            stack1.push(stack2.pop());
        }

        return res;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
    }

}
